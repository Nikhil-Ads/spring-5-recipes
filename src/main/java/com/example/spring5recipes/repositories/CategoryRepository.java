package com.example.spring5recipes.repositories;

import com.example.spring5recipes.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
