package FilesIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderIO {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("xyz.txt");
        int c = fr.read();
        while(c != -1){
            System.out.print((char)c);
            c= fr.read();
        }
        fr.close();
        System.out.println("------------------------");
        File f = new File("xyz.txt");
        char[] ch = new char[(int)f.length()];
        FileReader fr2 = new FileReader(f);
        fr2.read(ch);
        for(char character:ch){
            System.out.print(character);
        }
        fr2.close();
    }
}
