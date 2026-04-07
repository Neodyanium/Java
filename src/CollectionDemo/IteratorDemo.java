package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        /**
         * It is a fail fast mechanism, as soon as concurrent modif is noticed it throws Exception
         */
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        //apparently the iterator is internal class in AL
        Iterator<Integer> itr = al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        itr = al.iterator();

        System.out.println("--------------------------------------------------------------------------------");

        // we can use list iterator like a regular iterator, but we can also provide a start index for the iterator
        ListIterator<Integer> listitr = al.listIterator(al.size());
        while(listitr.hasPrevious()){
            System.out.println(listitr.previous());
        }

        System.out.println("--------------------------------------------------------------------------------");

        //fail fast
        while(itr.hasNext()){
            System.out.println(itr.next());
            al.add(100);
        }

    }
}
