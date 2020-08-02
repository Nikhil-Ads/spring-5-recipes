package com.example.spring5recipes.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * author: Nikhil Adlakha
 */

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("{Note: {Id: %d , Recipe Notes: %s}}", id, recipeNotes);
    }
}

