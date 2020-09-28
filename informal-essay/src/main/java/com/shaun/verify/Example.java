package com.shaun.verify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Example {

    /**
     * 签名测试
     * @param args
     */
    public static void main(String[] args) {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String qString = "app_key=f56009d8-88b7-4fcd-a30b-508c50d1ea39" +
                "&method=apiMethod" +
                "&timestamp=" + date + "" +
                "&format=json" +
                "&v=1.0";

        String jsonBody = "{\"jsonKey1\":\"jsonVal1\"}";

        String secret = "c7db5c1a-b4e1-4513-a0d1-2325b38f98d4";

//        System.out.println(SignUtil.sign(qString, jsonBody, secret));
    }
}
