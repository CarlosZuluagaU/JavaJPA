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
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;


    @OneToOne(targetEntity = Coach.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_coach", unique = true)
    private Coach coach;
    //Bueno entendamos el manejo de la clave foranea

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Player> players;

    //Se creo el muchos


    //Aca se crea que varios clubs pueden pertenecer a una misma asoaciacion

    @ManyToOne(targetEntity = FootballAssociation.class)
    private FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = FootballAssociation.class, fetch =  FetchType.LAZY)
    @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name= "competition"))
    private List<FootballAssociation> footballAssociations;




}
