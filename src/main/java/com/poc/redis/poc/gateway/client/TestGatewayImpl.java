package com.poc.redis.poc.gateway.client;

import com.poc.redis.poc.domain.Test;
import com.poc.redis.poc.gateway.TestGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class TestGatewayImpl implements TestGateway {

    private static final String KEY = "Test";

    private RedisTemplate<String, Test> redisTemplate;
    private HashOperations<String, String, Test> hashOperations;

    @Autowired
    public TestGatewayImpl(RedisTemplate<String, Test> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Test test) {
        redisTemplate.opsForValue().set(test.getId(), test);
    }

    @Override
    public Test find(String id) {
        return redisTemplate.opsForValue().get(id);
    }

    @Override
    public void update(Test test) {
        redisTemplate.opsForValue().set(test.getId(), test);
    }

    @Override
    public void delete(String id) {
        redisTemplate.delete(id);
    }
}
