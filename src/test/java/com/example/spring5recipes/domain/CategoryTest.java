package com.example.spring5recipes.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void setId() {
        Long idVal = 4L;

        category.setId(idVal);

        assertEquals(idVal, category.getId());
    }

    @Test
    void setDescription() {
    }

    @Test
    void setRecipes() {
    }

}