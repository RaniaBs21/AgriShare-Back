package com.example.msprojet.Repositories;

import com.example.msprojet.Entities.Partenariat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MS-Partenariat", url = "http://partenariat:8091/partenariat")
public interface PartenaritClient {

    @RequestMapping("")
     List<Partenariat> getPartenariats();

    @RequestMapping("/{id}")
     Partenariat getPartenariatById(@PathVariable int id);
}
