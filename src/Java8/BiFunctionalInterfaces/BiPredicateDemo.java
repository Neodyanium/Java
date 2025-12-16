package Java8.BiFunctionalInterfaces;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> isSumEven = (a,b) -> (a+b) % 2 == 0;
        System.out.println(isSumEven.test(7,11));
        System.out.println(isSumEven.test(15,20));
    }
}

