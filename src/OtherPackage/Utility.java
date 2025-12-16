package OtherPackage;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utility{
    static ArithmeticException e;

    int util;

    Utility(){}

    Utility(int i){
        this();
    }

    public int returner(){return 10;}


    public static void main(String args[]) throws IOException{
        ArrayList<Integer> l  = new ArrayList<>();
        Utility u = new Utility(2);
        System.out.println(e.getMessage());
//        Thread.sleep(20000);
        try(BufferedReader bf = new BufferedReader(new FileReader("abc.txt"))){

        }





    }
}


