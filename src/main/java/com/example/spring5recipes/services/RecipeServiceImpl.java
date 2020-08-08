package com.example.spring5recipes.services;

import com.example.spring5recipes.domain.Recipe;
import com.example.spring5recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 * author: Nikhil Adlakha
 */
@Slf4j
@Service("RecipeService")
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("Getting Recipes");
        Set<Recipe> recipes = new LinkedHashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }


    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipe = null;
        recipe = recipeRepository.findById(id);
        if (!recipe.isPresent())
            throw new RuntimeException("Recipe not present!!!");
        return recipe.get();
    }
}
