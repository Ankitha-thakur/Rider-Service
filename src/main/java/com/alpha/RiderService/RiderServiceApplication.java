package com.alpha.RiderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class RiderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiderServiceApplication.class, args);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(
            RedisConnectionFactory connectionFactory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(connectionFactory);

        // Key will be stored as normal String
        template.setKeySerializer(new StringRedisSerializer());

        // Hash key will be stored as normal String
        template.setHashKeySerializer(new StringRedisSerializer());

        // Value will be stored as String
        template.setValueSerializer(new StringRedisSerializer());

        // Hash value will be stored as String
        template.setHashValueSerializer(new StringRedisSerializer());

        template.afterPropertiesSet();

        return template;
    }
}