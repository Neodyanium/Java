package DataStructure.DP.Grids2D;

public class AllPathsWithObstacles {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        int[][] dp = new int[grid.length][grid[0].length];
        int paths = findPathsTabu(grid, grid.length, grid[0].length, dp);
        int temp = mazeObstacles(grid.length,grid[0].length,grid);
        System.out.println(temp);
    }

    public static int findPaths(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && grid[i][j] == -1)  // if i or j is negative here, then we will get exception
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;


        int ups = findPaths(grid, i - 1, j);

        int lefts = findPaths(grid, i, j - 1);

        return ups + lefts;
    }

    public static int findPathsMemo(int[][] grid, int i, int j, int[][] dp) {
        if (i >= 0 && j >= 0 && grid[i][j] == -1)  // if i or j is negative here, then we will get exception
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (grid[i][j] != 0)
            return dp[i][j];


        int ups = findPathsMemo(grid, i - 1, j, dp);

        int lefts = findPathsMemo(grid, i, j - 1, dp);

        return dp[i][j] = ups + lefts;
    }

    public static int findPathsTabu(int[][] grid, int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else if (grid[i][j] == -1) //just one extra condition
                        dp[i][j] = 0;
                    else {
                        int ups = 0;
                        if (i > 0)
                            ups = dp[i - 1][j];
                        int lefts = 0;
                        if (j > 0)
                            lefts = dp[i][j - 1];
                        dp[i][j] = ups + lefts;
                    }
                }
            }
        return dp[m-1][n-1];
    }

    static int mazeObstacles(int n, int m, int[][] mat) {
        int[] dp = new int[m];
        for(int i=0;i<n;i++){
            int[] current = new int[m];
            for(int j=0;j<m;j++) {
                if (mat[i][j] == -1)
                    current[j] = 1;
                else if (i == 0 && j == 0 )
                    current[j] = 0;
                else {
                    int ups = 0, lefts = 0;
                    if (i > 0)
                        ups = dp[j];
                    if (j > 0)
                        lefts = current[j - 1];
                    current[j] = ups + lefts;
                }
            }
            dp = current;
        }
        return dp[m-1];
    }

}
