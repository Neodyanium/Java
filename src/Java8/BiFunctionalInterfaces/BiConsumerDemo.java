package Java8.BiFunctionalInterfaces;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String,String> concatenate = (s1,s2) -> System.out.println(s1+s2);
        concatenate.accept("Sangharsh","Pipare");
    }
}
