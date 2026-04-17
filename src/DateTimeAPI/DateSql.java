package DateTimeAPI;

import java.sql.Date;

public class DateSql {
    public static void main(String[] args) {
        /**
         * No Zero parameterized constructor, you provide the time and it returns date
         */
        Date date = new Date(1214540666);
        System.out.println(date);
        System.out.println(date.toGMTString());
    }

}
