package com.example.spring5recipes.convertors;

import com.example.spring5recipes.commands.CategoryCommand;
import com.example.spring5recipes.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = Long.valueOf(1L);

    CategoryCommandToCategory convertor;

    @BeforeEach
    public void setUp() {
        convertor = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(convertor.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(convertor.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setDescription(DESCRIPTION);
        categoryCommand.setId(LONG_VALUE);

        Category category = convertor.convert(categoryCommand);

        assertNotNull(category);
        assertEquals(LONG_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

}