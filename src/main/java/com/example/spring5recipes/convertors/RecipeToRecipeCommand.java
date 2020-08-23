package com.example.spring5recipes.convertors;

import com.example.spring5recipes.commands.RecipeCommand;
import com.example.spring5recipes.domain.Category;
import com.example.spring5recipes.domain.Ingredient;
import com.example.spring5recipes.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private CategoryToCategoryCommand categoryToCategoryCommand;

    private IngredientToIngredientCommand ingredientToIngredientCommand;

    private NotesToNotesCommand notesToNotesCommand;

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null) {
            return null;
        } else {
            System.out.println(recipe);
            RecipeCommand recipeCommand = new RecipeCommand();
            recipeCommand.setId(recipe.getId());
            recipeCommand.setDescription(recipe.getDescription());
            recipeCommand.setDirections(recipe.getDirections());
            recipeCommand.setCookTime(recipe.getCookTime());
            recipeCommand.setPrepTime(recipe.getPrepTime());
            recipeCommand.setDifficulty(recipe.getDifficulty());
            recipeCommand.setServings(recipe.getServings());
            recipeCommand.setSource(recipe.getSource());
            recipeCommand.setUrl(recipe.getUrl());

            if (recipe.getCategories() != null && recipe.getCategories().size() > 0)
                recipe.getCategories().forEach((Category n) -> recipeCommand.getCategoryCommands().add(categoryToCategoryCommand.convert(n)));
            if (recipe.getIngredients() != null && recipe.getIngredients().size() > 0)
                recipe.getIngredients().forEach((Ingredient n) -> recipeCommand.getIngredientCommands().add(ingredientToIngredientCommand.convert(n)));
            recipeCommand.setNotesCommand(notesToNotesCommand.convert(recipe.getNotes()));
            return recipeCommand;
        }
    }
}
