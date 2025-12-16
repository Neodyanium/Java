package Java8.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(19);
        list.add(17);
        list.add(2);
        list.add(9);
        List<Integer> twice = list.stream().map((i) -> i * 2).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(twice);
    }
}
