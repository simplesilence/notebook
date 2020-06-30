package com.shaun.serverdemo;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shence")
public class ShenCeController {

    final Base64.Decoder decoder = Base64.getDecoder();

    /**
     * 解析前台的base64格式的json字符串
     * 注意：base64数据前台需进行url encode
     * @param request
     * @param response
     * @param data
     * @throws IOException
     */
    @GetMapping("/sa.gif")
    public void sg(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {

        System.out.println("\n############################################################ 华丽分割线 #############################################################\n");

        System.out.println("QueryString 参数：" + data);
        System.out.println(new String(decoder.decode(data), "UTF-8"));

        System.out.println("======= 打印请求头 =======");

        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name + ":" + request.getHeader(name));
        }

        System.out.println("======== 打印参数 ========");

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            System.out.println(parameterName + ":" + request.getParameter(parameterName));
        }

        System.out.println("======= 打印请求体 （只能打印文件流 == form-data） =======");

        if(request instanceof MultipartHttpServletRequest){

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            // 文件集合
            List<MultipartFile> files = multipartRequest.getFiles("files");
            for (MultipartFile file : files) {
                System.out.println(file.getOriginalFilename());
            }

            System.out.println("########## ########## ##########");

            // 获取文件map集合，若有多个文件相同key的，改map只能映射第一个file
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
        }else{

            System.out.println("======= 打印请求体 （只能打印raw == text/plain、application/json、application/javascript、text/html、application/xml） =======");
            System.out.println(ReadAsChars(request));
        }
    }

    /**
     * 打印请求体中raw指定格式文本
     * @param request
     * @return
     */
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
