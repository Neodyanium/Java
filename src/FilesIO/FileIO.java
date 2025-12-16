package FilesIO;

import java.io.File;
import java.io.IOException;

public class FileIO{
    public static void main(String[] args)throws IOException {
        File f = new File("xyz.txt");
        f.createNewFile();
        File f2 = new File("directory");
        f2.mkdir();
        File localDiscD = new File("D:");
        String[] list = localDiscD.list();
        int count=0,fileCount=0,directoryCount=0;
        for(String l:list){
            System.out.println(l);
            count++;
            File temp = new File(l);
            if(temp.isFile()){
                fileCount++;
            }
            else{
                directoryCount++;
            }
        }
        System.out.println("Total:"+count+" Total Files:"+fileCount+" Total Directories:"+directoryCount);
    }
}
