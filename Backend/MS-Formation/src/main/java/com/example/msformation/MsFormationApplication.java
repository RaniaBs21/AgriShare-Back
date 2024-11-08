package com.example.msformation;

import com.example.msformation.Repositories.FormationRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@OpenAPIDefinition
@SpringBootApplication
public class MsFormationApplication {

    @Autowired
    private FormationRepo formationRepo;

    @Bean
    ApplicationRunner init(){
        return (args -> {

            formationRepo.findAll().forEach(System.out::println);
        }) ;
    }


    public static void main(String[] args) {
        SpringApplication.run(MsFormationApplication.class, args);
    }


    }




