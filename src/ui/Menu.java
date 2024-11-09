package src.ui;

public interface Menu {
    void show();
    void hide();
    Menu appendOption(Object option);
}
