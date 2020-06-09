package com.shaun.serverdemo;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Enumeration;
import java.util.Map;

/**
 * Post 对query string 和 请求体 requestBody（request payload 和 form data）的例子
 *  FormData和Payload是浏览器传输给接口的两种格式，
 *  这两种方式浏览器是通过Content-Type来进行区分的(了解Content-Type)，
 *  如果是 application/x-www-form-urlencoded的话，则为form-data方式，
 *  如果是application/json或multipart/form-data的话，则为 request payload的方式。
 */
@RestController
@RequestMapping("/post")
public class PostServerController {


    /** TODO post 对query string的处理和 get 请求一样，不讲 */





    /** ========================= post 请求 request payload 方式 ============================== */

    /**
     * post 接收请求体数据
     * example of request payload
     * @param queryStr
     */
    @PostMapping("/testMethod1")
    public void testMethod1(HttpServletRequest request, String queryStr) throws IOException {

        System.out.println("############################# 华丽分割线 ###############################");

        System.out.println("======= 打印请求头 =======");

        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name + ":" + request.getHeader(name));
        }

        System.out.println("======= 打印参数 =======");

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            System.out.println(parameterName + ":" + request.getParameter(parameterName));
        }

//        System.out.println("======= 打印请求体 （只能打印raw） =======");

//        System.out.println(ReadAsChars(request));


        System.out.println("======= 打印请求体 （可打印文件流） =======");

        if(request instanceof MultipartHttpServletRequest){
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            // 获取文件map集合
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            // 循环遍历，取出单个文件
            String fileName = null;
            byte[] bytes = null;
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {

                // 获取单个文件
                MultipartFile mf = entity.getValue();

                // 获得原始文件名
                fileName = mf.getOriginalFilename();
                bytes = mf.getBytes();
                System.out.println("文件名：" + fileName);
                System.out.println("文件流：" + bytes);
                // 利于spring中的FileCopyUtils.copy()将文件复制
                // 创建文件存放路径实例
                File dest = new File("D:\\temp\\test\\" + fileName);
                FileCopyUtils.copy(mf.getBytes(), dest);
            }
        }
    }





    public static String ReadAsChars(HttpServletRequest request) {

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

}
