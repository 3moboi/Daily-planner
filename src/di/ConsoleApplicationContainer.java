package src.di;

import src.Application;
import src.planning.ConsoleDailyPlaner;
import src.planning.DailyPlaner;
import src.ui.ConsoleMenu;
import src.ui.Menu;
import src.io.writing.OutputWriter;
import src.io.reading.ConsoleReader;
import src.io.reading.InputReader;
import src.io.reading.NoteFileReader;
import src.io.reading.NoteReader;
import src.io.writing.ConsoleWriter;
import src.io.writing.NoteFileWriter;
import src.io.writing.NoteWriter;

public class ConsoleApplicationContainer implements ApplicationContainer {
    @Override
    public Menu getMenu() {
        return new ConsoleMenu()
                .appendOption("1. Ввести заметки на экран")
                .appendOption("2. Добавить заметку")
                .appendOption("3. Отсортировать заметки по дате")
                .appendOption("4. Удалить заметку")
                .appendOption("5. Редактировать заметку")
                .appendOption("6. Поиск заметки по дате")
                .appendOption("7. Выход");
    }

    @Override
    public DailyPlaner getDailyPlaner() {
        return new ConsoleDailyPlaner();
    }

    @Override
    public InputReader getInputReader() {
        return new ConsoleReader();
    }

    @Override
    public OutputWriter getOutputWriter() {
        return new ConsoleWriter();
    }

    @Override
    public NoteReader getNoteReader() {
        return new NoteFileReader(Application.class.getName() + ".dp");
    }

    @Override
    public NoteWriter getNoteWriter() {
        return new NoteFileWriter(Application.class.getName() + ".dp");
    }
}
