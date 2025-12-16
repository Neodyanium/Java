package Java8.StreamAPI;

import Java8.Utility;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Battery{
    int mah;
    String brand;


    public Battery(int mah, String brand) {
        this.mah = mah;
        this.brand = brand;
    }
}

public class StreamMethods {
    public static void main(String[] args) {
        collectMethod();
        Utility.linspace();
        countMethod();
        Utility.linspace();
        sortedMethod();
        Utility.linspace();
        minMethod();
        Utility.linspace();
        maxMethod();
        Utility.linspace();
        foreach();
        Utility.linspace();
        toArrayMethod();
        Utility.linspace();
        streamOfMethod();
    }

    private static void streamOfMethod() {
        Stream<Integer> s = Stream.of(1,2,3,4,5,6,10);
        s.forEach(System.out::println);

        Integer[] arr = {4,46,4,68,798,4626,3};
        Stream<Integer> s2 = Stream.of(arr);
        //for primitives
        int[] arr2 = {4,46,4,68,798,4626,3};
        Arrays.stream(arr2);
    }

    public static void collectMethod(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(19);
        list.add(31);
        list.add(40);
        list.add(58);
        System.out.println("The OG List:"+list);
        List<Integer> evens = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("The Filtered List:"+evens);
        Map<Integer,String> binaries = list.stream().collect(Collectors.toMap(
                key -> key,
                Integer::toBinaryString
        ));
        System.out.println("Mapped to Integer and its Biary Value:"+binaries);
    }

    public static void countMethod(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(19);
        list.add(31);
        list.add(40);
        list.add(58);
        System.out.println(list);
        long oddCount = list.stream().filter(i -> i % 2 != 0 ).count();
        System.out.println("The number of Odd Number is:"+oddCount);
    }

    public static void sortedMethod(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(37);
        list.add(19);
        list.add(52);
        list.add(40);
        list.add(58);
        System.out.println("The OG List:"+list);
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List"+sorted);
        List<Integer> descend = list.stream().sorted((i1,i2) -> -(i1 - i2)).collect(Collectors.toList());
        System.out.println("Sorted List Descending Order"+descend);
        /**
         * sorted(Comparator.reverseOrder())
         * sorted((i1,i2) -> i2 - i1)
         * sorted((i1,i2) -> -(i1 - i2))
         * sorted((i1,i2) -> i2.compareInt(i1));
         * sorted( (i1,i2) -> - i1.compareInt(i2));
         */
    }

    public static void minMethod(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(19);
        list.add(31);
        list.add(40);
        list.add(58);
        System.out.println(list);
        //Get used beacause it returns Optional<Integer>
        Integer min = list.stream().min(Comparator.comparingInt(i -> i)).get();
        System.out.println("The min Number(DNSO) is:"+min);
        Integer min2 = list.stream().min(Comparator.reverseOrder()).get();
        System.out.println("The min Number(reverse) is:"+min2);
    }
    public static void maxMethod(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(19);
        list.add(31);
        list.add(40);
        list.add(58);
        System.out.println(list);
        Integer max = list.stream().max(Comparator.comparingInt(i -> i)).get();
        System.out.println("The max Number(DNSO) is:"+max);
        Integer max2 = list.stream().max(Comparator.reverseOrder()).get();
        System.out.println("The max Number(reverse) is:"+max2);

    }

    public static void foreach(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(19);
        list.add(31);
        list.add(40);
        list.add(58);
        list.stream().forEach(System.out::println);
    }

    public static void toArrayMethod(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(19);
        list.add(31);
        list.add(40);
        list.add(58);
        System.out.println(list);
        Integer[] arr = list.stream().toArray(Integer[] ::new);
        Integer[] arr2 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));


        ArrayList<Battery> batteries = new ArrayList<>();
        batteries.add(new Battery(1000,"Syska"));
        batteries.add(new Battery(20000,"MI"));
        batteries.add(new Battery(15000,"Panasonic"));

        Battery[] goodOnes = batteries.stream().filter(b -> b.mah > 10000).toArray(value -> new Battery[value]);

        System.out.println(Arrays.toString(goodOnes));



    }
}
