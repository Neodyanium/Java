package DataStructure.Arrays;

import java.util.Arrays;

public class ConvertGrid {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}};
        print(arr);
        oneToZeroesO(arr, arr.length, arr[0].length);
        print(arr);

    }

    public static void print(int [][] arr) {
        for (int[] ar : arr) {
            System.out.println(Arrays.toString(ar));
        }
        System.out.println();
    }

    /**
     * As simple as it gets create a rows of size row and columns of size column this arrays will store if any element in the particular row are
     * 0 or 1. We will mark it with -1(because default value is 0). Iterate over the Grid and see if any element is 0 mark the particular row as -1
     * and column as -1. Now reiterate over it, whenever the value of rows[i] or columns[j] became -1 replace with 0;
     * nxm + n x m
     * S: (n+m)
     *
     * @param arr
     * @param row
     * @param col
     */

    private static void oneToZeroes(int[][] arr, int row, int col) {
        int[] rows = new int[row];
        int[] cols = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rows[i] == -1 || cols[j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    /**
     * Optimization here is space optimization we have created separate rows and columns to manage whether the no was becoming zero or not
     * Here we will use 0th row and 0th Column for the same.
     *
     * @param arr
     * @param row
     * @param col so the row[0] = columns
     *            and the col[0] = rows
     */
    public static void oneToZeroesO(int[][] arr, int row, int col) {
        int col0 = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    //so the row[0] = columns
                    // and the col[0] = rows
                    arr[0][j] = -1;
                    if(j != 0)
                        arr[i][0] = -1; //handles col0
                    else
                        col0=-1;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (arr[i][0] == -1 || arr[0][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
        if(arr[0][0] == -1)
            arr[0][0] = 0;
        for (int j = 0; j < col; j++) {
                arr[0][j] = 0;
        }
        if(col0==-1){
            for(int i=0;i<row;i++){
                arr[i][0] = 0;
            }
    }else{
            for(int i=0;i<row;i++){
                if(arr[i][0] == -1)
                    arr[i][0] = 0;
            }
        }
//        for(int i=0;i<row;i++){
//            if(arr[i][0] == -1){
//                arr[i][0] = 0;
//            }
//        }
//        for(int )


}


}