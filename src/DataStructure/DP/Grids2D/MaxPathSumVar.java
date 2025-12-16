package DataStructure.DP.Grids2D;

/**
 * The catch here was determining how you would the use recurrence relationship, with variable start points. You can use a simple for loop
 * outside the function body traverse through all the possible inputs and compare the values return by them.
 */
public class MaxPathSumVar {
    /*
    -9999 -9888 -9777 -9666 -9555
    1 10 2 4 5
    -9999 -9888 -9777 -9666 -9555
    0 0 0 0 0
    -99 -98 -97 -96 -95

    int[][] grid = {
                    {1, 2, 10, 4},
                    {100, 3, 2, 1},
                    {1, 1, 20, 2},
                    {1, 2, 2, 1}
            };
     */
    public static void main(String[] args) {
        int[][] grid = {
                {-9999, -9888, -9777, -9666, -9555},
                {1, 10, 2, 4, 5},
                {-9999, -9888, -9777, -9666, -9555},
                {0, 0, 0, 0, 0},
                {-99, -98, -97, -96, -95}
        };
        //Recursion
        int n = grid.length;
        int max = 0;
        for (int j = 0; j < grid[0].length; j++) {
            max = Math.max(max, maxSum(grid, n - 1, j, n));
        }
        //Memoized
        int max2 = 0;
        int[][] dp = new int[n][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            max2 = Math.max(max2, maxSumMemoization(grid, n - 1, j, dp));
        }
//        System.out.println(max2);
        //Tabulation
        dp = new int[n][grid[0].length];
        int max3 = maxSumTabulation(grid, dp);
//        System.out.println(max3);
//        print(dp);

        int max4 = maxSumOptimal(grid);
        System.out.println(max4);

    }


    /**
     * Write Out of bounds cases before the base cases
     * Wrote a simple recurrence starting from the last row's jth column, we repeat the operation for all the columns and compare the max returned
     */

    public static int maxSum(int[][] grid, int i, int j, int n) {
        //Out of Bounds Case
        if (j < 0 || j >= grid[0].length) {
            return -1000;
        }
        //Base Case
        if (i == 0) {
            return grid[0][j];
        }

        int up = grid[i][j] + maxSum(grid, i - 1, j, n - 1);

        int ld = grid[i][j] + maxSum(grid, i - 1, j - 1, n - 1);

        int rd = grid[i][j] + maxSum(grid, i - 1, j + 1, n - 1);

        return Math.max(ld, Math.max(up, rd));
    }


    public static int maxSumMemoization(int[][] grid, int i, int j, int[][] dp) {
        if (j < 0 || j >= grid[0].length) {
            return (int) -1e5;
        }

        if (i == 0) {
            return grid[0][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = grid[i][j] + maxSumMemoization(grid, i - 1, j, dp);

        int ld = grid[i][j] + maxSumMemoization(grid, i - 1, j - 1, dp);

        int rd = grid[i][j] + maxSumMemoization(grid, i - 1, j + 1, dp);

        return dp[i][j] = Math.max(up, Math.max(ld, rd));
    }

    public static int maxSumTabulation(int[][] grid, int[][] dp) {
        int n = grid.length, m = grid[0].length;
        for (int j = 0; j < m; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = grid[i][j] + dp[i - 1][j];

                int ld = grid[i][j];
                if (j > 0)
                    ld += dp[i - 1][j - 1];

                int rd = grid[i][j];
                if (j + 1 < m)
                    rd += dp[i - 1][j + 1];

                dp[i][j] = Math.max(up, Math.max(ld, rd));
            }
        }
        int max = (int) -1e8;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }
        return max;
    }

    public static int maxSumOptimal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] previous = new int[m];
        for (int j = 0; j < m; j++) {
            previous[j] = grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] current = new int[m];
            for (int j = 0; j < m; j++) {

                int up = grid[i][j] + previous[j];

                /**
                 * This is a mistake, int ld = grid[i][j];
                 * if you don't want to consider a path you take a large number of negative so, it is eliminated
                 */
                int ld = (int) -1e8;

                if (j > 0)
                    ld = grid[i][j] + previous[j - 1];

                int rd = (int) -1e8;
                if (j + 1 < m)
                    rd = grid[i][j] + previous[j + 1];

                current[j] = Math.max(up, Math.max(ld, rd));
            }
            previous = current;
        }
        int max = (int) -1e8;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, previous[j]);
        }
        return max;
    }
}
