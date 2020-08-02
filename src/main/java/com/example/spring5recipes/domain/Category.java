package com.example.spring5recipes.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * author: Nikhil Adlakha
 */
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

    public Category(){}

    public Category(String description){
        this.description=description;
    }

    public int hashCode() {
        return Id.hashCode();
    }
}
