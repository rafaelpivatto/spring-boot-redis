package com.poc.redis.poc.usecases;

import com.poc.redis.poc.domain.Test;
import com.poc.redis.poc.gateway.TestGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCRUD {

    private TestGateway gateway;

    @Autowired
    public TestCRUD(TestGateway gateway) {
        this.gateway = gateway;
    }

    public void save(Test test) {
        this.gateway.save(test);
    }

    public Test findById(String id) {
        return this.gateway.find(id);
    }

    public void delete(String id) {
        this.gateway.delete(id);
    }

    public void update(Test test) {
        this.gateway.update(test);
    }
}
