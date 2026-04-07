package ExceptionHandeling;

import com.sun.xml.internal.ws.api.model.CheckedException;

import java.io.UncheckedIOException;

public class Test {
    public static void main(String[] args) {

        try{
            System.out.println("Statement 1");
            System.out.println(10/0);
            System.out.println("Statement 3");
            try{
                System.out.println("Statement 4");
                System.out.println("Statement 5");
                System.out.println("Statement 6");
            }catch (Exception e){
                System.out.println("Statement 7");
            }finally{
                System.out.println("Statement 8");
            }
            System.out.println("Statement 9");
        }catch (NullPointerException e){
            e.getMessage();
            System.out.println("Statement 10");
        }
        finally {
            System.out.println("Statement 11");
        }
        System.out.println("Statement 12");


    }


}
