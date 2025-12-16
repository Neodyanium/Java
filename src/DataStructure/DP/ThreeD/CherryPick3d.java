package DataStructure.DP.ThreeD;

public class CherryPick3d {
    /**
     * The guys are starting at 0,0 and 0,m-1 and, they have to collect maximum cherries, the thing is they can only go down and
     */
    public static void main(String[] args) {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int maxSum = maxCherries(grid,0,0,grid[0].length-1);
        int maxSum2 = maxCherries(grid,new int[grid.length][grid[0].length][grid[0].length]);
        System.out.println(maxSum2);
    }

    /**
     * This works OMG why does this work lol.
     */
    private static int maxCherries(int[][] grid, int i, int j1, int j2) {
        int[] dj = {-1, 0, 1};
        if (j1 < 0 || j1 > grid[0].length - 1 || j2 < 0 || j2 > grid[0].length - 1) {
            return (int) -1e8;
        }

        if (i == grid.length - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        int max = 0;
        for (int dj1 : dj) {
            for (int dj2 : dj) {
                if (j1 == j2) {
                    max = Math.max(max, grid[i][j1] + maxCherries(grid, i + 1, j1 + dj1, j2 + dj2));
                } else
                    max = Math.max(max,grid[i][j1] + grid[i][j2] + maxCherries(grid, i + 1, j1 + dj1, j2 + dj2));
            }
        }
        return max;
    }

    /**
     * Wow, that was pretty tough,could be my inconsistency
     * 1D dp optimization = 2 variables.
     * 2D dp optimization = 1d dp array.
     * 3D dp optimization = 2d dp array.
     */
    public static int maxCherries(int[][] grid,int[][][] dp){
        int n = grid.length, m =grid[0].length;
        for(int j1=0;j1 < m;j1++){
            for(int j2=0;j2 < m; j2++){
                if(j1 == j2)
                    dp[n-1][j1][j2] = grid[n-1][j1];
                else
                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i=n-2;i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    int max=0;
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2= -1; dj2 <= 1;dj2 ++){
                            int val = 0;
                            if (j1 == j2) val = grid[i][j2];
                            else val = grid[i][j2] + grid[i][j1];
                            if( j1 + dj1 >= 0  && j2+dj2 >= 0 && j1 + dj1 < m  && j2 +dj2 <m)
                                val += dp[i+1][j1+dj1][j2+dj2];
                            else
                                val =(int) -1e8;
                            max= Math.max(max,val);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m-1];
    }
}
