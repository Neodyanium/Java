package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Student{
    String name;
    int marks;

    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

//    public String toString(){
//        return name + "=" + marks;
//    }
}
class ConsumerChaining{
    public static void main(String[] args) {
        Consumer<String> greet = name -> System.out.print("Hello,"+name);
        Consumer<String> exclamation = s -> System.out.println("!");

        String s = "dfjhd";


        greet.andThen(exclamation).accept("Sangharsh");


        /**
         * Movie class has name and feeling(Hit,Flop)
         * A Good example for this will be
         * c1 -> name of the movie and, it's ready to release
         * c2 -> Movie name has been movie.feeling
         * c3 -> Movie name , saving in the DB
         */
    }
}
public class ConsumerDemo {


    public static void main(String[] args) {
        List<Student> list = getStudents();
        Predicate<Integer> p = marks -> marks >= 60;
        Function<Student,String> grade = student -> {
            if(student.marks >= 80)
                return "A";
            else if(student.marks >= 70)
                return "B";
            else if(student.marks >= 60)
                return "C";
            else if(student.marks >= 50)
                return "D";
            else if(student.marks >= 35)
                return "E";
            else return "F";
        };
        Consumer<Student> print = s -> {
            System.out.println(s.name + "=" + s.marks+ " ," +grade.apply(s) + " Grade");
        };

        for(Student s : list){
            if(p.test(s.marks)){
                print.accept(s);
            }
        }

    }

    public static List<Student> getStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ramesh",60));
        list.add(new Student("Alok",82));
        list.add(new Student("Champa",32));
        list.add(new Student("Shila",45));
        list.add(new Student("Arohi",75));
        return list;
    }
}
