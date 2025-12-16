package MultiThreading.classical;

import Java8.Utility;

class MyRunnable implements Runnable{

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Child Thread from Runnable Class");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
class MyThread extends Thread{
    public void run(){
        System.out.println("Child Thread Priority:"+Thread.currentThread().getPriority());
        for(int i=0;i<10;i++){
            System.out.println("Child Thread from Thread Class");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new MyRunnable();
        Thread t = new MyThread();
        t.start();
        for(int i=0;i<10;i++){
            System.out.println("Main Thread");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        //Thread Name
        Utility.linspace();

        System.out.println("Current Thread Name:" + Thread.currentThread().getName());
        Thread.currentThread().setName("Oye Papaji (Main Thread)");
        System.out.println("Current Thread Name:" + Thread.currentThread().getName());

        Utility.linspace();

        MyThread t2 = new MyThread();
        t2.setPriority(10);
        t2.start();
        System.out.println("Current Thread Priority:"+Thread.currentThread().getPriority());
        for(int i=0;i<10;i++){
            System.out.println("Main Thread");
            Thread.sleep(200);
        }



    }

}
