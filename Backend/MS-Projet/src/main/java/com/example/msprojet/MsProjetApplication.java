package com.example.msprojet;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@OpenAPIDefinition
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MsProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProjetApplication.class, args);
    }

}
