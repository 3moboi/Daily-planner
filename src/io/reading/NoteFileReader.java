package src.io.reading;

import src.models.Note;
import src.utility.NoteConverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class NoteFileReader implements NoteReader {
    private String filePath;

    public NoteFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Collection<Note> readFile() {
        Collection<Note> notes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String bufferString;
            while((bufferString = reader.readLine()) != null) {
                try {
                    var note = NoteConverter.convert(bufferString);
                    notes.add(note);
                }
                catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
        catch (IOException exception) {
            System.out.println("Ошибка чтения файла: " + exception);
        }
        return notes;
    }
}
