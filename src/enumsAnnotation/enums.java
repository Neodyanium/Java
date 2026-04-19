package enumsAnnotation;
enum Week{
    MON,TUE,WED,THU,FRI,SAT,SUN;
}
public class enums {
    public static void main(String[] args) {
        Week week = Week.MON;
        System.out.println(week);
        //This method returns the index of the constant in the enum
        int index = Week.THU.ordinal();
        System.out.println(index);

        for(Week w : Week.values()){
            System.out.println(w.ordinal() +"->"+w);
        }

        System.out.println(Week.values()[5]);

    }
}
