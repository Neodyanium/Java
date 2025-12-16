package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Job implements Runnable {
    String name;
    public Job(String name){
        this.name=name;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " is Performing "+this.name +"'s Job");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){

        }
        System.out.println(Thread.currentThread().getName()+" Completed "+this.name+"'s Job");
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        Job[] jobs = {
                new Job("Sangharsh"),
                new Job("Purvang"),
                new Job("Abhi"),
                new Job("Aloc"),
                new Job("Aditya"),
                new Job("Vishal")
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(Job job : jobs){
            service.submit(job);
        }
        service.shutdown();
        //Program didn't stop even after all execution maybe it require to turn down thread pool
    }
}
