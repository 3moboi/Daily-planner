package src;

public class Note implements Comparable<Note> {
    DateNote date;
    String title;
    String content;

    Note(String date, String title, String content){
        this.date = new DateNote(date);
        this.title = title;
        this.content = content;
    }

    Note(){
        this.date = new DateNote("");
        this.title = "";
        this.content = "";
    }


    //компаратор для сортировки по дате
    public int compareTo(Note alien){
        return this.date.compareTo(alien.date);
    }

    //вывести в строку для записи в файл
    public String toString(){
        return "\"%s\"\t\"%s\"\t\"%s\"".formatted(date.toString(), title, content);
    }

    //изменить заметку, изменить только по полям, чтобы легко вводить не через конструктор, switch вынести в меню
    public void editNote(int indicator, String value) throws Exception{
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
