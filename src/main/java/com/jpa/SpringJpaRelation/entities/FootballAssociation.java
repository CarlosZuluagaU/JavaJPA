package com.jpa.SpringJpaRelation.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FootballAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String president;


    //MIRAR como vamos a relacionar la tabla de los clubes con la tabla de futbol, esa de asociacion

    @OneToMany(targetEntity = Club.class, fetch= FetchType.LAZY, mappedBy = "footballAssociation")
    private List<Club> clubs; //Aca esta el muchos

}
