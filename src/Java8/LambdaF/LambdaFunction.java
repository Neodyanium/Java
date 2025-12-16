package Java8.LambdaF;

@FunctionalInterface
interface Calculator{
    public int add(int a,int b);
}
interface Strings{
    public int getLength(String s);
}
interface Interf{
    public void m1();
}
public class LambdaFunction {
    /**
     * The following example is important, instead of creating a class that implements Runnable interface and then passing its value to a Thread
     * object and start a thread We will simply use anon function and define its only abstract method. Now we can use this runnable interface ref.
     * to create a child thread.
     * @param args
     */
    public static void main(String[] args) {
        Runnable r = () -> {
            for(int i = 0;i<10;i++){
                System.out.println("Side Thread from Lambda Function");
            }
        };
        new Thread(r).start();
        for(int i = 0;i<10;i++){
            System.out.println("Main Thread from Lambda Function");
        }


    }
}
class Test{
    public static void main(String[] args) {
        Calculator c = (a,b) -> a+b;

        Strings l = s ->  s.length();


    }



}
