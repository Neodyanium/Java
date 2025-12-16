package Patterns;

import java.util.Arrays;

public class Pattern {

    public static void rightAngleL(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void numbersCube(int n) {
        int loop = n * 2 - 1;
        int up = 0, down = 0, left = 0, right = 0;
        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < loop; j++) {
                up = i;
                left = j;
                down = loop - i-1;
                right = loop - j-1;
                int temp = min(up, down, left, right);
                System.out.print(n-temp+" ");
            }
            System.out.println();
        }
    }

    public static int min(int... arr){
        return Arrays.stream(arr).min().getAsInt();
    }

    public static void rightAngleR(int n){
        for(int i=n;i>0;i--){
            for(int j=1;j<=n;j++)
                if(j>=i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            System.out.println();
        }
    }

    public static void invertedRightAngleL(int n) {
        for(int i=n;i>0;i--){
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        numbersCube(3);
    }
}
