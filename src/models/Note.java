package src.models;

public class Note implements Comparable<Note> {
    private DateNote date;
    private String title;
    private String content;

    public Note(String date, String title, String content){
        this.date = new DateNote(date);
        this.title = title;
        this.content = content;
    }

    public Note() {
        this.date = new DateNote("");
        this.title = "";
        this.content = "";
    }

    public int compareTo(Note alien){
        return this.date.compareTo(alien.date);
    }

    public String toString() {
        return "\"%s\"\t\"%s\"\t\"%s\"".formatted(date.toString(), title, content);
    }

    public void editNote(int indicator, String value) throws Exception {
        switch (indicator){
            case (0):
                date = new DateNote(value);
                break;
            case (1):
                title = value;
                break;
            case (2):
                content = value;
                break;
            default:
                throw new Exception("Не верный ввод поля");
        }
    }
}
