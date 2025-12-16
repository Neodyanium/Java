package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

class cThread extends Thread{
    static ReentrantLock l = new ReentrantLock();
    cThread(String name){
        super(name);
    }
    public void run(){
        if(l.tryLock()){
            System.out.println(Thread.currentThread().getName()+" acquired the Lock");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){

            }
            System.out.println("Now "+Thread.currentThread().getName()+" releasing lock");
        }else{
            System.out.println(Thread.currentThread().getName()+" couldn't acquire the Lock");
        }
    }
}
public class TryLock {
    public static void main(String[] args){
        cThread t = new cThread("First Thread");
        cThread t2 = new cThread("Second Thread");
        t.start();
        t2.start();
    }
}
