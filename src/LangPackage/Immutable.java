package LangPackage;

final public class Immutable {
    private int i;
    Immutable(int i){
        this.i=i;
    }
    public Immutable modify(int n){
        if(i==n) return this;
        return new Immutable(n);
    }
    public static void main(String[] args){
        Immutable i = new Immutable(5);
        Immutable i2 = i.modify(5);
        System.out.println(i2);

    }
}
