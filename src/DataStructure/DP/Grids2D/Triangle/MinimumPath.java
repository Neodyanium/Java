package DataStructure.DP.Grids2D.Triangle;

public class MinimumPath {
    public static void main(String[] args) {
        int[][] triangle = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        int[][] dp = new int[triangle.length][];
        for(int i=0;i<triangle.length;i++){
            dp[i] = new int[triangle[i].length];
        }
//        int res = minPathMe(triangle,0,0);
//        int res = minPathMemoization(triangle,0,0,dp);
        int res = minPathOptimal(triangle,triangle.length);
        System.out.println(res);
    }

    /**
     * It seems we are going from top down, but it is still a bottom up approach, since the function call at the very bottom will be executed and
     * the upper functions will evaluate. Since we can go just a row below and diagonally we are doing the same thing. The base condition is such
     * that you will never get out of bounds.
     */

    public static int minPath(int[][] triangle,int i,int j){
        if(i == triangle.length-1){
            return triangle[i][j];
        }

        int down = triangle[i][j] + minPath(triangle,i+1,j);

        int diagonal = triangle[i][j] + minPath(triangle,i+1,j+1);

        return Math.min(down,diagonal);

    }

    public static int minPathMemoization(int[][] triangle,int i,int j,int[][] dp){
        if(i == triangle.length-1){
            return triangle[i][j];
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int down = triangle[i][j] + minPathMemoization(triangle,i+1,j,dp) ;

        int diagonal = triangle[i][j] + minPathMemoization(triangle,i+1,j+1,dp) ;

        return dp[i][j] = Math.min(down,diagonal);
    }

    /**
     * You just need to think what it could be and write it. The base conditions are fixed, as we reach the last index we will return the same and
     * thus the dp array's last row is initialised with the same. Now we need to fill all the remaining rows, it should be similar to the recurrence
     * we will be heading up wanting the minimum from the below rows, so current value + whatever is lower between the two options.
     *
     */
    public static int minPathTabulation(int[][] triangle,int n,int[][] dp){
        for(int i=0;i<n;i++){
            dp[n-1][i] = triangle[n-1][i];
        }
        for(int i = n-2;i >= 0;i--){
            for(int j=0;j<i+1;j++){
                dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    public static int minPathOptimal(int[][] triangle,int n){
        int[] previous = new int[n];
        for(int i=0;i<n;i++){
            previous[i] = triangle[n-1][i];
        }
        for(int i=n-2;i >= 0; i--){
            int[] current = new int[i+1];
            for(int j=0;j<i+1;j++){
                current[j] = triangle[i][j] + Math.min(previous[j],previous[j+1]);
            }
            previous = current;
        }
        return previous[0];
    }
}
