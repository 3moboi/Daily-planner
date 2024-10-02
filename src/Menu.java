package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    // цикл ожидания действий
    public static void menu() throws IOException {
        String str;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        do{
            System.out.println("Выберите действие, введите номер команды:" +
                    "\n1.Ввести заметки на экран \n2.Добавить заметку \n3.Отсортировать заметки по дате " +
                    "\n4.удалить заметку \n5.редактировать заметку \n6.поиск заметки по дате");

            System.out.println("Для завершения введите \"stop\"\n");

            str = input.readLine();

            switch (str){
                case "1":
                    //Ввести заметки на экран
                    outputAllNotes();
                    break;
                case "2":
                    //Добавить заметку
                    addNewNote(input);
                    break;
                case "3":
                    //отсортировать заметки по дате
                    sortNotes();
                    break;
                case "4":
                    //удалить заметку
                    deleteNote(input);
                    break;
                case "5":
                    editNote(input);
                    //редактировать заметку
                    break;
                case "6":
                    //поиск заметки по дате
                    break;
                case "stop":
                    System.out.println("Пока!");
                    break;
                default:
                    System.out.println("Вы ввели не верную команду");
                    break;
            }

            System.out.println("\n");

        }while (!str.equals("stop"));
    }

    public static void outputAllNotes(){
        for(int i = 0; i < DailyPlanner.data.size(); i++){
            System.out.println( i + ": " + DailyPlanner.data.get(i).toString());
        }
    }

    public static void sortNotes(){
        DailyPlanner.data.sort(Note::compareTo);
        System.out.println("Отсортировали заметки по дате:");
        outputAllNotes();
    }

    public static void addNewNote(BufferedReader input){
        try{
            System.out.println("Введите дату заметки в формате \"22.09.2024\" " +
                    "либо нажмите enter, если хотите заметку оставить без даты");
            String date = input.readLine();

            System.out.println("Введите название заметки:");
            String title = input.readLine();

            System.out.println("Введите описание заметки:");
            String content = input.readLine();

            var newNote = new Note(date, title, content);
            DailyPlanner.data.add(newNote);

            System.out.println("Добавлена новая заметка: "+ newNote.toString());
        }
        catch(Exception exc){
            System.out.println("Не получилось добавить заметку!");
        }
    }

    public static void deleteNote(BufferedReader input) {
        try{
            System.out.println("Выберете нужную строку, которую хотите удалить, написав значение строки.");
            outputAllNotes();
            int i = Integer.parseInt(input.readLine());
            Note remove = DailyPlanner.data.remove(i);
            System.out.println("Вы удали заметку: "+ remove.toString());
            //хотите востановить ее?
        }
        catch (Exception exc){
            System.out.println("Не получилось удалить строку" + exc.getMessage());
        }
    }

    public static void editNote(BufferedReader input){
        try{
            System.out.println("Выберете нужную строку, которую хотите редактировать, написав значение строки.");
            outputAllNotes();
            int i = Integer.parseInt(input.readLine());
            System.out.println("Выберете какое поле хотите изменить: 0-дата, 1-название заметки, 2-описание заметки");
            int j = Integer.parseInt(input.readLine());
            System.out.println("Введите новое значение: Дата имеет формат типа \"23.09.2024\" либо нажмите enter," +
                    " если хотите заметку оставить без даты, название и описание в  формате строк");
            String str = input.readLine();
            DailyPlanner.data.get(i).editNote(j,str);

            System.out.println("Заметка отредактирована:" + DailyPlanner.data.get(i).toString());
        }
        catch(Exception exc){
            System.out.println("Не получилось отредактировать строку" + exc.getMessage());
        }
    }

}
