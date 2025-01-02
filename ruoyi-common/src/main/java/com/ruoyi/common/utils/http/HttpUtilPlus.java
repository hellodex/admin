package com.ruoyi.common.utils.http;

import com.ruoyi.common.config.HttpReqConfig;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * TODO 类作用描述
 *
 * @author sbl
 * @date 2025/1/1
 */
@Component
public class HttpUtilPlus {

    private static final Logger log = LoggerFactory.getLogger(HttpUtilPlus.class);



    public static String sendPost(String url, String param)
    {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try
        {
            String channel = HttpReqConfig.getChannel();
            String version = HttpReqConfig.getVersion();
            String urlEnd = HttpReqConfig.getUrl() + url;

            log.info("sendPost - {}，{}，{}", urlEnd,channel,version);
            log.info("sendPost.param - {}", param);
            URL realUrl = new URL(urlEnd);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");

            //新增参数
            String ts = String.valueOf(System.currentTimeMillis());
            log.info("sendPost.ts - {}", ts);
            conn.setRequestProperty("Channel", channel);
            String s = calculateSign(ts);
            System.out.println("Sign===="+s);
            conn.setRequestProperty("Sign", s);
            conn.setRequestProperty("Ts", ts);
            conn.setRequestProperty("Version", version);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null)
            {
                result.append(line);
            }
            log.info("recv - {}", result);
            return result.toString();
        }
        catch (ConnectException e)
        {
            log.error("调用HttpUtils.sendPost ConnectException, url=" + url + ",param=" + param, e);
        }
        catch (SocketTimeoutException e)
        {
            log.error("调用HttpUtils.sendPost SocketTimeoutException, url=" + url + ",param=" + param, e);
        }
        catch (IOException e)
        {
            log.error("调用HttpUtils.sendPost IOException, url=" + url + ",param=" + param, e);
        }
        catch (Exception e)
        {
            log.error("调用HttpsUtil.sendPost Exception, url=" + url + ",param=" + param, e);
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
            }
        }
        return result.toString();
    }



    public static String calculateSign(String ts) {
        try {
            String channel = HttpReqConfig.getChannel();
            String version = HttpReqConfig.getVersion();
            String baseUrl = HttpReqConfig.getUrl();
            String key = HttpReqConfig.getKey();

            if(StringUtils.isEmpty(channel)||StringUtils.isEmpty(key)||StringUtils.isEmpty(version)||StringUtils.isEmpty(baseUrl)){
                throw new RuntimeException("HttpReqConfig is not complete");
            }
            // 使用 StringBuilder 进行安全的字符串拼接
            StringBuilder sb = new StringBuilder();
            sb.append(channel).append(ts).append(version).append(key);

            // 生成签名
            return sha256(sb.toString());
        } catch (Exception e) {
            // 异常处理
            System.err.println("Error calculating sign: " + e.getMessage());
            throw new RuntimeException("Error calculating sign", e);
        }
    }

    private static String sha256(String input) throws NoSuchAlgorithmException {
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
