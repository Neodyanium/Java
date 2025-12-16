package InnerClasses;

public class MethodLocalIC {

    public void method(){
        class Calculator{
            public void sum(int x,int y){
                System.out.println(x+y);
            }
        }
        Calculator c = new Calculator();
        c.sum(10,20);
        c.sum(100,200);
    }
    public static void main(String[] args) {
        MethodLocalIC mlic = new MethodLocalIC();
        mlic.method();
    }

}
