package com.shaun.serverdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Get 请求只有query string方式传参
 */
@RestController
@RequestMapping("/get")
public class UrlTestController {


    @GetMapping("/{a}/{b}/{c}")
    public void testMethod1(@PathVariable("a") String a,
                            @PathVariable("b") String b,
                            @PathVariable("c") String c){

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
