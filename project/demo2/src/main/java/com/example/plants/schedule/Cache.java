package com.example.plants.schedule;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class Cache {

    @CacheEvict(value = "mostExpensiveProducts", allEntries = true)
    public void allCache() {

    }

}
