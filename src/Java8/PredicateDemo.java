package Java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.function.Predicate;

class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));

        //Check if collection is empty or not
        Predicate<Collection<Integer>> isEmpty = list -> list.isEmpty();
    }

    static class User{
        String username;
        String password;

        User(String Username, String password){
            this.username = Username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    static class PredicateFunctions{
        public static void m1(Predicate<Integer> predicate, int[] arr){
            for (int n : arr){
                if(predicate.test(n))
                    System.out.print(n + " " );
            }
            System.out.println();
        }

        public static void main(String[] args) {

            authenticationDemo();
            System.exit(0);


            int[] arr = {0,5,10,15,20,25,30};
            //P1
            Predicate<Integer> isEven = n -> n % 2 == 0;
            //P2
            Predicate<Integer> bigger = n -> n > 10;

            System.out.print("Even Numbers:");
            m1(isEven,arr);
            System.out.print("Odd Numbers:");
            m1(isEven.negate(),arr);
            System.out.print("Even and Bigger that Ten:");
            m1(isEven.and(bigger),arr);
            System.out.print("Even and Bigger that Ten negation:");
            m1(isEven.and(bigger).negate(),arr);
            System.out.print("Even or Bigger that 10:");
            m1(isEven.or(bigger),arr);

            String[] stuff = {"Hello",null,"   ","World","lol",null};
            Predicate<String> nonEmpty = s -> s != null && !s.isEmpty();
            for(String s:stuff){
                if(nonEmpty.test(s)){
                    //add to new list, we can avoid NPE.
                    System.out.println(s);
                }
            }


        }

        public static void authenticationDemo(){
            Predicate<User> authenticator = user -> user.getUsername().equals("DbUserName") && user.getPassword().equals("DBPassword");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Username:");
            String username = in.nextLine();
            System.out.println("Enter Password:");
            String password = in.nextLine();

            User u  = new User(username,password);

            if(authenticator.test(u))
                System.out.println("Valid User, Authentication Successful");
            else
                System.out.println("Authentication Failed");
        }


    }
}
//Little Employee Management System
/*
Create Employee class override toString.
Create some employee objects and them to an arrayList.
Complete the tasks: 1)Get all employees info 2)Employees from Bangalore info 3)Salary less than 20000 4)All Managers from Bangalore
5)Employees who are managers or salary < 20000 6)To select all who are not managers
You can create a display method which takes a Predicate<Employee> and List of Employee
 */
class Employee{
    String name;
    String designation;
    double salary;
    String location;

    public Employee(String name,String designation,double payment,String location){
        this.name = name;
        this.designation = designation;
        this.salary =payment;
        this.location = location;
    }

    public String toString(){
        return String.format("[%s,%s,%.2f,%s]",name,designation, salary,location);
    }

}
class Test{
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        propagate(employees);
//        System.out.println("All Employees:");
//        System.out.println(employees);
        Predicate<Employee> P1 = emp -> emp.location.equals("Bangalore");
        Predicate<Employee> P2 = emp -> emp.salary < 20000;
        Predicate<Employee> P3 = emp -> emp.designation.equals("Manager");

        System.out.println("Employees from Bangalore:");
        display(P1,employees);

        System.out.println("Salary less the 20k:");
        display(P2,employees);

        System.out.println("Employees with Manager Designation:");
        display(P3,employees);

        System.out.println("All Managers from Bangalore:");
        display(P1.and(P3),employees);

        System.out.println("Employees from Bangalore:");
        display(P1,employees);

        System.out.println("Employees either Manager or Salary less than 20k:");
        display(P2.or(P3),employees);

        System.out.println("Employees who are not Manager:");
        display(P3.negate(),employees);



    }

    public static void propagate(ArrayList<Employee> employees){
        employees.add(new Employee("Mamta","CEO",30000,"Hyderabad"));
        employees.add(new Employee("Sunny","Manager",20000,"Hyderabad"));
        employees.add(new Employee("Mallika","Manager",20000,"Bangalore"));
        employees.add(new Employee("Kareena","Lead",15000,"Hyderabad"));
        employees.add(new Employee("Katrina","Lead",15000,"Bangalore"));
        employees.add(new Employee("Anushka","Developer",10000,"Hyderabad"));
        employees.add(new Employee("Sowmya","Developer",10000,"Hyderabad"));
        employees.add(new Employee("Ileana","Developer",10000,"Bangalore"));
    }

    public static void display(Predicate<Employee> p,ArrayList<Employee> employees){
        for(Employee employee:employees){
            if(p.test(employee)){
                System.out.println(employee);
            }
        }
        System.out.println();
    }
}
