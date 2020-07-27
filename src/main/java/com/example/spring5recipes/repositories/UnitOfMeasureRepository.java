package com.example.spring5recipes.repositories;

import com.example.spring5recipes.domain.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure,Long> {
}
