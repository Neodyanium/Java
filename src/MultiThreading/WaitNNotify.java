package MultiThreading;

public class WaitNNotify {
    static public void main(String[] args)throws InterruptedException{
        MyThread t = new MyThread();
        t.start();
        synchronized (t){
            System.out.println("Main Thread trying to call wait method");
            t.wait();
            System.out.println("Got notification from Child Thread");
            System.out.println(t.total);
        }
    }
}
class MyThread extends Thread{
    int total=0;
    public void run() {
        synchronized (this){
            System.out.println("Started the Child Thread");
            for(int i=1;i<=100;i++){
                total = total+i;
            }
            System.out.println("Child Thread Notifying the main thread");
            this.notify();
        }
    }
}
