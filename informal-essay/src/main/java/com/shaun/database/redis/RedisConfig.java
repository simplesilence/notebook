package com.shaun.database.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaun.database.redis.pubsub.MessageReceiveOne;
import com.shaun.database.redis.pubsub.MessageReceiveTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * redis 配置
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //自定义序列化方式
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    //MessageListenerAdapter 表示监听频道的不同订阅者
    @Bean
    RedisMessageListenerContainer container2(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter, MessageListenerAdapter listenerAdapter2){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //订阅多个频道
        container.addMessageListener(listenerAdapter,new PatternTopic("fullDataUpload"));
        container.addMessageListener(listenerAdapter2,new PatternTopic("fullDataUpload"));
        container.addMessageListener(listenerAdapter2,new PatternTopic("analysis"));

        //序列化对象（特别注意：发布的时候需要设置序列化；订阅方也需要设置序列化）
        Jackson2JsonRedisSerializer serial = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serial.setObjectMapper(objectMapper);

        container.setTopicSerializer(serial);
        return container;
    }

    //表示监听一个频道
    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiveOne receiver){
        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“MessageReceiveTwo ”
        return new MessageListenerAdapter(receiver,"getMessage");
    }

    @Bean
    MessageListenerAdapter listenerAdapter2(MessageReceiveTwo receiver){
        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“MessageReceiveOne ”
        return new MessageListenerAdapter(receiver,"getMessage");
    }
}
