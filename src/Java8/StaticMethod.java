package Java8;

import java.util.Arrays;

interface Interface{
    public static void m1(){
        System.out.println("static method Implementation");
    }
}
//Only way to use it using the Interface class name
public class StaticMethod implements Interface{
    public static void main(String[] args) {

        //m1();
        StaticMethod st = new StaticMethod();
        //st.m1();
        //StaticMethod.m1();
        Interface.m1();
    }
}
//If we can add static methods to an interface then we can also add main method, its legit and does works
interface Run{
    public static void main(String[] args) {
        Integer[] arr = {45,12,90,17,34,47};
        Arrays.sort(arr,(x,y) -> y-x);
        System.out.println(Arrays.toString(arr));
    }
}
