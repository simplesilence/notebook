package com.shaun.database.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shaun.Application;
import com.shaun.verify.OpenApiMapping;
import com.shaun.verify.OpenAppInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }) // 指定启动类
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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

//        stringRedisTemplate.opsForHash().put("open_api_apps", "f56009d888b74fcda30b508c50d1ea39", "c7db5c1ab4e14513a0d12325b38f98d4");

//        System.out.println(redisTemplate.boundHashOps("open_api_apps").get("f56009d888b74fcda30b508c50d1ea39"));
//        System.out.println(redisTemplate.opsForHash().get("open_api_apps", "f56009d888b74fcda30b508c50d1ea39"));


//        stringRedisTemplate.opsForValue().set("openapi:app:448631d6afe346c6b9529626d694bf6d", "{\n" +
//                "    \"app_name\": \"测试admin服务\",\n" +
//                "    \"app_key\": \"448631d6afe346c6b9529626d694bf6d\",\n" +
//                "    \"app_secret\": \"8e012ce3e63d8969c28ef284d37fb17c\"\n" +
//                "}");

//        SetOperations<String, String> set = redisTemplate.opsForSet();
//        set.add("448631d6afe346c6b9529626d694bf6d","/log/collect");
//        set.add("448631d6afe346c6b9529626d694bf6d","/log/delete");
//        set.add("448631d6afe346c6b9529626d694bf6d","/log/update");
//        Set<String> resultSet =redisTemplate.opsForSet().members("448631d6afe346c6b9529626d694bf6d");

//        stringRedisTemplate.opsForValue().set("openapi:ip_white:448631d6afe346c6b9529626d694bf6d",
//                "192.168.97.152,192.168.97.188");


//        OpenAppInfo openAppInfo = (OpenAppInfo) redisTemplate.opsForValue().get("openapi:app:448631d6afe346c6b9529626d694bf6d");
//        OpenApiMapping openApiMapping = (OpenApiMapping) redisTemplate.opsForValue().get("openapi:api_mapping:path.log.col");

//        OpenAppInfo openAppInfo = JSON.parseObject(redisTemplate.opsForValue().get("openapi:app:448631d6afe346c6b9529626d694bf6d"), OpenAppInfo.class);
//        OpenApiMapping openApiMapping = JSON.parseObject(redisTemplate.opsForValue().get("openapi:api_mapping:path.log.col"), OpenApiMapping.class);
//
//        System.out.println("openAppInfo = " + openAppInfo);
//        System.out.println("openApiMapping = " + openApiMapping);

//        Map<String, String> map = new HashMap<>();
//        map.put("key", "val");
//        System.out.println(map.size());

    }


    /**
     * redis发布订阅
     * 配合com.shaun.database.redis.RedisConfig#container2
     */
    @Test
    public void testMQ(){
        String channel1 = "fullDataUpload"; String channel2 = "analysis";
        User user = new User();
        user.setPhone("18675830623");
        user.setName("测试一");

        User user2 = new User();
        user2.setPhone("17856232365");
        user2.setName("测试二");

        redisTemplate.convertAndSend(channel1,user);
        redisTemplate.convertAndSend(channel2,user2);
    }

    /**
     * 获取所有keys
     * scan方式
     */
    @Test
    public void test2(){

        RedisConnection redisConnection = null;
        try {
            redisConnection = redisTemplate.getConnectionFactory().getConnection();
            ScanOptions options = ScanOptions.scanOptions().match("openapi:ip_white:*").count(Long.MAX_VALUE).build();

            Cursor c = redisConnection.scan(options);
            while (c.hasNext()) {
                System.out.println((new String((byte[]) c.next())));
            }
        } finally {
            redisConnection.close(); //Ensure closing this connection.
        }
    }

    /**
     * 根据key获取值
     */
    @Test
    public void test3(){

        // 存值
//        redisTemplate.opsForValue().set("openapi:ip_white:558631d6afe346c6b9529626d694a4f8", "192.168.97.152,192.168.97.188,192.168.97.30".split(","));

//        SetOperations<String, String> set = redisTemplate.opsForSet();
//        set.add("448631d6afe346c6b9529626d694bf6d","/log/collect");
//        set.add("448631d6afe346c6b9529626d694bf6d","/log/delete");
//        set.add("448631d6afe346c6b9529626d694bf6d","/log/update");
        Set<String> resultSet =stringRedisTemplate.opsForSet().members("openapi:relation:78e32e9859619c8650b6a4188aeaba94");
//        Object o = redisTemplate.opsForValue().get("openapi:relation:78e32e9859619c8650b6a4188aeaba94");
//        System.out.println(o);
        System.out.println(resultSet);

        // 获取list
//        List range = redisTemplate.opsForList().range("openapi:relation:78e32e9859619c8650b6a4188aeaba94", 0, -1);
//        System.out.println(range);
    }


    /**
     * map转json
     */
    @Test
    public void test4(){

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "val1");
        map.put("key2", "val2");
        map.put("key3", "val3");
        map.put("key4", "val4");
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject.toString());
    }
}
