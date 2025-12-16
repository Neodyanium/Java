package FilesIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderIO {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("abc.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null){
            System.out.println(line);
            line = br.readLine();
        }
    }
}
