package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DailyPlanner {
    public static ArrayList <Note> data = new ArrayList<>();

    public static void main( String[] args) throws IOException {

        String file = "FileData";
        readFile(file); //открыть файл прочитать и сохранить данные
        Menu.menu();//менюшка с действиями в виде вечного цикла
        writeToFile(file);//записать в файл
    }

    public static void readFile(String file) {
        String str;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((str = reader.readLine()) != null){
                //обрабатывает ошибки парсинга без выхода из файла
                try{
                    var newNote = StringToNote.parseNote(str);
                    data.add(newNote);
                }
                catch(Exception exc){
                    System.out.println(exc.getMessage());
                }
            }
        }
        catch (IOException exc){
            System.out.println("Ошибка чтения файла: " + exc);
        }
    }

    public static void writeToFile(String file){
        try(FileWriter output = new FileWriter(file)){
            for(int i = 0; i < data.size(); i++){
                output.write(data.get(i).toString()+ "\r\n");
            }
        }
        catch (IOException exc){
            System.out.println("Ошибка записи файла: " + exc);
        }
    }
}
