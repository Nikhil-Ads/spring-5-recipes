package com.example.spring5recipes.commands;

import com.example.spring5recipes.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * author: Nikhil Adlakha
 */

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;

    private String source;
    private String url;

    private String directions;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private Difficulty difficulty;

    private NotesCommand notesCommand = new NotesCommand();
    private Set<CategoryCommand> categoryCommands = new HashSet<>();
    private Set<IngredientCommand> ingredientCommands = new HashSet<>();
}
