package CollectionDemo;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args){
        Comparator<Integer> MyComparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                if(i1 > i2) return i2-i1;
                else if(i1 < i2) return i2-i1;
                return 0;
            }
        };

        TreeSet<Integer> t = new TreeSet<>();
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Alpha");
        ts.add("Beta");
        ts.add("Astro");
        ts.add("Alone");
        System.out.println(ts);
        t.add(4);
        t.add(1);
        t.add(5);
        t.add(9);
        t.add(6);
        System.out.println(t);

    }
}
