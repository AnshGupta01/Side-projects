package com.actuator.Helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class DbHealthService implements HealthIndicator {
    public static final String DBSERVICE = "Database Service";

    public boolean isHealthGood(){
        //custom logic
        return true;
    }
    @Override
    public Health health() {
        if(isHealthGood()){
            return Health.up().withDetail(DBSERVICE,"Running good").build();
        };
        return Health.down().withDetail(DBSERVICE,"Not running perfectly").build();
    }
}
