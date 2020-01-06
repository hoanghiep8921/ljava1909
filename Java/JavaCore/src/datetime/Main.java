package datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        //date.set()
        System.out.println(date);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,5);
        calendar.set(Calendar.MONTH,2);
        calendar.set(Calendar.HOUR,10);

        Date tomorrow = calendar.getTime();
        System.out.println(tomorrow);

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        System.out.println(strDate);

        Date date1 = dateFormat.parse("09:55:50 2019-01-04");
        System.out.println(date1);

        System.out.println(date1.getTime());
    }
}
