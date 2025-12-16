package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static DataStructure.Arrays.ConvertGrid.print;

public class SpiralArray {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        print(arr);
        System.out.println(Arrays.toString(spiralMatrix(arr)));

    }

    /*
    5 3
13 32 8
37 14 26
29 16 45
32 23 29
38 24 17

     */
    public static int[] spiralMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>(m * n);
        int top = 0, left = 0, bottom = n - 1, right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[left][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            //when will you not move from right to left when there is no bottom available to go down
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //When will you not go from bottom to up when you can't move from right to left
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
