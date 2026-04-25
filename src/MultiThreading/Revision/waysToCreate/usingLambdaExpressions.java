package MultiThreading.Revision.waysToCreate;

public class usingLambdaExpressions {

    public static void main(String[] args) {
        Runnable r = () -> {
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
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
