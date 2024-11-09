package src.io.writing;

import java.io.PrintStream;

public class ConsoleWriter implements OutputWriter {
    private PrintStream outputStream;

    public ConsoleWriter() {
        outputStream = System.out;
    }

    @Override
    public void write(String output) {
        outputStream.println(output);
    }
}
