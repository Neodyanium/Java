package MultiThreading;

public class Synchronized {
    public static void main(String[] args){
        Display d = new Display();
        ThreadImpl t = new ThreadImpl(d,"Harsh");
        ThreadImpl t1 = new ThreadImpl(d,"Sang");
        t.start();
        t1.start();
    }
}
class Display {
    public synchronized void wish(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Good Morning:");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            System.out.println(name);
        }
    }
}
class ThreadImpl extends Thread{
    Display d;
    String name;
    ThreadImpl(Display d,String s){
        this.d=d;
        this.name=s;
    }
    public void run(){
        d.wish(name);
    }
}