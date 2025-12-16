package Java8.LambdaF;


interface Interface{
    public void m1();
}
//Here Anon Inner class is used for the implementation of interface and the variable x created there would be considered instance variable for that
// internal class, as for lambda function it is a local variable
public class LambdaVsAnon {

    int x = 888;

    public void m2(){
        Interface i = new Interface() {
            int x = 999;
            @Override
            public void m1() {
                System.out.println(this.x);
            }
        };
        i.m1();
    }
    public static void main(String[] args) {
        LambdaVsAnon test = new LambdaVsAnon();
        test.m2();

    }
}
//here lambda is used to create the Interface child object and we can see with this keyword the value x accessed is of outer class.
class LambdaVsAnon2{

    int x = 888;

    public void m2(){
        Interface i = () -> {
            int x = 999;
            System.out.println(this.x);
        };
        i.m1();
    }
    public static void main(String[] args) {
        LambdaVsAnon2 test = new LambdaVsAnon2();
        test.m2();

    }

}
class Test2{
    int x = 10;

    public void m2(){
        int y=20;

        Interface i = () ->{
            System.out.println(x);
            System.out.println(y);
        };

        i.m1();
        
    }
}