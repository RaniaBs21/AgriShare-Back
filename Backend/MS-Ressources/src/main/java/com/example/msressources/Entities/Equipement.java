package com.example.msressources.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Equipement")
public class Equipement implements Serializable {

    @Id
    private String id;
    private String nomEquipement;
    private TypeEquipement type;
    private LocalDate purchaseDate;

}
