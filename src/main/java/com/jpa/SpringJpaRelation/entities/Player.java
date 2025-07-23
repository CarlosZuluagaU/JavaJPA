package com.jpa.SpringJpaRelation.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name") //Esto es porque no se puede en mayuscula
    private String lastName;
    private String nationality;
    private int age;
    private String position;

    //Ya tenemos las dos tablas

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
    //No es una lista porque es un solo club.


}
