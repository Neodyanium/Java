package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Call implements Callable{
    int num;
    Call(int num){
        this.num=num;
    }
    public Object call() throws Exception{
        System.out.println(Thread.currentThread().getName()+" is calculating sum of first "+this.num+" numbers");
       int sum=0;
       for(int i=1;i<=num;i++){
           sum = sum+i;
       }
       return sum;
    }
}
class CallableDemo{
    public static void main(String[] args) throws Exception{
        Call[] jobs = {
                new Call(10),
                new Call(20),
                new Call(30),
                new Call(40),
                new Call(50),
                new Call(60),
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        for(Call job:jobs){
            Future f = service.submit(job);
            System.out.println(f.get());
        }
        service.shutdown();
    }
}
