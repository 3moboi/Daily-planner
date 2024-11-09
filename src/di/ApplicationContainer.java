package src.di;
import src.planning.DailyPlaner;
import src.io.reading.InputReader;
import src.io.reading.NoteReader;
import src.ui.Menu;
import src.io.writing.NoteWriter;
import src.io.writing.OutputWriter;

public interface ApplicationContainer {
    Menu getMenu();

    DailyPlaner getDailyPlaner();

    InputReader getInputReader();

    OutputWriter getOutputWriter();

    NoteReader getNoteReader();

    NoteWriter getNoteWriter();
}
