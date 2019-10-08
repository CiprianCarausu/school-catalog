package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConverter {

        public static Date stringToDate(String date){
            Date dateFormat = null;
            try {
                dateFormat = new SimpleDateFormat("MM/dd/yyyy").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return dateFormat;
        }

        public static Date stringToDateAndTime(String dateAndTime){
            Date dateFormat = null;
            try {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm.ss.SSSS").parse(dateAndTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return dateFormat;
        }
    }

