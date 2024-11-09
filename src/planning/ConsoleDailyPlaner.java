package src.planning;

import src.Application;
import src.models.Note;
import src.di.ApplicationContainer;
import src.io.reading.InputReader;
import src.io.reading.NoteReader;
import src.io.writing.NoteWriter;
import src.io.writing.OutputWriter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConsoleDailyPlaner implements DailyPlaner {
    @Override
    public void outputAllNotes() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        OutputWriter writer = applicationContainer.getOutputWriter();
        NoteReader reader = applicationContainer.getNoteReader();

        try {
            Collection<Note> notes = reader.readFile();
            int index = 0;
            for (Note note : notes) {
                index++;
                writer.write(index + ": " + note.toString());
            }
        }
        catch (Exception exception) {

        }
    }

    @Override
    public void addNewNote() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        NoteReader noteReader = applicationContainer.getNoteReader();
        NoteWriter noteWriter = applicationContainer.getNoteWriter();
        InputReader reader = applicationContainer.getInputReader();
        OutputWriter writer = applicationContainer.getOutputWriter();

        try {
            writer.write("Введите дату заметки в формате \"22.09.2024\" " +
                    "либо нажмите enter, если хотите заметку оставить без даты");
            String date = reader.read();

            writer.write("Введите название заметки:");
            String title = reader.read();

            writer.write("Введите описание заметки:");
            String content = reader.read();

            Note newNote = new Note(date, title, content);

            Collection<Note> notes = noteReader.readFile();
            notes.add(newNote);

            noteWriter.writeToFile(notes);

            writer.write("Добавлена новая заметка: " + newNote.toString());
        }
        catch (Exception exception) {

        }
    }

    @Override
    public void removeNote() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        NoteReader noteReader = applicationContainer.getNoteReader();
        NoteWriter noteWriter = applicationContainer.getNoteWriter();
        InputReader reader = applicationContainer.getInputReader();
        OutputWriter writer = applicationContainer.getOutputWriter();

        try {
            writer.write("Выберете нужную строку, которую хотите удалить, написав значение строки.");

            outputAllNotes();

            String noteStringIndex = reader.read();
            int nodeIndex = Integer.parseInt(noteStringIndex);

            ArrayList <Note> notes = (ArrayList<Note>) noteReader.readFile();
            Note remove = notes.remove(--nodeIndex);

            writer.write("Вы удалили заметку: " +remove.toString());

            noteWriter.writeToFile(notes);
        }
        catch (Exception exc){

        }
    }

    @Override
    public void editNote() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        NoteReader noteReader = applicationContainer.getNoteReader();
        NoteWriter noteWriter = applicationContainer.getNoteWriter();
        InputReader reader = applicationContainer.getInputReader();
        OutputWriter writer = applicationContainer.getOutputWriter();

        try {
            writer.write("Выберете нужную строку, которую хотите редактировать, написав значение строки.");

            outputAllNotes();

            String noteStringIndex = reader.read();
            int noteIndex = Integer.parseInt(noteStringIndex);

            writer.write("Выберете какое поле хотите изменить: 0-дата, 1-название заметки, 2-описание заметки");

            String editPropertyStringIndex = reader.read();
            int editPropertyIndex = Integer.parseInt(editPropertyStringIndex);

            writer.write("Введите новое значение: Дата имеет формат типа \"23.09.2024\" либо нажмите enter," +
                    " если хотите заметку оставить без даты, название и описание в  формате строк");

            String newStringValue = reader.read();

            List<Note> notes = (List<Note>) noteReader.readFile();
            Note editingNote = notes.get(--noteIndex);
            editingNote.editNote(editPropertyIndex, newStringValue);

            noteWriter.writeToFile(notes);

            writer.write("Заметка отредактирована:" + editingNote.toString());
        }
            catch(Exception exc) {
            System.out.println("Не получилось отредактировать строку" + exc.getMessage());
        }
    }

    @Override
    public void sortNotes() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        OutputWriter writer = applicationContainer.getOutputWriter();
        NoteReader noteReader = applicationContainer.getNoteReader();
        NoteWriter noteWriter = applicationContainer.getNoteWriter();

        try {
            Collection<Note> notes = noteReader
                    .readFile()
                    .stream()
                    .sorted(Note::compareTo)
                    .toList();

            writer.write("Отсортировали заметки по дате:");
            noteWriter.writeToFile(notes);
            outputAllNotes();
        }
        catch (Exception exception) {

        }
    }
}
