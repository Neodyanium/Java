package Java8;

import java.time.*;
import java.util.Scanner;

public class DateTimeAPI {
    public static void main(String[] args) {


        Utility.linspace();
        customFormatDate();
        Utility.linspace();
        dateTimeObject();
        Utility.linspace();
        dateTimeOfMethod();
        Utility.linspace();
        periodBetweenEvents();
        Utility.linspace();
        leapYearMethod();
        Utility.linspace();
        aboutZoneId();
        Utility.linspace();
    }

    private static void aboutZoneId() {
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
    }

    private static void leapYearMethod() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Year:");
//        int n = in.nextInt();
        int n = 1980;
        Year y = Year.of(n);
        if(y.isLeap())
            System.out.println(n + " is Leap Year");
        else
            System.out.println(n + " isn't a Leap Year");
    }

    private static void periodBetweenEvents() {
        LocalDate birthday = LocalDate.of(2000,10,2);

        LocalDate today = LocalDate.now();

        Period p = Period.between(birthday,today);

        System.out.printf("You are %d years old, %d months old and %d days old\n",p.getYears(),p.getMonths(),p.getDays());


    }

    private static void dateTimeOfMethod() {
        //There are many overloaded methods present which takes differenet unputs

        //Consider 2/10/2000 8 pm

        LocalDateTime dt = LocalDateTime.of(2000,10,2,20,0);

        LocalDateTime dt2 = LocalDateTime.of(2001, Month.DECEMBER,7,11,30,53);

        System.out.println(dt + " \n" + dt2);

        //Operations that can be performed
        System.out.println(dt.plusYears(23));

        System.out.println(dt2.minusMonths(14).minusDays(5).plusHours(9).minusMinutes(30));

    }

    private static void dateTimeObject() {
        System.out.println("Using Local Date Time Object:");
        LocalDateTime dt = LocalDateTime.now();
        int dd = dt.getDayOfMonth();
        int mm = dt.getMonthValue();
        int yy = dt.getYear();
        System.out.printf("%d-%d-%d\n",dd,mm,yy);


        int hh = dt.getHour();
        int mn = dt.getMinute();
        int ss = dt.getSecond();
        int ns = dt.getNano();

        System.out.printf("%d:%d:%d\n",hh,mn,ss);
    }

    private static void customFormatDate() {
        System.out.println("Using Local Date Object:");
        LocalDate date = LocalDate.now();
        int dd = date.getDayOfMonth();
        int mm = date.getMonthValue();
        int yy = date.getYear();
        System.out.printf("%d-%d-%d\n",dd,mm,yy);

        System.out.println("Using Local Time Object:");
        LocalTime time = LocalTime.now();
        int hh = time.getHour();
        int mn = time.getMinute();
        int ss = time.getSecond();
        int ns = time.getNano();

        System.out.printf("%d:%d:%d\n",hh,mn,ss);
    }
}
/**
 *  LocalDate date = LocalDate.now();
 *         System.out.println(date);
 *
 *         LocalTime time = LocalTime.now();
 *         System.out.println(time);
 *
 *         LocalDateTime dt = LocalDateTime.now();
 *         System.out.println(dt);
 */
