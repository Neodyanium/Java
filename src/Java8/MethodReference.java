package Java8;
interface Calculate{
    public int max(int i,int j);

}
public class MethodReference {
    public static void main(String[] args) {
        Calculate calculate = Math::max;
        System.out.println(calculate.max(10,20));
    }
}

class TestWithThreads{
    public void m1() {
        for(int i = 0; i<10; i++){
            System.out.println("Method Reference");
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new TestWithThreads()::m1;
        Thread t = new Thread(r);
        t.start();
        for(int i = 0; i<10; i++){
            System.out.println("Main Thread Reference");
            Thread.sleep(100);
        }
    }
}
