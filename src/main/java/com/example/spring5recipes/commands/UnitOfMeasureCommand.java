package com.example.spring5recipes.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: Nikhil Adlakha
 */

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {

    private Long id;
    private String description;
}
