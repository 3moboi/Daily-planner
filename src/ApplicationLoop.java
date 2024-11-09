package src;

import src.planning.DailyPlaner;
import src.di.ApplicationContainer;
import src.io.reading.InputReader;
import src.ui.Menu;
import src.io.writing.OutputWriter;

import java.io.IOException;

public class ApplicationLoop {
    private int inputReadingDelay;
    private String inputString;
    private Boolean applicationTerminated;

    public ApplicationLoop() {
        this(0);
    }

    public ApplicationLoop(int readingDelay) {
        this.inputReadingDelay = readingDelay;
        this.inputString = "";
        this.applicationTerminated = false;
    }

    public void run() throws Exception {
        do {
            showMenu();
            waitInput();
            readInput();
            processInput();
        } while (!applicationTerminated);
    }

    private void showMenu() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        Menu menu = applicationContainer.getMenu();
        menu.show();
    }

    private void readInput() throws IOException {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        InputReader reader = applicationContainer.getInputReader();
        inputString = reader.read();
    }

    private void processInput() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        DailyPlaner dailyPlaner = applicationContainer.getDailyPlaner();
        OutputWriter outputWriter = applicationContainer.getOutputWriter();

        switch (inputString) {
            case "1":
                dailyPlaner.outputAllNotes();
                break;
            case "2":
                dailyPlaner.addNewNote();
                break;
            case "3":
                dailyPlaner.sortNotes();
                break;
            case "4":
                dailyPlaner.removeNote();
                break;
            case "5":
                dailyPlaner.editNote();
                break;
            case "6":
                outputWriter.write("Нажиюшка еще не написала!");
                break;
            case "7":
                applicationTerminated = true;
                outputWriter.write("Пока!");
                break;
            default:
                outputWriter.write("Вы ввели не верную команду!");
                break;
        }
    }

    private void waitInput() throws Exception {
        try {
            Thread.sleep(inputReadingDelay);
        }
        catch (Exception exception) {
            ApplicationContainer applicationContainer = Application.getApplicationContainer();
            OutputWriter writer = applicationContainer.getOutputWriter();
            writer.write(exception.getMessage());
        }
    }
}
