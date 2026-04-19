package enumsAnnotation;

import java.lang.annotation.*;
import java.util.ArrayList;

/**
 * This is how we create a simple interface, right now the annotation is not annotating we can apply it anywhere
 * everywhere, the following is a simple syntax for it
 *
  @interface CricketPlayer{

  }
  @CricketPlayer
  public class annotations {
      @CricketPlayer
      public static void main(String[] args) {

      }
  }

   Meta annotations are annotations used to create annotations,
 @Target() is a meta annotation which specifies where this annotation is applicable, it expects an enum of ElementType.
 Type enum is for class and interfaces, we can use our annotation to that level
 @Retention() is retention policy, till when you want the annotations power, it expects RetentionPolicy enum (runtime, compile time)

 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.TYPE)
 @interface CricketPlayer{

 }
 @CricketPlayer
 class ViratKohli{

    private int innings;
    public int getInnings() {
         return innings;
    }
     public void setInnings(int innings) {
        this.innings = innings;
    }
 }
 Sometimes we need to pass values to the annotation, this are called one valued, 2 valued or multi valued
 annotations, we provide the attribute in the annotation

 syntax:
 datatype var_name();
 or
 datatype var_name() default value;
 We need to provide this else we can't use the annotation, this doesn't apply if they have default values
 */
//
//
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR})
@interface CricketPlayer{
    String country();
    int age() default 28;

}
@CricketPlayer(country = "India", age = 35)
class ViratKohli{

    private int innings;
    public int getInnings() {
        return innings;
    }
    public void setInnings(int innings) {
        this.innings = innings;
    }
}
public class annotations {
    public static void main(String[] args) {
        ViratKohli vk = new ViratKohli();
        vk.setInnings(240);

        //How to fetch the annotation info
        //We first create a class file from a Virat Kohli Object
        Class<? extends ViratKohli> vkClass = vk.getClass();
        //Annotation is a parent of all annotations
        Annotation an = vkClass.getAnnotation(CricketPlayer.class);
        //We assign the proper child class, we can in above line could have directly access as the CricketPlayer
        CricketPlayer ann = (CricketPlayer) an;
        int ag = ann.age();
        String count = ann.country();
        System.out.println("Annotation info "+ag +" "+count);

    }

}


