package com.jpa.SpringJpaRelation.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name") //Esto es porque no se puede en mayuscula
    private String lastName;
    private String nationality;
    private int age;

    //Ya tenemos las dos tablas

}
