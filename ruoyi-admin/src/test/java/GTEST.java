import com.ruoyi.common.utils.http.HttpUtilPlus;
import org.junit.Test;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.net.URI;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


/**
 * TODO 类作用描述
 *
 * @author sbl
 * @date 2024/12/29
 */
public class GTEST {

    @Test
    public void testUpload() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create("230809e883691230d42a7a28bdb34955", "f4117ff04686eb26b713f2400b3ce8a58f67dadd1c731e34790ea39d367cfd98");
        S3Client client = S3Client.builder()
                .endpointOverride(URI.create("https://186135074c4098b61c79d68639cc54f1.r2.cloudflarestorage.com"))
                .region(Region.of("auto"))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket("logo")
                .key("BSC/test222.jpg")
                .build();
        client.putObject(request, Paths.get("D:\\googleDownload\\test222.png"));
        client.close();
    }





    @Test
    public  void calculateSign1() throws NoSuchAlgorithmException {
        Long sys  = System.currentTimeMillis();
        System.out.println(sys);
        StringBuilder sb = new StringBuilder();
        sb.append(50000).append(sys).append(1.0).append("44af2492a5bd604ed0e39c700625e77ddad80f812ce1d249e98705efca35b9d3");
        System.out.println(sha256(sb.toString()));

    };

    private  String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
