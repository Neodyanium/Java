package MultiThreading.Revision;

/**
 * Running the following code with the current setting, the producer is producing values and consumer is consuming
 * the same values multiple times or it is lagging. Since there is no communication Producer keeps executing without
 * waiting for the consumer to complete.
 what the code looked like back then:

 class Producer extends Thread{
    int i;
    Queue q;
    Producer(Queue queue){
        this.q = queue;
    }
 //The threads task is to infinitely generate data
    public void run(){
        while(true){
            q.produce(i++);
        }
    }
 }
 // This class/Thread will be responsible for consuming data
 class Consumer extends Thread{
    Queue q;
    public Consumer(Queue queue){
        this.q = queue;
    }

    public void run(){
        while (true){
            q.consume();
        }
    }
 }
 // A Buffer/Mediator class, that facilitates communication, without it they would need to be tightly coupled
 class Queue {

    int data;

    public void produce(int i){
        data = i;
        System.out.println("Producer is producing "+data);
    }

    public void consume(){
        System.out.println("Consumer is consuming "+data);
    }
 }

 Understanding the flow of the program is necessary, as  both the threads runs almost simultaneously, we used a flag
 in Buffer class, initailly when a Producer produces the flag is not set, we fetch the value and set the flag, so it
 is ready to consume. Now the consumer class checks the flag, since it is true it means data is available for
 consumption so it consumes and unset the flag. Since both the threads are running together the time when consumer
 checked the flag it might not be set and it went to the else part in wait() state. So when we first produce the data
 it is necessary we notify the waiting thread, same is the case with producer thread, it's a infinite loop so when
 the consumer is consuming the flag is true, so producer thread gets in wait() state and as the consumer thread
 notifies after it consumes the data
 */

// This class/Thread will be responsible for producing data
class Producer extends Thread{
    int i;
    Queue q;
    Producer(Queue queue){
        this.q = queue;
    }
    //The threads task is to infinitely generate data
    public void run(){
        while(true){
            q.produce(i++);
        }
    }

}
// This class/Thread will be responsible for consuming data
class Consumer extends Thread{
    Queue q;
    public Consumer(Queue queue){
        this.q = queue;
    }

    public void run(){
        while (true){
            q.consume();
        }
    }

}
// A Buffer/Mediator class, that facilitates communication, without it they would need to be tightly coupled
class Queue {

    int data;
    boolean flag =false;

    synchronized public void produce(int i){
        if(flag==false){
            data = i;
            System.out.println("Producer is producing "+data);
            flag = true;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized public void consume(){
        if(flag == true){
            System.out.println("Consumer is consuming "+data);
            flag = false;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class InterThreadComm {
    public static void main(String[] args) {
        Queue queue = new Queue();

        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        p.start();
        c.start();
    }

}
