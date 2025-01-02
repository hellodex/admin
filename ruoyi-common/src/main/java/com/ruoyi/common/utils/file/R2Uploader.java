package com.ruoyi.common.utils.file;

import com.ruoyi.common.config.CloudFlareConfig;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class R2Uploader {

    private S3Client client;

    @Autowired
    private CloudFlareConfig cloudFlareConfig;

    @PostConstruct
    public void init() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(cloudFlareConfig.getAccessKeyId(), cloudFlareConfig.getAccessSecret());
        client = S3Client.builder()
                .endpointOverride(URI.create("https://" + cloudFlareConfig.getAccountId() + ".r2.cloudflarestorage.com"))
                .region(Region.of("auto"))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    public void uploadImg(String dir,String bucket, MultipartFile file) throws IOException {
        if (StringUtils.isEmpty(dir) || StringUtils.isEmpty(file.getOriginalFilename())) {
            throw new IllegalArgumentException("Directory or filename cannot be empty");
        }

        try {
            // 将MultipartFile转换为临时文件
            File tempFile = Files.createTempFile("upload-", file.getOriginalFilename()).toFile();
            file.transferTo(tempFile);

            // 创建上传请求
            PutObjectRequest putRequest = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(dir)
                    .build();

            // 上传文件到R2
            PutObjectResponse putObjectResponse = client.putObject(putRequest, tempFile.toPath());

            // 判断上传是否成功
            if (putObjectResponse == null) {
                throw new RuntimeException("上传失败: PutObjectResponse 为 null");
            }

            // 检查 ETag
            String eTag = putObjectResponse.eTag();
            if (StringUtils.isEmpty(eTag)) {
                throw new RuntimeException("上传失败: ETag 为空");
            }

            // 如果启用了版本控制，可以检查 versionId
            String versionId = putObjectResponse.versionId();
            if (StringUtils.isEmpty(versionId)) {
                throw new RuntimeException("上传失败: VersionId 为空");
            }
        } catch (AwsServiceException | SdkClientException e) {
            // 处理异常
            throw new RuntimeException("上传失败: " + e.getMessage());
        } finally {
            // 删除临时文件
            File tempFile = Files.createTempFile("upload-", file.getOriginalFilename()).toFile();
            if (tempFile.exists()) {
                Files.delete(tempFile.toPath());
            }
        }
    }

    public List<String> listDir(String bkt) {
        if (StringUtils.isEmpty(bkt)) {
            throw new IllegalArgumentException("Bucket name cannot be empty");
        }

        ListObjectsRequest request = ListObjectsRequest.builder()
                .bucket(bkt)
                .build();
        List<S3Object> contents = client.listObjects(request).contents();

        return contents.stream()
                .map(S3Object::key)
                .filter(StringUtils::isNotBlank)
                .map(key -> key.split("/")[0])
                .filter(StringUtils::isNotBlank)
                .distinct()
                .collect(Collectors.toList());
    }
}
