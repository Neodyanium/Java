package DateTimeAPI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.JapaneseDate;

/**
 *
 */
public class DateTimeAPI {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        System.out.println(date.getDayOfMonth() + "/"+date.getMonth()+"/"+date.getYear());
        System.out.println(date.getDayOfMonth() + "/"+date.getMonthValue()+"/"+date.getYear());

        LocalDate dob = LocalDate.of(2000,2,10);
        System.out.println(dob);

        LocalTime time = LocalTime.now();

        System.out.println(time);


        System.out.println(time.getHour()+":"+time.getMinute()+":"+time.getSecond());

        // LocalTime.now();

    }
}
