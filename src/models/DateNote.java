package src.models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateNote implements Comparable<DateNote>{
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    private Date date;

    public DateNote(String stringDate) {
        if(stringDate.isEmpty()){
            date = null;
            return;
        }
        try {
            date = formatter.parse(stringDate);
        }
        catch (ParseException e) {
            System.out.println("Не верный формат даты: " + e.toString());
        }
    }

    public String toString(){
        if(date == null){
            return "";
        }
        return formatter.format(date);
    }

    public Boolean statusDate(){
        if(date == null){
            return true;
        }
        Date today = new Date();
        return date.after(today);
    }

    public int compareTo(DateNote alien){
        Date a, b;
        if(date == null){
            a = new Date();
        }
        else{
            a = date;
        }

        if(alien.date == null){
            b = new Date();
        }
        else{
            b = alien.date;
        }

        return a.compareTo(b);
    }
}
