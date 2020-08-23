package com.example.spring5recipes.convertors;

import com.example.spring5recipes.commands.CategoryCommand;
import com.example.spring5recipes.commands.IngredientCommand;
import com.example.spring5recipes.commands.RecipeCommand;
import com.example.spring5recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    @Autowired
    private CategoryCommandToCategory categoryCommandToCategory;

    @Autowired
    private NotesCommandToNotes notesCommandToNotes;

    @Autowired
    private IngredientCommandToIngredient ingredientCommandToIngredient;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryCommandToCategory, IngredientCommandToIngredient ingredientCommandToIngredient, NotesCommandToNotes notesCommandToNotes) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if (recipeCommand == null) {
            return null;
        } else {
            Recipe recipe = new Recipe();
            recipe.setId(recipeCommand.getId());
            recipe.setDescription(recipeCommand.getDescription());
            recipe.setDirections(recipeCommand.getDirections());
            recipe.setCookTime(recipeCommand.getCookTime());
            recipe.setPrepTime(recipeCommand.getPrepTime());
            recipe.setDifficulty(recipeCommand.getDifficulty());
            recipe.setServings(recipeCommand.getServings());
            if (recipeCommand.getCategoryCommands() != null && recipeCommand.getCategoryCommands().size() > 0)
                recipeCommand.getCategoryCommands().forEach((CategoryCommand n) -> recipe.getCategories().add(categoryCommandToCategory.convert(n)));
            if (recipeCommand.getIngredientCommands() != null && recipeCommand.getIngredientCommands().size() > 0)
                recipeCommand.getIngredientCommands().forEach((IngredientCommand n) -> recipe.getIngredients().add(ingredientCommandToIngredient.convert(n)));
            recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotesCommand()));
            recipe.setSource(recipeCommand.getSource());
            recipe.setUrl(recipeCommand.getUrl());
            return recipe;
        }
    }
}
