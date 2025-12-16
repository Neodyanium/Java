package MultiThreading;

public class ThreadGroup {
    public static void main(String[] args){
        java.lang.ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] t = new Thread[system.activeCount()];
        system.enumerate(t);
        System.out.println("ThreadName  |    IsDaemon   |   Priority");
        for(Thread th:t){
            System.out.println(th.getName()+"------"+th.isDaemon()+"------"+th.getPriority());
        }
    }
}
