package MultiThreading.Revision;

import java.util.Scanner;

class Alpha extends Thread{

    public void banking(){
        System.out.println("Hey User input your id");
        Scanner in = new Scanner(System.in);
        String uname = in.next();
        System.out.println("Hey User please Enter the password");
        int pass = in.nextInt();
        System.out.println(uname+", Thanks for banking with us");
    }

    @Override
    public void run() {
        banking();
    }
}
class Beta extends Thread{

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

        @Override
        public void run() {
            printingStars();
        }
}
class Gama extends Thread{

    public void sing(){

        for(int i=0;i<5;i++){
            System.out.println("Yaha bhi hoga waha bhi hoga ab toh saare jaha me hoga");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        sing();
    }
}
public class ThreadsDemo1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application starts .......");
        Alpha a = new Alpha();
        Beta b = new Beta();
        Gama c = new Gama();

        System.out.println("Check if Aplha thread is alive:"+a.isAlive());

        a.start();
        System.out.println("Check if Aplha thread is alive:"+a.isAlive());
        b.start();
        c.start();

        /**
         * Since this method is executed by main thread, with the following line we are telling the main thread to
         * join once thread a is back. So main thread is waiting as soon as a completes, main will continue
         */
        a.join();

        System.out.println("Check if Aplha thread is alive:"+a.isAlive());


        System.out.println("Application terminates..............");

    }



}
