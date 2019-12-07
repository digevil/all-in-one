package com.digevil.gatewayscg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


/**
 * 参考:
 * https://cloud.spring.io/spring-cloud-gateway/reference/html/
 */
@SpringBootApplication
public class GatewayScgApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayScgApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80")
                        .id("get"))
                .route(p -> p
                        .path("/api/**")
                        .filters(f -> f.rewritePath("/api(?<segment>/?.*)", "/${segment}"))
                        .uri("http://localhost:8090")
                        .id("api"))
                .build();
    }
}
