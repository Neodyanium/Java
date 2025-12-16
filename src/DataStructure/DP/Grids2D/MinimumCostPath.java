package DataStructure.DP.Grids2D;

import java.util.Arrays;

import static DataStructure.Arrays.ConvertGrid.print;

public class MinimumCostPath {
    public static void main(String[] args) {
        int[][] path = {
                {5,9,6},
                {11,5,2}
        };
//        int cost = cheapPathTab(path,path.length,path[0].length);
        int cost2 = cheapPathOptimal(path,path.length,path[0].length);
        System.out.println(cost2);
    }

    private static int cheapPath(int[][] path, int i, int j) {
        if(i == 0 && j ==0)
            return path[i][j];
        /**
         * I was returning Zero here that was an issue, I should have returned a Bigger Number so the path is rejected. IntegerMax can cause
         * overflow issues.
         */
        if(i < 0 || j < 0)
            return 45654461;
        int sumUps = path[i][j] + cheapPath(path,i-1,j);

        int sumLefts =path[i][j] + cheapPath(path,i,j-1);

        return Math.min(sumLefts,sumUps);
    }

    private static int cheapPath(int[][] path, int i, int j,int[][] dp) {
        if(i == 0 && j ==0)
            return path[i][j];

        if(i < 0 || j < 0)
            return 45654461;

        if(dp[i][j] != 0)
            return dp[i][j];

        int sumUps = path[i][j] + cheapPath(path,i-1,j,dp);

        int sumLefts =path[i][j] + cheapPath(path,i,j-1,dp);

        return dp[i][j] = Math.min(sumLefts,sumUps);
    }

    /**
     * Made the same mistake while tabulating here again, since if the array index were out of bound to not consider the path we returned big numbers
     * so in case of tabulation we need to initialise them with large value as well and, it's done.
     */

    private static int cheapPathTab(int[][] path, int n, int m) {
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j ==0)
                    dp[i][j] = path[i][j];
                else {
                    int sumUps = 9787979 ;
                    if(i > 0)
                        sumUps = path[i][j] + dp[i - 1][j];
                    int sumLefts = 9787979 ;
                    if(j > 0)
                        sumLefts = path[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(sumLefts, sumUps);
                }
            }
        }
        print(dp);
        return dp[n-1][m-1];
    }

    public static int cheapPathOptimal(int[][] grid,int n,int m){
        int[] previous = new int[m];
        for(int i=0;i<n;i++){
            int[] current = new int[m];
            for(int j=0;j<m;j++){
                if(i == 0 && j ==0 ){
                    current[j] = grid[i][j];
                }else{
                    int up = 999999;
                    if(i > 0)
                        up = grid[i][j] + previous[j];
                    int left = 999999;
                    if(j > 0)
                        left = grid[i][j] + current[j-1];
                    current[j] = Math.min(up,left);
                }
            }
            System.out.println(Arrays.toString(current));
            previous = current;
        }
        return previous[m-1];
    }


}
