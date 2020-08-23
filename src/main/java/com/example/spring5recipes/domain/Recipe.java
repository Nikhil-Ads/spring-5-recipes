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
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String source;
    private String url;
    @Lob
    private String directions;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories=new HashSet<>();

    public void setNotes(Notes notes) {
        if (notes != null) {
            notes.setRecipe(this);
            this.notes = notes;
        }
    }

    public boolean addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        return this.getIngredients().add(ingredient);
    }
}