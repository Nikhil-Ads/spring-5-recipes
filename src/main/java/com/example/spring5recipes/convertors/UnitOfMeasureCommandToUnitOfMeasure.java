package com.example.spring5recipes.convertors;

import com.example.spring5recipes.commands.UnitOfMeasureCommand;
import com.example.spring5recipes.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * author: Nikhil Adlakha
 */

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if (unitOfMeasureCommand == null)
            return null;
        else {
            final UnitOfMeasure uom = new UnitOfMeasure();
            uom.setId(unitOfMeasureCommand.getId());
            uom.setDescription(unitOfMeasureCommand.getDescription());
            return uom;
        }
    }
}
