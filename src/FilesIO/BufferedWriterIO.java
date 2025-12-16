package FilesIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterIO {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("lemon.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(101);
        bw.newLine();
        char[] ch = {'l','m','a','o'};
        bw.write(ch);
        bw.newLine();
        bw.write("dead");
        bw.flush();
        bw.close();
    }
}
