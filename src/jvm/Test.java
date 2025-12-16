package jvm;

public class Test {
    public static void main(String[] args) {

        System.out.println(String.class.getClassLoader());

        System.out.println(Test.class.getClassLoader());

        System.out.println(Customer.class.getClassLoader());


        double mb = 1024*1024;

        Runtime r = Runtime.getRuntime();

        System.out.println("Initial Memory:"+r.totalMemory()/mb);
        System.out.println("Max Memory:"+r.maxMemory()/mb);
        System.out.println("Free Memory:"+r.freeMemory()/mb);
        System.out.println("Consumed Memory:"+ (r.totalMemory() - r.freeMemory())/mb);


    }
    static Customer t = new Customer();
}
