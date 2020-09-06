package com.example.spring5recipes.services;


import com.example.spring5recipes.commands.RecipeCommand;
import com.example.spring5recipes.domain.Recipe;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long id);

    @Transactional
    void deleteById(Long id);
}
