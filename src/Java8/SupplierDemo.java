package Java8;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) throws InterruptedException {
       basic();
       Utility.linspace();
       lilmore();
        Utility.linspace();
        otp();
        Utility.linspace();
        password(); // Very Good Example
    }

    /***
     * Rules:
     * 1) The password is 8 characters long
     * 2) The password at places 2,4,6,8 should be digit
     * 3) The remaining places can be capital letter or one of the 3 symbols @, # ,$
     */
    private static void password() {
        Supplier<String> password = () -> {
            Supplier<Integer> digit =  () -> (int)(Math.random() * 10);
            Supplier<Character> chars = () -> {
                String c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
                int idx = (int) (Math.random() * 29);
                return c.charAt(idx);
            };
            String pass = "";
            for(int i=1;i<=8;i++){
                if(i % 2 != 0){
                    pass = pass + chars.get();
                }
                else{
                    pass = pass + digit.get();
                }
            }
            return pass;
        };
        System.out.println(password.get());
    }

    private static void otp() {
        Supplier<Integer> otp = () ->{
            int code = 0;
            for(int i=0;i<6;i++){
                int random = (int) (Math.random() * 10);
//                System.out.println("random:"+random);
                code = code * 10 + random;
            }
            return code;
        };
        System.out.println(otp.get());
        System.out.println(otp.get());
    }

    private static void lilmore() {
        Supplier<String> lottery = () ->{
            String[] arr = {"1","10","50","100","10000","Bado Ruck"};
            Random r = new Random();
            int idx = r.nextInt(5);
            idx = (int)(Math.random() * 6);
            return arr[idx] + "$ won";
        };
        System.out.println(lottery.get());
    }

    public static void basic() throws InterruptedException{
        Supplier<Date> date = ( ) -> new Date();
        for(int i=0;i<10;i++){
            System.out.println(date.get());
            Thread.sleep(1000);
        }
    }
    /**
     * Fri Aug 23 00:43:38 IST 2024
     * Fri Aug 23 00:43:40 IST 2024
     * Fri Aug 23 00:43:42 IST 2024
     * Fri Aug 23 00:43:44 IST 2024
     * Fri Aug 23 00:43:46 IST 2024
     * Fri Aug 23 00:43:48 IST 2024
     * Fri Aug 23 00:43:50 IST 2024
     * Fri Aug 23 00:43:52 IST 2024
     * Fri Aug 23 00:43:54 IST 2024
     * Fri Aug 23 00:43:56 IST 2024
     */
}
