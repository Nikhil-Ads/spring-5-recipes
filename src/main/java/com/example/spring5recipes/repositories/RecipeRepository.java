package com.example.spring5recipes.repositories;

import com.example.spring5recipes.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
