package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DailyPlanner {

    public static void main( String[] args){

        ReadFile("FileInput"); //открыть файл прочитать и сохранить данные
        //menu
        //записать в файл
    }

    public static void ReadFile(String file) {
        String str;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((str = reader.readLine()) != null){
                var newNote = StringToNote.parseNote(str);
                System.out.println(newNote.toString());//
                System.out.println("______________________________________");
            }
        }
        catch (IOException exc){
            System.out.println("Ошибка чтения файла: " + exc);
        }
        catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }


}
