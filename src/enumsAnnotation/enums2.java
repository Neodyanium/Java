package enumsAnnotation;
enum Result{
    PASS,FAIL;

    private int marks;

    Result(){
        System.out.println("Le Beta bana diya Object");
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
public class enums2 {
    public static void main(String[] args) {
        //Running an empty program won;t do shit,
        Result result = Result.PASS;
        //We can also set and get like normal classes
        result.setMarks(69);
        int mark = result.getMarks();
        System.out.println(mark);
        //We can also fetch the marks like this
        System.out.println(Result.PASS.getMarks());
        //Let's try fetching from the other constant
        System.out.println(Result.FAIL.getMarks());

    }
}
