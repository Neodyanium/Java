package MultiThreading.Revision;

class Car implements Runnable{
    //remove the synchronised keyword to see some Jalwa
    //Here the following resource will be locked by one of the threads after completing its task, other thread will
    // aquire it and perform its task

    synchronized public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+" entered the Parking Lot");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" has entered the Car");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" is now driving the Car");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" has returned and Parked the Car");

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}

/**
 * This class was made only to provide the info on partial synchronization, you can synchronize a part of code.
 */
class Car2 implements Runnable{
    //remove the synchronised keyword to see some Jalwa
    //Here the following resource will be locked by one of the threads after completing its task, other thread will
    // aquire it and perform its task

    public void run(){
        try{
            //anyone can enter the parking lot so, its a public resource
            System.out.println(Thread.currentThread().getName()+" entered the Parking Lot");
            Thread.sleep(3000);
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " has entered the Car");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " is now driving the Car");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " has returned and Parked the Car");
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
public class Synchoronised3 {
    public static void main(String[] args) throws InterruptedException {

        Car2 c = new Car2();
        Thread t1 = new Thread(c,"Sangharsh");
        Thread t2 = new Thread(c,"Goodu");
        Thread t3 = new Thread(c);
        t3.setName("Mannu");

        t1.start();
        t2.start();
        t3.start();


        

    }
}
