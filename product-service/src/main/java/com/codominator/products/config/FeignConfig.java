package com.codominator.products.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//
//            // Example: get token from SecurityContext
//            String token = getTokenFromContext();
//
//            if (token != null) {
//                requestTemplate.header("Authorization", "Bearer " + token);
//            }
//        };
//    }
//
//    private String getTokenFromContext() {
//        // implement based on your security
//        return "your-jwt-token";
//    }
}