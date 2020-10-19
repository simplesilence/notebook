package com.shaun.database.redis;

import com.shaun.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }) // 指定启动类
public class RedisTemplateTest {

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test1(){

//        redisTemplate.boundHashOps("open_api_apps").put("f56009d888b74fcda30b508c50d1ea39", "{\n" +
//                "    \"clientId\": \"f56009d888b74fcda30b508c50d1ea39\",\n" +
//                "    \"resourceIds\": \"\",\n" +
//                "    \"clientSecret\": \"c7db5c1ab4e14513a0d12325b38f98d4\",\n" +
//                "    \"scope\": \"\",\n" +
//                "    \"authorizedGrantTypes\": \"\",\n" +
//                "    \"webServerRedirectUri\": \"\",\n" +
//                "    \"authorities\": \"\",\n" +
//                "    \"accessTokenValidity\": \"\",\n" +
//                "    \"refreshTokenValidity\": \"\",\n" +
//                "    \"additionalInformation\": \"\",\n" +
//                "    \"autoapprove\": \"\",\n" +
//                "    \"tenantId\": \"\"\n" +
//                "}");

        redisTemplate.opsForHash().put("open_api_apps", "f56009d888b74fcda30b508c50d1ea39", "c7db5c1ab4e14513a0d12325b38f98d4");

//        System.out.println(redisTemplate.boundHashOps("open_api_apps").get("f56009d888b74fcda30b508c50d1ea39"));
//        System.out.println(redisTemplate.opsForHash().get("open_api_apps", "f56009d888b74fcda30b508c50d1ea39"));
    }
}
