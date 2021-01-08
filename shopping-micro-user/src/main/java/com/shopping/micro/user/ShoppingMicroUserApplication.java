package com.shopping.micro.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
public class ShoppingMicroUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMicroUserApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() { return new RestTemplate(); }



}
