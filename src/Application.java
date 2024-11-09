package src;

import src.di.ConsoleApplicationContainer;
import src.di.ApplicationContainer;

import java.io.IOException;

public class Application {
    private static ApplicationContainer applicationContainer;

    public static void main(String[] args) throws IOException {
        if (applicationContainer == null) {
            applicationContainer = new ConsoleApplicationContainer();
        }

        ApplicationLoop appLoop = new ApplicationLoop();
        try {
            appLoop.run();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static ApplicationContainer getApplicationContainer() {
        return applicationContainer;
    }
}