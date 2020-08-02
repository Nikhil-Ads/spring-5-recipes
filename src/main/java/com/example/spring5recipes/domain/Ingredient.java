package com.example.spring5recipes.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * author: Nikhil Adlakha
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;


    public Ingredient(){}

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description=description;
        this.amount=amount;
        this.uom=uom;
    }

}
