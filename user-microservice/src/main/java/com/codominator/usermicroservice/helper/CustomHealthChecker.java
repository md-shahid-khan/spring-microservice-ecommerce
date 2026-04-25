//package com.codominator.usermicroservice.helper;
//
//import org.jspecify.annotations.Nullable;
//import org.springframework.boot.health.contributor.Health;
//import org.springframework.boot.health.contributor.HealthIndicator;
//
//public class CustomHealthChecker implements HealthIndicator {
//    public boolean healthIsGood() {
//        // custom logic goes here
//        return true;
//    }
//
//    @Override
//    public @Nullable Health health() {
//        if (healthIsGood()) {
//            return Health.up().withDetail("Custom Health Checker", true).build();
//        }
//        return Health.down().withDetail("Custom Health is down!", true).build();
//    }
//}
