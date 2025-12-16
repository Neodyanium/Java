package MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class LockWithTimeStamp extends Thread {
    static ReentrantLock l = new ReentrantLock();
    LockWithTimeStamp(String name) {
        super(name);
    }
    public void run() {
        do {
            try {
                if (l.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " has acquired lock");
                    Thread.sleep(20000);
                    l.unlock();
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " couldn't acquire Lock");
                }
            } catch (InterruptedException e) {
            }
        } while (true);
    }
}
public class tryLockTs {
    public static void main(String[] args){
        LockWithTimeStamp t1 = new LockWithTimeStamp("First Thread");
        LockWithTimeStamp t2 = new LockWithTimeStamp("Second Thread");
        t1.start();
        t2.start();
    }
}
