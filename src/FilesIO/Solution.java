package FilesIO;

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException{
        Solution.problem1();
        Solution.problem2();
    }

    private static void problem2()throws IOException {
        PrintWriter pw = new PrintWriter("Unique.txt");
        BufferedReader br = new BufferedReader(new FileReader("duplicates.txt"));
        String line = br.readLine();
        while(line != null){
            boolean available=false;
            BufferedReader br2 = new BufferedReader(new FileReader("Unique.txt"));
            String tg = br2.readLine();
            while(tg != null){
                if(line.equals(tg)){
                    available=true;
                    break;
                }
                tg = br2.readLine();
            }
            if(!available){
                pw.println(line);
            }
            pw.flush();
            line= br.readLine();
        }

        br.close();
        pw.close();
    }

    public static void problem1() throws IOException{
        PrintWriter pw = new PrintWriter("output.txt");
        BufferedReader bf = new BufferedReader(new FileReader("src\\FilesIO\\input.txt"));
        String line = bf.readLine();
        while(line != null){
            boolean found=false;
            BufferedReader bf2 = new BufferedReader(new FileReader("src\\FilesIO\\delete.txt"));
            String target = bf2.readLine();
            while(target != null){
                if(target.equals(line)){
                    found=true;
                    break;
                }
                target = bf2.readLine();
            }
            if(!found){
                pw.println(line);
            }
            line = bf.readLine();
        }
        pw.flush();
        bf.close();
        pw.close();
    }
}
