package CollectionDemo.CustomSorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Comparable is a interface that is used to provide a default natural sorting order, it should be used when you have
 * access to the class and can modify it.
 */
class Student implements Comparable<Student>{
    int rollNo;
    String name;
    int standard;


    public Student(int rollNo, String name, int standard) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", standard=" + standard +
                '}';
    }

    public int compareTo(Student s){
        if(this.rollNo > s.rollNo) return 1;
        return -1;
    }
}
public class ComparableDemo {

    public static void main(String[] args) {
        Student s1 = new Student(12,"Sangharsh",12);
        Student s2 = new Student(4,"Nandini",11);
        Student s3 = new Student(25,"Aarti",10);
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);
    }
}
