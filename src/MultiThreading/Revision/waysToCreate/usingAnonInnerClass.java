package MultiThreading.Revision.waysToCreate;

public class usingAnonInnerClass {


    public static void main(String[] args) {

        /**
         * Anon Innner class with the Runnable Interface
         */
        Runnable r = new Runnable() {
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

        /**
         * Anon Inner class with the Thread class
         */

        Thread t2 = new Thread(){
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
        };

        t2.start();
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
