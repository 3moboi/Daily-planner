package src.io.writing;

import src.models.Note;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class NoteFileWriter implements NoteWriter {
    private String filePath;

    public NoteFileWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(Collection<Note> noteCollection) {
        try (FileWriter output = new FileWriter(filePath)) {
            for (Note note: noteCollection) {
                output.write(note.toString()+ "\r\n");
            }
        }
        catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }
}
