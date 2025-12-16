import java.util.Scanner;

public class UrlTable {

    public static void main(String args[]) {

        String f = new Scanner(System.in).next();
        String s = "http://10.81.36.52:30010/api/execute?sql=select%20*%20from%20" + f + "%20order%20by%20ts%20DESC";
        System.out.println(s);
    }
}
