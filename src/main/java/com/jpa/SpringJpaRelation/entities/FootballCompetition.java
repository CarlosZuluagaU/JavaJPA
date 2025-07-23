package com.jpa.SpringJpaRelation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class FootballCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //Cuando tenemos nombres compuestos
    @Column(name = "cuantity_price")
    private int cuantityPrice;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startData;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

}
