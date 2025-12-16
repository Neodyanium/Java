package Java8;

import java.util.Scanner;
import java.util.function.Predicate;
@java.lang.FunctionalInterface
public interface FunctionalInterface {

    public int numbers();

    public static String color(){
        return "red";
    }

    default double leadSize(){
        return 0.5d;
    }

}

