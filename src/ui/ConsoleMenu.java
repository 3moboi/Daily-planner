package src.ui;

import src.Application;
import src.di.ApplicationContainer;
import src.io.writing.OutputWriter;

public class ConsoleMenu implements Menu {
    private StringBuilder menuOptions;

    public ConsoleMenu() {
        menuOptions = new StringBuilder();
        menuOptions.append("Выберите действие, введите номер команды:");
        menuOptions.append('\n');
    }

    @Override
    public void show() {
        ApplicationContainer applicationContainer = Application.getApplicationContainer();
        OutputWriter outputWriter = applicationContainer.getOutputWriter();
        menuOptions.append('\n');
        outputWriter.write(menuOptions.toString());
    }

    @Override
    public void hide() {
        System.out.println("");
    }

    @Override
    public Menu appendOption(Object option) {
        menuOptions.append(option);
        menuOptions.append('\n');
        return this;
    }
}
