package Comp.AtCoder;

import java.util.HashMap;
import java.util.Scanner;

public class Paint{
    public static void main(String[] args) {
        int[][] wall;
        Scanner in = new Scanner(System.in);
        wall = new int[in.nextInt()][in.nextInt()];
        int repeatOps = in.nextInt();
        for(int i=0;i<repeatOps;i++){
            if(in.nextInt() == 1){
                int row = in.nextInt();
                int colour = in.nextInt();
                for(int c=0;c<wall[0].length;c++){
                    wall[row-1][c] = colour;
                }
            }else{
                int col = in.nextInt();
                int colour = in.nextInt();
                for(int r=0;r< wall.length;r++){
                    wall[r][col-1] = colour;
                }
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< wall.length;i++){
            for(int j=0; j < wall[0].length ;j++ ){
                map.put(wall[i][j],map.getOrDefault(wall[i][j],0)+1);
            }
        }
        System.out.println(map.size());
        for(HashMap.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() +" "+ entry.getValue());
        }
    }
}
