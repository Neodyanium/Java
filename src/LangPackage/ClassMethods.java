package LangPackage;

import java.lang.reflect.Method;

public class ClassMethods {
    public static void main(String[] args) throws ClassNotFoundException{
        Class c = Class.forName("java.lang.Object");
        Method[] methods = c.getDeclaredMethods();
        int count=0;
        for(Method m:methods){
            count++;
            System.out.println(m);
        }
        System.out.println("Total methods in Object Class"+count);
    }
}
