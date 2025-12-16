package Java8.BiFunctionalInterfaces;

import Java8.Utility;

import java.util.function.BiFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {
//        Integer i = new Integer(10);
//        int t = i.intValue();
//        int i = new Integer(10);
//        ToIntFunction<>

        BiFunction<String,Integer,String> multiplier = (s,n) ->{
            String result = "";
            for(int i=0;i<n;i++){
                result += s + " " ;
            }
            return result;
        };
        System.out.println(multiplier.apply("Halo",4));
        Utility.linspace();
        example2();

    }

    public static void example2(){
        BiFunction<String,Integer,Student> student = (s,n) -> new Student(s,n);
        Student s = student.apply("Krish",21);
    }
}
class Student{
    String name;
    int rollno;

    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }
}