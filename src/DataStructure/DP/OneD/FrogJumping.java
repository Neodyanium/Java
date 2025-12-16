package DataStructure.DP.OneD;

/**
 * The frog can take either one step or a two-step and, it adds to the energy equal to difference between current level and jumped level, what will
 * be the minimum possible energy consumed when the frog reaches at the end.
 */
public class FrogJumping {
    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50}; //
        int minEnergy = minJumps(heights);
        System.out.println("The minimum energy required:" + minEnergy);
    }

    public static int minJumps(int[] heights) {
        int[] dp = new int[heights.length + 1];
        return minJumpSpaceOptimum(heights);
//        return minJumpTabulation(heights,dp);
//        return minJumps(heights, heights.length - 1, dp);
    }

    //We start at back of array and see which step can be taken and when reached the base conditions it actually decides which
    public static int minJumps(int[] heights, int index, int[] solved) {
        //If at the 0 index we can't go further back.
        if (index == 0) {
            return 0;
        }
        //If the subproblem has occurred before and stored you can directly return value.
        if (solved[index] != 0) {
            return solved[index];
        }
        //The recursive call with 1 step reduced and sum calculated similar is done for 2 steps and the minimum of the 2 is returned
        int left = minJumps(heights, index - 1, solved) + Math.abs(heights[index] - heights[index - 1]);
        int right;
        if (index > 1)
            right = minJumps(heights, index - 2, solved) + Math.abs(heights[index] - heights[index - 2]);
        else
            right = Integer.MAX_VALUE;

        return solved[index] = Math.min(left, right);
    }


    public static int minJumpTabulation(int[] heights, int[] dp) {
        dp[0] = 0;
        for(int i=1;i<heights.length;i++){
            int first = dp[i-1] + Math.abs(heights[i-1] - heights[i]);
            int second = Integer.MAX_VALUE;
            if(i > 1){
                second = dp[i-2] + Math.abs(heights[i-2]- heights[i]);
            }
            dp[i] = Math.min(first,second);
        }
        return dp[heights.length-1];
    }

    public static int minJumpSpaceOptimum(int[] heights){
        int prev = 0, prev2 = 0;
        for(int i=1;i<heights.length;i++){
            int first = prev + Math.abs(heights[i-1] - heights[i]);
            int second = Integer.MAX_VALUE;
            if(i > 1){
                second = prev2 + Math.abs(heights[i-2] - heights[i]);
            }
            int current = Math.min(first,second);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
