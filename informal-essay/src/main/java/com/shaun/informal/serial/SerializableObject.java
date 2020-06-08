package com.shaun.informal.serial;

import java.io.Serializable;

/**
 * 序列化类测试
 */
public class SerializableObject implements Serializable {

    private String str0;
    private transient String str1;
    private static String str2 = "abc";

    public SerializableObject(String str0, String str1) {
        this.str0 = str0;
        this.str1 = str1;
    }

    public String getStr0() {
        return str0;
    }

    public String getStr1() {
        return str1;
    }
}
