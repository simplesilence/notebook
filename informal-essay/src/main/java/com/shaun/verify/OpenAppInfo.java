package com.shaun.verify;

//import lombok.Data;

//@Data
public class OpenAppInfo {

    /**
     * 应用名称
     */
    private String app_name;

    /**
     * 应用key
     */
    private String app_key;

    /**
     * 应用密钥
     */
    private String app_secret;

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    @Override
    public String toString() {
        return "OpenAppInfo{" +
                "app_name='" + app_name + '\'' +
                ", app_key='" + app_key + '\'' +
                ", app_secret='" + app_secret + '\'' +
                '}';
    }
}
