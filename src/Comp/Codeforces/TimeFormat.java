package Comp.Codeforces;

import java.util.Scanner;

public class TimeFormat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        in.nextLine();
        while(loop != 0){
            String rawTime = in.nextLine();
            int time = Integer.parseInt(rawTime.split(":")[0]);
            if(time == 0){
                System.out.println(12 + ":" + rawTime.split(":")[1]+ " AM");
            }
            else if(time / 12 == 0){
                System.out.println(rawTime.split(":")[0] + ":" + rawTime.split(":")[1]+ " AM");
            }else if(time % 12 == 0){
                System.out.println(12 + ":" + rawTime.split(":")[1]+ " PM");
            }else{
                if(time % 12 < 10){
                    System.out.println("0"+time%12 + ":" + rawTime.split(":")[1]+ " PM");
                }else
                    System.out.println(time%12 + ":" + rawTime.split(":")[1]+ " PM");
            }
            loop--;
        }
    }
}

/*
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        while(loop != 0){

            loop--;
        }
    }
}
 */