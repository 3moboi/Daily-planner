package src.utility;

import src.models.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteConverter {
    public static Note convert(String inputString) throws Exception {
        if(inputString.isEmpty()) {
            throw new Exception("Не возможно сохранить пустую заметку");
        }

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(inputString);

        List<String> data = new ArrayList<>();
        while (matcher.find()) {
            String groupMatch = matcher.group();
            data.add(groupMatch.substring(1, groupMatch.length() - 1));
        }

        if (data.size() != 3) {
            throw new Exception("Не верный формат ввода!");
        }

        return new Note(data.get(0), data.get(1), data.get(2));
    }

    public static String convert(Note note) {
        return note.toString();
    }
}
