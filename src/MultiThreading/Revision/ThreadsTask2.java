package MultiThreading.Revision;

import java.util.Scanner;

class TaskRunner implements Runnable{

    public void run(){
        String threadName = Thread.currentThread().getName();
        if(threadName.equals("Bank")){
            banking();
        }else if(threadName.equals("Sing")){
            sing();
        }else{
            printingStars();
        }
    }

    public void banking(){
        System.out.println("Hey User input your id");
        Scanner in = new Scanner(System.in);
        String uname = in.next();
        System.out.println("Hey User please Enter the password");
        int pass = in.nextInt();
        System.out.println(uname+", Thanks for banking with us");
    }

    public void printingStars() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            System.out.println("**");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sing() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Yaha bhi hoga waha bhi hoga ab toh saare jaha me hoga");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
public class ThreadsTask2 {

    public static void main(String[] args) {

        TaskRunner t = new TaskRunner();

        Thread t1 = new Thread(t,"Bank");
        Thread t2 = new Thread(t,"Sing");
        Thread t3 = new Thread(t,"Stars");


        t1.start();
        t3.start();
        t2.start();
    }
}
