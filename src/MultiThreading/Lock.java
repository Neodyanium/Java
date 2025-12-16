package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;
class Display2{
    ReentrantLock l = new ReentrantLock();
    public void wish(String name){
        l.lock();
        for (int i = 0; i < 10; i++) {
            System.out.print("Good Morning:");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            System.out.println(name);
        }
        l.unlock();
    }
}
class ThreadA extends Thread{
    Display2 d;
    String name;
    ThreadA(Display2 d,String name){
        this.d=d;
        this.name=name;
    }
    public void run(){
        d.wish(name);
    }
}
public class Lock {
    public static void main(String[] args){
        Display2 d = new Display2();
        ThreadA t = new ThreadA(d,"Child");
        d.wish("Main");
        t.start();
    }
}

