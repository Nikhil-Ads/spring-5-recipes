package com.example.spring5recipes.bootstrap;

import com.example.spring5recipes.domain.*;
import com.example.spring5recipes.repositories.CategoryRepository;
import com.example.spring5recipes.repositories.RecipeRepository;
import com.example.spring5recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * author: Nikhil Adlakha
 */
@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository){
        this.categoryRepository=categoryRepository;
        this.recipeRepository=recipeRepository;
        this.unitOfMeasureRepository=unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        log.debug("Loading Recipes....");
        List<Recipe> recipes=new ArrayList<>();

        //get UOMS
        List<Optional<UnitOfMeasure>> uoms = getUOMS("Teaspoon","Tablespoon","Cup","Pinch","Ounce","dash","Pint","whole");

        List<Category> categories=getCategories("American","Mexican");

        Recipe guacRecipe=new Recipe();

        guacRecipe.setCookTime(0);
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut the avocado, remove flesh" +
                        "\r\n2 Mash with a fork"+
                "\r\n3 Add salt, lime juice, and the rest"+
                "\r\n4 Serve");
        guacRecipe.setPrepTime(10);
        guacRecipe.setServings(4);
        guacRecipe.setSource("SimplyRecipes.com");
        guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/#recipe159");

        Notes notes=new Notes();
        notes.setRecipeNotes("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        guacRecipe.setNotes(notes);
        guacRecipe.getCategories().addAll(categories);

        guacRecipe.addIngredient(new Ingredient("ripe avocados", BigDecimal.valueOf(2), uoms.get(7).get()));
        guacRecipe.addIngredient(new Ingredient("salt", BigDecimal.valueOf(0.25), uoms.get(0).get()));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice", BigDecimal.valueOf(1), uoms.get(1).get()));
        guacRecipe.addIngredient(new Ingredient("minced red onion", BigDecimal.valueOf(2), uoms.get(1).get()));
        guacRecipe.addIngredient(new Ingredient("serrano chiles", BigDecimal.valueOf(2), uoms.get(7).get()));
        guacRecipe.addIngredient(new Ingredient("cilantro", BigDecimal.valueOf(2), uoms.get(1).get()));
        guacRecipe.addIngredient(new Ingredient("black pepper", BigDecimal.valueOf(1), uoms.get(5).get()));
        guacRecipe.addIngredient(new Ingredient("ripe tomatoes", BigDecimal.valueOf(0.5), uoms.get(7).get()));
        guacRecipe.addIngredient(new Ingredient("red radish", BigDecimal.valueOf(1), uoms.get(7).get()));
        guacRecipe.addIngredient(new Ingredient("tortilla chips", BigDecimal.valueOf(1), uoms.get(7).get()));

        recipes.add(guacRecipe);

        guacRecipe=new Recipe();

        guacRecipe.setCookTime(15);
        guacRecipe.setDescription("Spicy Grilled Chicken Tacos");
        guacRecipe.setDifficulty(Difficulty.MODERATE);
        guacRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat." +
                        "\r\n2 Make the marinade and coat the chicken"+
                        "\r\n3 Grill the chicken."+
                        "\r\n4 Warm the tortillas"+
                        "\r\n5 Assemble the tacos");
        guacRecipe.setPrepTime(20);
        guacRecipe.setServings(6);
        guacRecipe.setSource("SimplyRecipes.com");
        guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#recipe50182");

        notes=new Notes();
        notes.setRecipeNotes("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n"+
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n"+
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n"+
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n"+
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n"+
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n"+
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        guacRecipe.setNotes(notes);
        guacRecipe.getCategories().addAll(categories);

        guacRecipe.addIngredient(new Ingredient("ancho chilli powder", BigDecimal.valueOf(2), uoms.get(1).get()));
        guacRecipe.addIngredient(new Ingredient("dried oregano", BigDecimal.valueOf(1), uoms.get(0).get()));
        guacRecipe.addIngredient(new Ingredient("dried cumin", BigDecimal.valueOf(1), uoms.get(0).get()));
        guacRecipe.addIngredient(new Ingredient("sugar", BigDecimal.valueOf(1), uoms.get(0).get()));
        guacRecipe.addIngredient(new Ingredient("salt", BigDecimal.valueOf(0.5), uoms.get(0).get()));
        guacRecipe.addIngredient(new Ingredient("clove garlic", BigDecimal.valueOf(1), uoms.get(7).get()));
        guacRecipe.addIngredient(new Ingredient("orange zest, grated", BigDecimal.valueOf(1), uoms.get(1).get()));
        guacRecipe.addIngredient(new Ingredient("orange juice", BigDecimal.valueOf(3), uoms.get(1).get()));
        guacRecipe.addIngredient(new Ingredient("olive oil", BigDecimal.valueOf(2), uoms.get(1).get()));
        guacRecipe.addIngredient(new Ingredient("boneless chicken thighs", BigDecimal.valueOf(6), uoms.get(7).get()));

        recipes.add(guacRecipe);

        return recipes;
    }

    private List<Optional<UnitOfMeasure>> getUOMS(String ... ar){
        List<Optional<UnitOfMeasure>> uoms=new ArrayList<>();
        for (String unit: ar) {
            Optional<UnitOfMeasure> uom=unitOfMeasureRepository.findByDescription(unit);

            if(!uom.isPresent())
                    throw new RuntimeException("Expected UOM are Found");
            else    uoms.add(uom);
        }
        return uoms;
    }

    private List<Category> getCategories(String ... ar){
        List<Category> categories=new ArrayList<>();
        for (String category: ar) {
            Optional<Category> c=categoryRepository.findByDescription(category);

            if(!c.isPresent())
                throw new RuntimeException("Expected UOM are Found");
            else    categories.add(c.get());
        }
        return categories;
    }
}
