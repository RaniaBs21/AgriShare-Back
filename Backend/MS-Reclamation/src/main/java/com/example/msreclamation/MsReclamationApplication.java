package com.example.msreclamation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@OpenAPIDefinition
@SpringBootApplication
public class MsReclamationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsReclamationApplication.class, args);
    }

}
