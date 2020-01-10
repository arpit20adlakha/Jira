package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static Date getDateObject(String s) throws ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(s);
        return date1;
    }
}
