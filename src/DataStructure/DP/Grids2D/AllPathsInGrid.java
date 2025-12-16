package DataStructure.DP.Grids2D;

import java.util.Arrays;

/**
 * For a m row and n column grid. You are at the (0,0)  index and, you have to reach the m-1 and n-1 block, you can travel only down and right
 * How many possible ways can you reach the end of grid.
 */
public class AllPathsInGrid {


    /**
     * It is solved using multiple ways, The DP array produced in the Memoization is different. The DP array would be identical in Optimization &  Tabulation
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[2][2];
//        int paths = allPaths(grid,grid.length-1,grid[0].length-1);
        int[][] dp = new int[grid.length][grid[0].length];
//        int paths2 = allPathsMemoi(grid,grid.length-1,grid[0].length-1,dp);
//        int paths3 = allPathsTabu(grid, dp);
        int paths4 = allPathsOptimal(grid);
        int row = 3, column=3;
        int path5 = allPathsOptimal(row,column);
        System.out.println(path5);
//        print(dp);
    }

    /**
     * You can make 2 moves from any part of the grid, if you calculate it you will find it is around 2^(m*n)
     * about the space complexity it's recursion stack space, it would be about (m-1) + (n-1) (like an edge of the grid)
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */

    public static int allPaths(int[][] grid, int i, int j) {
        //If we have reached the end
        if (i == 0 && j == 0) {
            return 1;
        }
        /**
         * It's another base case, it's like we are moving up until we get out of boundary, and since we can't go any further let's change
         * path and try again
         */
        if (i < 0 || j < 0) {
            return 0;
        }

        int ups = allPaths(grid, i - 1, j);

        int lefts = allPaths(grid, i, j - 1);

        return ups + lefts;
    }

    /**
     * Simple Memoization as there were repeating sub-problems, we just needed an array of same dimensions as the grid
     * [0, 1, 1]
     * [1, 2, 3]
     * [1, 3, 6]
     * <p>
     * This is how the memoized dp grid looks like, it seems to make up your current element you will need i-1 and j-1 elements only.
     * <p>
     * TC: (M x N) with these at the max you will go m x n, you will need to calculate stuff for new problems if the subproblem already solved
     * you won't need to trace the entire tree again.
     */

    private static int allPathsMemoi(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ups = allPathsMemoi(grid, i - 1, j, dp);

        int lefts = allPathsMemoi(grid, i, j - 1, dp);

        return dp[i][j] = ups + lefts;
    }

    /**
     * 1.Initialise the DP array with the base conditions value.
     * 2. Write loops for all possible states, here it would be 2 for loops
     * 3. Copy the recurrence relation from the recursion, we can write it, with recursive call swapped with dp array.
     * (There are cases where you can't manage the parameters if it became negative, so what you can do is use if statements to manage those cases)
     * TC: nxm (2 nested for loops) , SC: (n x m)
     */
    private static int allPathsTabu(int[][] grid, int[][] dp) {
        dp[0][0] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) ;
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
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * Personal: I can see that we will need the element above me and element before, so a column sized array and a previous element
     * (I pulled it successfully, it has at least reduced some dp array space, it is because I could see the relationship)
     *
     * Pro: If there are terms like i-1/j-2 etc, then there is a chance of space optimization, since i-1 it requires the last row and j-1 then it
     * requires the last column.
     */
    public static int allPathsOptimal(int[][] grid) {
        int[] above = new int[grid[0].length];
        Arrays.fill(above, 1);
        for (int i = 1; i < grid.length; i++) {
            int prev = 0;
            int[] current = new int[grid[0].length];
            for (int j = 0; j < grid[0].length; j++) {
                int curr = prev + above[j];
                current[j] = curr;
                prev = curr;
            }
            above = current;
        }
        return above[grid.length-1];
    }

    /**
     * The only idea I get is to use the same constructing rows j-1 column instead of maintaining other.
     * @param m
     * @param n
     * @return
     */
    public static int allPathsOptimal(int m, int n){
        int[] dp = new int[n];
        for(int i=0;i<m;i++){
            int[] current = new int[n];
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0)
                    current[j] = 1;
                else{
                    int ups=0,lefts=0;
                    if(i > 0)
                        ups = dp[j];
                    if(j > 0)
                        lefts = current[j-1];
                    current[j] =  ups + lefts;
                }
            }
            dp = current;
        }
        return dp[n-1];
    }
}