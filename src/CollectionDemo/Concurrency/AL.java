package CollectionDemo.Concurrency;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AL {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        for (Integer integer : list) {
            System.out.println(integer);
            list.add(69);
        }
    }
}
