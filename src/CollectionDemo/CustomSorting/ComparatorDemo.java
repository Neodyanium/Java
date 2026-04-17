package CollectionDemo.CustomSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Cricket{
    int jno;
    String name;
    double avg;


    public Cricket(int jno, String name, double avg) {
        this.jno = jno;
        this.name = name;
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Cricket{" +
                "jno=" + jno +
                ", name='" + name + '\'' +
                ", avg=" + avg +
                '}';
    }
}

/**
 * 1) implement interface, pass a object of that class in the sort method.
 * 2) Anonymous inner class, since it has only 1 method, you add while creating an object, or we can add it directly in the sort method.
 * 3) Lambda expression
 *
 * It should be used when you need to sort in a certain order, or if you don;t have the access to modify the class
 * you want to sort
 */
class CricketComparator implements Comparator<Cricket>{
    public int compare(Cricket c1,Cricket c2){
        if(c1.avg > c2.avg){
            return 1;
        }else{
            return -1;
        }
    }
}
public class ComparatorDemo {

    public static void main(String[] args) {
        Cricket virat = new Cricket(18, "Virat", 88.2);
        Cricket rohit = new Cricket(45, "Rohit", 75);
        Cricket dhoni = new Cricket(7, "Dhoni", 69);
        ArrayList<Cricket> list = new ArrayList<>();
        list.add(virat);
        list.add(rohit);
        list.add(dhoni);
        System.out.println(list);
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        Collections.sort(list, new CricketComparator());
        System.out.println(list);

        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        Comparator<Cricket> comparator = new Comparator<Cricket>() {
            @Override
            public int compare(Cricket c1, Cricket c2) {
                if (c1.jno > c2.jno) return 1;
                return -1;
            }
        };

        Collections.sort(list,comparator);
        System.out.println(list);
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        // Here we have used a lambda expressions
        Comparator<Cricket> c = (a,b) -> a.name.compareTo(b.name);
        Comparator<Cricket> c2 = (a,b) -> (a.jno-b.jno);
        Collections.sort(list,c);
        System.out.println(list);
        System.out.println(
                "----------------------------------------------------------------------------------------------------");

        Collections.sort(list,c2);
        System.out.println(list);
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        /**
         * New way or a way that is used in modern Java
         */

        list.sort(Comparator.comparingDouble(s -> s.avg));
        System.out.println(list);
    }



}
