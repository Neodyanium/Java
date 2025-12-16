package LangPackage;

public class hashCodeMethod {

    public static void main(String[] args){
        Num n = new Num(23);
        Num n2 = new Num(10);
        System.out.println(n);
        System.out.println(n2);
        Num2 n3 = new Num2(1);
        Num2 n4 = new Num2(5);
        System.out.println(n3);
        System.out.println(n4);
    }
}
class Num{
    int i;
    Num(int n){
        this.i=n;
    }
    public int hashCode(){
        return i;
    }
}
class Num2 extends Num{

    Num2(int i){
        super(i);
    }

    public String toString(){
        return i+"";
    }
}