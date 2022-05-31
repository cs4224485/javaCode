package com.harry.springboot.endpoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            Health build = Health.down()
                    .withDetail("msg", "error service")
                    .withDetail("code", "500")
                    .withException(new RuntimeException())
                    .build();
        }
        return Health.up().build();
    }

    public int check() {
        return 1;
    }

}
