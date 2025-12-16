package MultiThreading;

import jdk.nashorn.internal.runtime.regexp.joni.ast.CClassNode;

class CustomerThread extends Thread{
    String name;
    static Integer custId=0;
    private static ThreadLocal tl = new ThreadLocal()
    {
        public Object initialValue(){
            return ++custId;
        }
    };
    public CustomerThread(String name){
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+ " is running with Customer Id:"+tl.get());
    }
}
public class ThreadLocalDemo {

    public static void main(String[] args) {
        CustomerThread c1 = new CustomerThread("CT-1");
        CustomerThread c2 = new CustomerThread("CT-2");
        CustomerThread c3 = new CustomerThread("CT-3");
        CustomerThread c4 = new CustomerThread("CT-4");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
