package com.example.spring5recipes.services;


import com.example.spring5recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
