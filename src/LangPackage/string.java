package LangPackage;

import java.util.Locale;

public class string {
    public static void main(String[] args){
        String s1 = "hello";
        String s2 = s1.toLowerCase();
        System.out.println(s1==s2);
        String s3 = s1.toUpperCase();
        String s4 = s3.toLowerCase();
        System.out.println(s4==s1);
    }
}
