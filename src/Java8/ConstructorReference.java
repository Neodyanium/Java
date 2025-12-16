package Java8;

import java.util.ArrayList;

class Sample{
    Sample(){
        System.out.println("Sample class Constructor called and Object created");
    }
}
interface Temp{
    public Sample get();

}
public class ConstructorReference {

    public static void main(String[] args) {

        Temp t = Sample::new; // It only provides the reference of the constructor, when we actucally use that reference with method call only then object is created
        Sample s = t.get();
//        ArrayList<Integer> list = ArrayList::new;
    }
}
