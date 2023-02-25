package com.atgugu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean  //通过访问localhost:9527/guonei 即可转发到http://news.baidu.com/guonei
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_atgugu", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();

        return routes.build();

    }
}
