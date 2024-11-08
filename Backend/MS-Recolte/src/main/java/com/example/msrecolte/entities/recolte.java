package com.example.msrecolte.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "recoltes")
public class recolte implements Serializable {

    @Id
    private String id;
    private String typeCulture;
    private Double quantite;
    private String saison;
    private LocalDate dateRecolte;



}
