package MultiThreading.Revision.waysToCreate;

class MyTask implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class usingRunnableInterface {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
