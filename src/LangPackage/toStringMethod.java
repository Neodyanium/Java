package LangPackage;

public class toStringMethod {
    public static void main(String[] args){
        Student s2 = new Student("Aloc",47834);
        Student s1 = new Student("Purvang",46534);
        System.out.println(s1);//LangPackage.Student@6bc7c054
        System.out.println(s1.toString());//LangPackage.Student@6bc7c054
        System.out.println(s2);//LangPackage.Student@232204a1
    }
}
class Student{
    String name;
    int rollno;
    Student(){}
    Student(String name,int rollno){
        this.name=name;
        this.rollno=rollno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno=" + rollno +
                '}';
    }
}