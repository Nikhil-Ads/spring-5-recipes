package com.example.spring5recipes.convertors;

import com.example.spring5recipes.commands.NotesCommand;
import com.example.spring5recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand notesCommand) {
        if (notesCommand == null)
            return null;
        else {
            Notes notes = new Notes();
            notes.setId(notesCommand.getId());
            notes.setRecipeNotes(notesCommand.getRecipeNotes());
            return notes;

        }
    }
}