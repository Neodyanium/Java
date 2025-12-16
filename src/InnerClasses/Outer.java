package InnerClasses;

class Outer {
    int x=10;
    static int y=20;
    class Inner{
        int x=100;
        public void m1(){
            int x = 1000;
            System.out.println("Inner class Method");
            //Accessing Values
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Outer.this.x);
            System.out.println(y);

        }
    }
    public static void main(String[] args){
        new Outer().new Inner().m1();

        //Nesting of Inner Class
        new A().new B().new C().new D().m1();
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        A.B.C.D d = c.new D();
        d.m1();

    }
}

class A{
    class B{
        class C{
            class D{
                public void m1(){
                    System.out.println("InnerMost Class");
                }
            }
        }
    }
}
