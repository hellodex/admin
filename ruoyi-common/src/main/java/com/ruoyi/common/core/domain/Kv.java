package com.ruoyi.common.core.domain;

/**
 * TODO 类作用描述
 *
 * @author sbl
 * @date 2025/1/1
 */
public class Kv {
    private String key;
    private String value;


    public Kv( ) {

    }

    public Kv(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
