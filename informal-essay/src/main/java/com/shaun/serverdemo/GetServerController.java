package com.shaun.serverdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Get 请求只有query string方式传参
 */
@RestController
@RequestMapping("/get")
public class GetServerController {


    /**
     * query string 接收单个参数
     * url?xxx=111&xxx=222
     * @param queryString
     * @param queryInt
     */
    @GetMapping("/testMethod1")
    public void testMethod1(String queryString, Integer queryInt){

        System.out.println(queryString);
        System.out.println(queryInt);
    }


    /**
     * query string 接收数组
     * url?xxx=111,222,zs,ls,ww
     * @param strArr
     */
    @GetMapping("/testMethod2")
    public void testMethod2(String[] strArr){

        System.out.println(Arrays.toString(strArr));
    }


    /**
     * query string 接收实体类
     * url?id=value1&name=value2&age=value2&addition=addition
     * TODO 映射的实体类中除能映射基本类型外，还可以映射String, 数组（只能是基本类型和String数组），List（只能是基本类型包装类和String泛型的集合）
     * TODO 基本类型：byte short int long float double boolean char
     * @param entity
     */
    @GetMapping("/testMethod3")
    public void testMethod3(String addition, Entity entity){

        System.out.println(addition);
        System.out.println(entity);
    }


    /**
     * TODO（亲测不可用）
     * query string 接收实体类数组
     * @param entitys
     */
    @GetMapping("/testMethod4")
    public void testMethod4(Entity[] entitys){

        System.out.println(entitys);
    }


    /**
     * TODO（亲测不可用）
     * query string 接收集合
     * @param strList
     */
    @GetMapping("/testMethod5")
    public void testMethod5(ArrayList<String> strList){

        System.out.println(strList);
    }

}
