package com.example.plants.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RemoveCacheScheduler {

    private final Cache cache;

    public RemoveCacheScheduler(Cache cache) {
        this.cache = cache;
    }

    @Scheduled(fixedDelay = 20000)
    public void removeCacheForMostExpensiveProduct() {
        cache.allCache();
    }
}
