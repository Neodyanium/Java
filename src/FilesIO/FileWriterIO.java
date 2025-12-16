package FilesIO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterIO {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("xyz.txt");
        fw.write(97);
        fw.write("-Smallest Letter\n");
        fw.write('\n');
        char[] ch = {'a','b','c','d'};
        fw.write(ch);
        fw.flush();
        FileWriter fw2 = new FileWriter("xyz.txt",true);
        fw.write(101);
        fw.write("-Second Vowel\n");
        fw.flush();
        fw.close();
    }
}
