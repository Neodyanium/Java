package Java8;

import java.util.Comparator;

interface Interf{
    default void m1(){
        System.out.println("Default m1 method");
    }
}

public class DefaultMethod implements Interf {

    public static void main(String[] args) {

        DefaultMethod df = new DefaultMethod();

        df.m1();




    }
    //Comment to get the def impl
    public void m1(){
        System.out.println("Overridden m1 method");
    }
}
interface Left{
    default void method(){
        System.out.println("Left Method");
    }
}
interface Right{
    default void method(){
        System.out.println("Right Method");
    }
}
class DefaultInheritance implements Left,Right{
    public static void main(String[] args) {
        DefaultInheritance df = new DefaultInheritance();
        df.method();
    }


    @Override
    public void method() {
        Left.super.method();
    }
}
