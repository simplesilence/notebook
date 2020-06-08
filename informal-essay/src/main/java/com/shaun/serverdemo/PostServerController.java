package com.shaun.serverdemo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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
    public void testMethod1(HttpServletRequest request, String queryStr){

        System.out.println(queryStr);

        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name + ":" + request.getHeader(name));
        }
    }
}
