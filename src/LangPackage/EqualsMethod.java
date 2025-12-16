package LangPackage;

import java.sql.DriverManager;

public class EqualsMethod {
    public static void main(String[] args){
        Student s1 = new Student("Sangharsh",12);
        Student s2 = new Student("Sangharsh",12);
        Student s3 = s1;
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
        Students s4 = new Students("Harsh",14);
        Students s5 = new Students("Harsh",14);
        System.out.println(s4.equals(new Student()));

    }
}

class Students extends Student{
    Students(String name,int rollno){
        super(name,rollno);
    }
    //Accidental Overloading
//    public boolean equals(Student s){
//        return this.name.equals(s.name) && this.rollno==s.rollno;
//    }

    //Optimised 1st
    public boolean equals(Object o){
        try {
            Student s = (Student) o;
            return s.name.equals(name) && s.rollno == rollno;
        }catch (ClassCastException | NullPointerException e){
            return false;
        }
    }
    //Optimised 2
    /*
    public boolean equals(Object o){
        if(o instanceof Student){
            Student s = (Student) o;
            return name.equals(s.name) && rollno==s.rollno;
        }
        return false;
    }
     **/
}
