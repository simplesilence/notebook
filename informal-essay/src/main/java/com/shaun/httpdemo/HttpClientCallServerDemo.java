package com.shaun.httpdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shaun.common.MD5Util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 妙保在线问诊测试
 */
public class HttpClientCallServerDemo {

    private static final String MB_URL = "https://miusapitest.miaoinstech.com/";

    private static final String APP_CODE = "CIICS_ONLINE_INQUIRY";

    private static final String APP_KEY = "123456";

    /**
     * 获取妙保token
     *
     * {
     *     "code": 0,
     *     "msg": "success",
     *     "data": {
     *         "id": "1368827043223838722",
     *         "token": "463e37797bd843ab94ff2314e49ca81b"
     *     }
     * }
     */
    private static String getMiaoBaoToken(String memberId){
        HttpURLConnection connection = null;
        OutputStream dataout = null;
        BufferedReader reader = null;
        String line = null;
        String token = "";
        try {
            URL url = new URL(MB_URL + "api/user/login/third");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            String sign = MD5Util.getMD5("appCode="+APP_CODE+"&appkey="+APP_KEY+"&thirdUserId="+memberId);
            dataout = new DataOutputStream(connection.getOutputStream());
            String body = "{\"appCode\":\""+APP_CODE+"\",\"thirdUserId\":\""+memberId+"\",\"sign\":\""+sign+"\"}";
            dataout.write(body.getBytes());
            dataout.flush();
            dataout.close();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder result = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                JSONObject jsonObject = JSON.parseObject(result.toString());
                JSONObject data = jsonObject.getJSONObject("data");
                token = null != data ? data.getString("token") : "";
            }
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
        return token;
    }

    /**
     * 获取妙保在线问诊的url
     *
     * token为空：
     * {
     *     "code": 10020,
     *     "msg": "token cannot be empty",
     *     "data": null
     * }
     * token失效：48c7cd9fb2ce4cca9e87abfc0a24c2ec
     * {
     *     "code": 10021,
     *     "msg": "token is invalid, please log in again",
     *     "data": null
     * }
     * success:
     *{
     *     "code": 0,
     *     "msg": "success",
     *     "data": {
     *         "url": "https://miao-ins.udesk.cn/im_client/?web_plugin_id=164211&group_id=275651......"
     *     }
     * }
     */
    private static String getMiaoBaoUrl(String memberId){
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String line = null;
        String mb_online_url = "";
        try {
            URL url = new URL(MB_URL + "api/im/udesk/inter?interfaceCode=online_inquiry");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("token", getMiaoBaoToken(memberId));
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder result = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                JSONObject jsonObject = JSON.parseObject(result.toString());
                JSONObject data = jsonObject.getJSONObject("data");
                mb_online_url = null != data ? data.getString("url") : "";
            }
            return mb_online_url;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
        return mb_online_url;
    }

    public static void main(String[] args) {
        System.out.println(getMiaoBaoUrl("01"));
    }
}
