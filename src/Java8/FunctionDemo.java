package Java8;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<String,Integer> len = String::length;
        System.out.println(len.apply("Sangharsh"));

        Function<Integer,Integer> square = i -> i*i;
        System.out.println(square.apply(5));
    }
}
class Test2{

    public static void main(String[] args) {
        removeSpace();
        totalSpaces();
    }

    /**
     * Write a program to remove spaces from a given String
     */
    public static void removeSpace(){
        String sample = "    Hello,   How are   you ?  ";
        Function<String,String> spaceRemover = s -> s.replaceAll(" ","");
        System.out.println(spaceRemover.apply(sample));
    }

    public static void totalSpaces(){
        String sample = "    Hello,   How are   you ?  ";
        Function<String,Integer> ts = s -> s.length() - s.replaceAll(" ","").length();
        System.out.println(ts.apply(sample));
    }
}
class FunctionChain{
    public static void main(String[] args) {
        basicUsage();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        differenceBetweenFunctions();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        uselessStaticMethod();
    }

    private static void uselessStaticMethod() {
        Function<String,String> f = Function.identity();
        System.out.println(f.apply("Sanghrahs"));
    }

    public static void basicUsage(){
        String uname = "SangharshPipare";
        Function<String,String> ucase = s -> s.toUpperCase();
        Function<String,String> limit = s -> s.substring(0,9);
        System.out.println("OG String:"+uname);
        System.out.println("f1: " + ucase.apply(uname));
        System.out.println("f2: " + limit.apply(uname));
        System.out.println("f1 andThen f2: " + ucase.andThen(limit).apply(uname));
        System.out.println("f1 compose f2: " + ucase.compose(limit).apply(uname));
    }

    /**
     * andThen is used when you want to apply a function and then another one to its result, which follows a natural flow: "do this, then do that."
     * compose is used when you want to first prepare the input by applying another function before your main function. This reads as: "prepare this, then do that."
     */
    public static void differenceBetweenFunctions(){
        Function<Integer,Integer> f1 = i -> i + i;
        Function<Integer,Integer> f2 = i -> i * i * i;

        System.out.println("AndThen: "+f1.andThen(f2).apply(2));
        System.out.println("Compose: "+f1.compose(f2).apply(2));
        System.out.println("AndThen f1 and f2 swap: "+f2.andThen(f1).apply(2));


    }
}