package Java8.LambdaF;

/**
 * The lambda expression has no access modifier, no name and no return type, if you remove all of it from any function only the () with the
 * respective parameter remains after parameter we only need to add -> to write a proper lambda expression
 */
public class MethodToExpression {

    public static void main(String[] args) {
        greet();


    }

    public static void greet(){
        System.out.println("Hello, Nice to meet you");
    }

    /**
     *   Equivalent lambda Expression
     *     () -> {
     *         System.out.println("Hello,Nice to meet You");
     *     }
     *
     *     Single statement so no curly braces further reduction
     *     () -> System.out.println("Hello,Nice to meet You");
     */

    public static void add(int a,int b){
        System.out.println(a+b);
    }

    /**
     * Equivalent Lambda Expression
     *  (int a,int b) ->{
     *      System.out.println(a+b);
     *  }
     *
     *  Single statement so no curly braces further reduction
     *  (int a,int b) -> System.out.println(a+b);
     *
     *  Sometimes compiler will know, type of parameters, so we can avoid adding data types them(Type Inference). Further reduced
     *
     *  (a,b) -> System.out.println(a+b);
     *
     */

    public static int length(String s){
        return s.length();
    }
    /**
     * Equivalent Lambda expression
     *
     * (String s) -> {
     *     return s.length();
     * }
     *
     *  Single statement so no curly braces further reduction
     *  (String s) -> return s.length();
     *
     *  The return statement can be removed so it is further reduced to
     *
     *  (String s) -> s.length();
     *
     *  Here if only one parameter is present then we can also avoid the paramater paranthesis
     *
     *  s -> s.length();  Most reduced form
     *
     *
     *
     *
     */




}
