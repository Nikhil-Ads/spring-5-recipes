package com.example.spring5recipes.services;

import com.example.spring5recipes.commands.RecipeCommand;
import com.example.spring5recipes.convertors.RecipeCommandToRecipe;
import com.example.spring5recipes.convertors.RecipeToRecipeCommand;
import com.example.spring5recipes.domain.Recipe;
import com.example.spring5recipes.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeServiceIT {

    private static final String DESCRIPTION = "NEW_DESCRIPTION";

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Autowired
    private RecipeCommandToRecipe recipeCommandToRecipe;

    @Test
    @Transactional
    public void testSaveOfDescription() {
        //given
        Iterable<Recipe> recipeIterator = recipeRepository.findAll();
        Recipe recipe = recipeIterator.iterator().next();
        RecipeCommand test = recipeToRecipeCommand.convert(recipe);

        //when
        test.setDescription(DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(test);

        //then
        assertEquals(DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(test.getId(), savedRecipeCommand.getId());
        assertEquals(test.getCookTime(), savedRecipeCommand.getCookTime());
        assertEquals(test.getCategoryCommands().size(), savedRecipeCommand.getCategoryCommands().size());
        assertEquals(test.getIngredientCommands().size(), savedRecipeCommand.getIngredientCommands().size());

    }


}