package MultiThreading.Revision.waysToCreate;

public class usingThreadClass extends Thread{

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        usingThreadClass thread = new usingThreadClass();
        thread.start();
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
