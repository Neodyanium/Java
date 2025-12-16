package Java8.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {

    public static boolean isEven(int n){
        return n % 2 == 0;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(19);
        list.add(17);
        list.add(2);
        list.add(9);
        List<Integer> l1 = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(l1);


    }


}
