package Patterns;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) throws Exception {
        Scanner stdIN = new Scanner(System.in);
        String target = stdIN.nextLine();
        java.util.regex.Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z])+");
        Matcher m = p.matcher(target);
        if(m.find() && m.group().equals(target)){
            System.out.println("Aap toh Valid nikle");
        }else{
            System.out.println("Aap Valid nahi hai😭");
        }
    }
}
