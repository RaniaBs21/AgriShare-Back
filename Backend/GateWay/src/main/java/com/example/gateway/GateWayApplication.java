package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return  builder.routes()
                .route("MS-Projet", r->r.path("/projet/**")
                        .uri("http://projet:8093/"))
                .route("MS-Recolte", r->r.path("/recolte/**")
                        .uri("http://recolte:8094/"))
                .route("MS-Ressources", r->r.path("/ressources/**")
                        .uri("http://ressources:8095/"))

                .route("MS-Reclamation", r->r.path("/reclamation/**")
                        .uri("http://reclamation:8092/"))
                .route("MS-Formation", r->r.path("/formation/**")
                        .uri("http://formation:8090/"))
                .route("MS-Partenariat", r->r.path("/partenariat/**")
                        .uri("http://partenariat:8091/"))
                // Nouvelle route pour le microservice Node.js MS-User
                 .route("MS-User", r -> r.path("/user/**")
                         .uri("http://user:3001/"))
                .build();

    }

}
