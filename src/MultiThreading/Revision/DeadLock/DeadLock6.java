package MultiThreading.Revision.DeadLock;

/**
 * This example properly utilises the usage of classes and methods to illustrate deadlock
 */
class A {

    public synchronized void d1(B b) {
        System.out.println("Inside Parent Thread d1 Method");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){

        }
        System.out.println("Parent Trying to execute b's last method");
        b.last();
    }

    public synchronized void last() {
        System.out.println("last() method from A class");
    }
}
class B {
    public synchronized void d2(A a) {
        System.out.println("Inside Child Thread d2 Method");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){

        }
        System.out.println("Child Trying to execute a's last method");
        a.last();
    }

    public synchronized void last() {
        System.out.println("last() method from B class");
    }
}
class DeadLockDemo extends Thread{
    A a = new A();
    B b = new B();

    public void m1(){
        this.start();
        a.d1(b);
    }

    public void run(){
        b.d2(a);
    }


    public static void main(String[] args){
        DeadLockDemo deadLock = new DeadLockDemo();
        deadLock.m1();
    }
}
