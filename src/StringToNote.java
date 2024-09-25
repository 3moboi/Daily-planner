package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToNote {
    public static Note parseNote(String input) throws Exception {
        String [] toString = new String[3];

        if(input.isEmpty()){
            throw new Exception("Не возможно сохранить пустую заметку");
        }

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(input);

        int i = 0;
        for(; matcher.find() ; i++ ){
            if (i >= 3){
                throw new Exception("Не верный формат ввода: " + input);
            }
            String str = matcher.group();
            toString[i] = str.substring(1,str.length()-1);//избавляемся от ""
        }
        if( i != 3){
            throw new Exception("Не верный формат ввода: " + input);
        }

        return new Note(toString[0], toString[1], toString[2]);
    }

}
