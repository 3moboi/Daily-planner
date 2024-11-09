package src.io.writing;

import src.models.Note;

import java.util.Collection;

public interface NoteWriter {
    void writeToFile(Collection<Note> noteCollection);
}
