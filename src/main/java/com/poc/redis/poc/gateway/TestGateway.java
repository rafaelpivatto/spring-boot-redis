package com.poc.redis.poc.gateway;

import com.poc.redis.poc.domain.Test;

public interface TestGateway {

    void save(Test customer);

    Test find(String id);

    void update(Test customer);

    void delete(String id);
}
