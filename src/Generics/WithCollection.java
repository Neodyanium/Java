package Generics;

import java.util.ArrayList;
import java.util.List;

class Human{

    int age;

    public void display(){
        System.out.println("Humans are good creatures");
    }

}

class Student extends Human{

}

class Employee{

}
public class WithCollection {
    public static void main(String[] args) {
        // Understand some relationships

        Object o = new Object();
        String s = new String("Lol");

        o = s;

        //s = o; (unless)

        Human h = new Human();

        Student st = new Student();

        h = st; // allwed, Parent ref child Obj

        //s = h; child ref to Parent obj not allowed unless
        st = (Student) h;

        ArrayList<Human> hlist = new ArrayList<>();
        ArrayList<Student> slist = new ArrayList<>();
        ArrayList<Employee> elist = new ArrayList<>();

        //The following is not allowed, CE incompatible types, so a List of Parent type can't hold the Child List
        //hlist = slist;

        /**
         * Here the ? is called wildcard or unknown type. So it can take any type of List
         */
        ArrayList<?> hlist2 = new ArrayList<>();
        ArrayList<Student> slist2 = new ArrayList<>();
        hlist2 = slist2;
        hlist2 = elist; //It can hold unrelated list, although it can take any time so, it doesn't prove anything

        /**
         * The following means, Any Type that extends Human or Any type that is children of Human. This also includes
         * Human. This is called Upperbound either Human child or any children of Humans
         */

        ArrayList<? extends Human> hlist3 = new ArrayList<>();
        ArrayList<Human> plist = new ArrayList<>();
        ArrayList<Student> slist3 = new ArrayList<>();

        hlist3 = plist;
        hlist3 = slist3;

        // hlist = emplist; unrealted class thus CE

        /**
         * Now we will try, Any type that is Parent of Human or at least Human. This is the lowerbound
         */

        ArrayList<? super Human> hlist4 = new ArrayList<>();
        ArrayList<Student> slist4 = new ArrayList<>();
        //  hlist4 = slist4;  this is not allowed
        //   hlist4 = elist; also not allowed due to no connection
        ArrayList<Object> olist = new ArrayList<>();

        hlist4 = olist; //since object list is parent of the human list

        ArrayList<Human> hlist5 = new ArrayList<>();
        hlist5.add(new Human());
        hlist5.add(new Human());
        hlist5.add(new Human());

        ArrayList<Student> slist5 = new ArrayList<>();
        slist5.add(new Student());
        slist5.add(new Student());
        slist5.add(new Student());

        /**
         * This is how the ? has helped us to overload a method to accept a list of parent and its child, we could
         * not achieve this directly.
         */
        display(hlist5);
        display(slist5);

    }

    public static void display(List<? extends Human> list){
        for(Human h:list){
            System.out.println(h);
        }
    }
}
