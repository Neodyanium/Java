package MultiThreading.Revision.DeadLock;

/**
 * We are considering an example where 2 students are entering a library, the library has 3 books that both the
 * student wants the problem is there is only 1 such book. Here is an example of how synchronized keyword can be used
 *
 * Case 1 is library class which shows a proper use of synchronized keyword, where they both enter together but
 * whoever gets the resource first will continue to have it
 *
 * Case 2, is a deadlock illustration, instead of taking resource 1 by 1, student 1 takes res1 and student2 takes
 * res3. Now they both are sleeping , whichever gets a chance now executes and get the res2, now consider Student1
 * has got res2 it will go to sleep, Student2 will be blocked as he is waiting for res2 to be available, Student1
 * gets to runnable state, but it blocked at he is waiting for res3 to be available.
 */

class Library extends Thread{

    String res1 = "Java";
    String res2 = "Springboot";
    String res3 = "DSA";


    public void run(){
        String name = Thread.currentThread().getName();
        if(name.equals("Student1")){
            try {
                System.out.println(name + " has entered the library");
                synchronized(res1) {
                    System.out.println(name +" has acquired "+res1);
                    Thread.sleep(3000);
                    synchronized(res2) {
                        System.out.println(name +" has acquired "+res2);
                        Thread.sleep(3000);
                        synchronized(res3) {
                            System.out.println(name +" has acquired "+res3);
                            Thread.sleep(3000);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else{
            try {
                System.out.println(name + " has entered the library");
                synchronized(res1) {
                    System.out.println(name +" has acquired "+res1);
                    Thread.sleep(3000);
                    synchronized(res2) {
                        System.out.println(name +" has acquired "+res2);
                        Thread.sleep(3000);
                        synchronized(res3) {
                            System.out.println(name +" has acquired "+res3);
                            Thread.sleep(3000);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class LibraryImpl extends Thread{

    String res1 = "Java";
    String res2 = "Springboot";
    String res3 = "DSA";

    public void run(){
        String name = Thread.currentThread().getName();
        if(name.equals("Student1")){
            try {
                System.out.println(name + " has entered the library");
                synchronized(res1) {
                    System.out.println(name +" has acquired "+res1);
                    Thread.sleep(3000);
                    System.out.println(name +" has returned "+res1);
                    synchronized(res2) {
                        System.out.println(name +" has acquired "+res2);
                        Thread.sleep(3000);
                        System.out.println(name +" has returned "+res2);
                        synchronized(res3) {
                            System.out.println(name +" has acquired "+res3);
                            Thread.sleep(3000);
                            System.out.println(name +" has returned "+res3);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else{
            try {
                System.out.println(name + " has entered the library");
                synchronized(res3) {
                    System.out.println(name +" has acquired "+res3);
                    Thread.sleep(3000);
                    System.out.println(name +" has returned "+res3);
                    synchronized(res2) {
                        System.out.println(name +" has acquired "+res2);
                        Thread.sleep(3000);
                        System.out.println(name +" has returned "+res2);
                        synchronized(res1) {
                            System.out.println(name +" has acquired "+res1);
                            Thread.sleep(3000);
                            System.out.println(name +" has returned "+res1);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class DeadLock {

    public static void main(String[] args) {

        LibraryImpl l = new LibraryImpl();

        Thread s1 = new Thread(l,"Student1");
        Thread s2 = new Thread(l,"Student2");

        s1.start();
        s2.start();

    }


}
