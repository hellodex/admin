package com.ruoyi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO 类作用描述
 *
 * @author sbl
 * @date 2025/1/1
 */
@Component
@ConfigurationProperties(prefix = "http")
public class HttpReqConfig {

    private static String url;
    private static String channel;
    private static String key;
    private static String version;

    // 提供 setter 方法用于属性注入
    public void setUrl(String url) {
        HttpReqConfig.url = url;
    }

    public void setChannel(String channel) {
        HttpReqConfig.channel = channel;
    }

    public void setKey(String key) {
        HttpReqConfig.key = key;
    }

    public void setVersion(String version) {
        HttpReqConfig.version = version;
    }

    // 提供静态 getter 方法
    public static String getUrl() {
        return url;
    }

    public static String getChannel() {
        return channel;
    }

    public static String getKey() {
        return key;
    }

    public static String getVersion() {
        return version;
    }
}


