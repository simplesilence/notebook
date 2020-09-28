package com.shaun.verify;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * 签名
 */
public class SignUtil {

    private static final String BIZ_PARAM_KEY = "body_parameter";

    private static final String SIGN_KEY = "sign";

    /**
     * 签名
     * 根据传入的参数进行签名
     * @param request
     * @return
     */
    public static String sign(HttpServletRequest request, String secret){

        String sign = null;

        try {
            Map<String, String> pmap = new TreeMap<String, String>();

            // 获取query string参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                // sign不参与签名
                if(SIGN_KEY.equals(entry.getKey())) continue;
                // entry.getValue()为数组，默认query string不传入数组
                pmap.put(entry.getKey(), entry.getValue()[0]);
            }

            // 获取请求体参数
            String jsonBody = readAsChars(request);

            // jsonBody是json字符串
            if(null != jsonBody && !"".equals(jsonBody) && jsonBody.startsWith("{")){

                pmap.put(BIZ_PARAM_KEY, jsonBody);

            }
            // jsonBody是form url encoded
            else if(null != jsonBody && !"".equals(jsonBody)){

                String[] qfs = jsonBody.split("&");
                for (String qf : qfs) {
                    String[] entity = qf.split("=");
                    pmap.put(entity[0], entity[1]);
                }
            }

            System.out.println("待签名：" + pmap);

            sign = executeSign(pmap, secret);

            System.out.println("签名后：" + sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }


    /**
     * 打印请求体中raw指定格式文本
     * @param request
     * @return
     */
    private static String readAsChars(HttpServletRequest request) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /**
     * 参数签名
     * @param pmap 参与签名的参数
     * @param appSecret 签名的密钥
     * @return 签名后的字符串
     * @throws Exception
     */
    private static String executeSign(Map<String, String> pmap, String appSecret) throws Exception {
        StringBuilder sb = new StringBuilder(appSecret);

        for (Map.Entry<String, String> entry : pmap.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtil.areNotEmpty(name, value)) {
                sb.append(name).append(value);
            }
        }

        sb.append(appSecret);
        String result = CodecUtil.md5(sb.toString());

        return result;
    }
}
