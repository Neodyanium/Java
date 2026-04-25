package MultiThreading.Revision.DeadLock;

/**
 * This is a great and easy to think example, make 2 threads class with each having 2 sync methods, let the Thread 1
 * method call thread 2 2nd method and Thread 2 second method call Thread 1 first method. Major point is 1 thread
 * loacks a resource and sleeps, so 2nd thread locks a resource and sleeps, now when they both are in runnable
 * conditions they require a resource that other thread is locking, so they both remain blocked infinitely
 */
class DeadlockExample {
    public static void main(String[] args) {
        final String book = "Java Programming Book";
        final String pen = "Blue Pen";

        // Thread 1: Student A
        Thread studentA = new Thread(() -> {
            synchronized (book) {
                System.out.println("Student A: Locked Book");

                try {
                    Thread.sleep(100);
                } catch (Exception ignored)
                {

                }

                synchronized (pen) {
                    System.out.println("Student A: Locked Pen");
                }
            }
        });

        // Thread 2: Student B
        Thread studentB = new Thread(() -> {
            synchronized (pen) {
                System.out.println("Student B: Locked Pen");

                try {
                    Thread.sleep(100);
                } catch (Exception ignored)
                {

                }

                synchronized (book) {
                    System.out.println("Student B: Locked Book");
                }
            }
        });

        studentA.start();
        studentB.start();
    }
}