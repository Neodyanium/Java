package InnerClasses;

import java.util.*;

public class MLICAccess {
    int x=10;
    static int y =20;
    public void m1(){
        int k=30;
        final int m = 40;
        class Inner {
            public void m2() {
                System.out.println(x+" "+y+" "+" "+k+" "+m);
            }
        }
            Inner i = new Inner();
            i.m2();
        }
    public static void main(String[] args){
        MLICAccess l = new MLICAccess();
        l.m1();

    }
}
