package com.poc.redis.poc.config.redis;

import com.poc.redis.poc.config.json.ObjectMapperConfiguration;
import com.poc.redis.poc.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ComponentScan("com.poc.redis")
public class RedisConnectionFactoryConfiguration {

    @Autowired
    private ObjectMapperConfiguration objectMapperConfiguration;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public Jackson2JsonRedisSerializer<Test> jacksonJsonRedisJsonSerializer() {
        final Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Test.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapperConfiguration.getObjectMapper());
        return jackson2JsonRedisSerializer;
    }

    @Bean
    public RedisTemplate<String, Test> redisTemplate() {
        final RedisTemplate<String, Test> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(stringRedisSerializer());
        template.setValueSerializer(jacksonJsonRedisJsonSerializer());
        return template;
    }
}
