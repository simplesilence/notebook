package com.shaun.verify;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 生成APP_KEY、APP_SECRET
 */
public class AppKeyAndSecretGenerateUtil {

    /**
     * 测试生成
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("APP_KEY：" + generateAppSecret());

        System.out.println("APP_SECRET：" + md5AppKey(369541001938731009L, System.currentTimeMillis()));
    }

    /**
     * 生成密钥
     * @return
     */
    public static String generateAppSecret() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }


    /**
     * 生成APP_KEY
     * @param id
     * @param timestamp
     * @return
     */
    public static String md5AppKey(long id, long timestamp) {

        String str = "domain.com";

        StringBuffer sb = new StringBuffer();
        sb.append(id);
        sb.append(timestamp);
        sb.append(str);

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String result = null;
        try {
            result = byte2hex(md.digest(sb.toString().getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    static String byte2hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (int index = 0, len = bytes.length; index <= len - 1; index += 1) {

            String invalue1 = Integer.toHexString((bytes[index] >> 4) & 0xF);
            String intValue2 = Integer.toHexString(bytes[index] & 0xF);
            result.append(invalue1);
            result.append(intValue2);
        }
        return result.toString();
    }
}
