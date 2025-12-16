package DataStructure.Arrays;

import java.util.Arrays;
import java.util.Collections;

import static DataStructure.Arrays.ConvertGrid.print;

public class RotateGrid {
    /**
     * you have to rotate a grid by 90 degrees
     * [ 1  2  3 ]      [ 7  4  1 ]      matrix[0][0] = matrix[0][2]  matrix[1][0] = matrix[0][1]
     * [ 4  5  6 ]      [ 8  5  2 ]      matrix[0][1] = matrix[1][2]  matrix[1][1] = matrix[1][1]
     * [ 7  8  9 ]      [ 9  6  3 ]      matrix[0][2] = matrix[2][2]  matrix[1][2] = matrix[2][1]
     * n x n grid the rotation can be done using the relation arr[i][j] = arr[j][n-1-i] (n=3)
     * Just create n x n array again and repopulate (N x M time and space complexity)
      */


    public static void transpose(int[][] grid){
        //Approach
        /**
         * imp:This only works for square Matrix
          */
        /*
        for(int i=0;i<grid.length;i++){
            for(int j=i;j<grid[0].length;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }
        */
        /**
         * [*, 2, 3, 4]    [*, 5, 9, 13]     you can observe the diagonals stay the same, lets check the elements
         * [5, *, 7, 8]    [2, *, 10, 14]    (0,1) swap (1,0)    (1,2) swap (2,1)  (2,3) swap (3,2)         i = 0 till n-2 (n=4)
         * [9, 10, *, 12] [3, 7, *, 15]      (0,2) swap (2,0)    (1,3) swap (3,1)                           j = i+1 till n - 1
         * [13, 14,15,*] [4, 8, 12, *]       (0,3) swap (3,0)
         */
        //Optimal
        for(int i=0; i< grid.length - 1;i++){
            for(int j=i+1;j < grid[0].length;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }
    }

    public static void rotate(int[][] grid){
        transpose(grid);
        reverse(grid);
    }

    public static void reverse(int[][] grid){
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length/2;j++){
                int temp = grid[i][grid.length-1-j];
                grid[i][grid.length-1-j] = grid[i][j];
                grid[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr =
                {
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                };
        print(arr);
        rotate(arr);
        print(arr);

    }
}
