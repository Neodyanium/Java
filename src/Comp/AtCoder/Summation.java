package Comp.AtCoder;

import java.util.HashSet;
import java.util.Scanner;

public class Summation {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        long K = scn.nextInt();
        HashSet<Long> set = new HashSet<>();
        for(int i=0;i<size;i++){
            set.add(scn.nextLong());
        }
        long sum = K*(K+1)/2;
        long res = 0;
        for(long l:set){
            double d = (double)sum/l;
            if(d % 1 == 0){
                res+=l;
            }
        }
        System.out.println(sum-res);
    }
}
