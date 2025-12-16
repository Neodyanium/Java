package InnerClasses;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import java.util.Map;

public class AnonInnerClass {
    public static void main(String[] args) {
        anonymousClass();
        System.out.println("----------");
        anonymousInterface();
        System.out.println("----------");
        anonArgs();

    }
    public static void anonArgs(){
        new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<10;i++){
                    System.out.println("Child");
                }
            }
        }).start();
        for(int i=0;i<10;i++){
            System.out.println("Main");
        }
    }
    public static void anonymousClass(){
            Thread t = new Thread(){
                public void run(){
                    for(int i=0;i<10;i++){
                        System.out.println("Child");
                    }
                }
            };
            t.start();
            for(int i=0;i<10;i++){
                System.out.println("Main");
            }
        }

        public static void anonymousInterface(){
            Runnable r = new Runnable(){
                public void run(){
                    for(int i=0;i<10;i++){
                        System.out.println("Child");
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
            for(int i=0;i<10;i++){
                System.out.println("Main");
            }
        }

}
