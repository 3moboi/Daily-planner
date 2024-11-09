package src.io.reading;

import src.models.Note;

import java.util.Collection;

public interface NoteReader {
    Collection<Note> readFile();
}
