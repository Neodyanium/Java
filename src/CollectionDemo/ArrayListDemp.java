package CollectionDemo;
import java.util.ArrayList;
public class ArrayListDemp {
    public static void main(String[] args){
        //Warning are thrown as any Object can be added recommended to be made generic
        ArrayList a = new ArrayList();
        a.add(10);
        a.add("Sangharsj");
        a.add('L');
        a.add(null);
        System.out.println(a);
        a.add(2,"Baju hath");
        System.out.println(a);
        Object x = a.set(4,"Like really");
        System.out.println(a);
        System.out.println("Mujhe hata diya:"+x);
        a.add("Nice demo for ArrayList");
        System.out.println(a);
    }
}
