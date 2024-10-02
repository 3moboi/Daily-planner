package src;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateNote implements Comparable<DateNote>{
    //удобный формат данных
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    private Date date;

    DateNote(String stringDate) {
        if(stringDate.isEmpty()){
            date = null;
            return;
        }
        try {
            date = formatter.parse(stringDate);
        }
        catch (ParseException e) {
            System.out.println("Не верный формат даты: " + e.toString());
            //нужно потом вызвать повторно e
        }
    }

    //переопределенный метод toString, который выводит дату в строчном виде
    public String toString(){
        if(date == null){
            return "";
        }
        return formatter.format(date);
    }

    //метод, который выводит статус заметки(активная/просроченная задача)
    public Boolean statusDate(){
        if(date == null){
            return true;
        }
        Date today = new Date();
        return date.after(today);
    }

    //вспомогательный компаратор для сортировки Note по датам.
    public int compareTo(DateNote alien){
        Date a, b;
        //если у заметки дата не зафиксирована, то она считается за сегодняшний день
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
