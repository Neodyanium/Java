package FilesIO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterIO {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("abc.txt");
        PrintWriter out = new PrintWriter(fw);
        out.write(100);
        out.println(100);
        out.println("Harsh");
        out.println(true);
        out.println(3.142);
        out.println(new char[]{'a','c'});
        out.flush();
        out.close();
    }
}
