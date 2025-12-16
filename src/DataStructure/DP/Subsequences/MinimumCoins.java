package DataStructure.DP.Subsequences;

import static DataStructure.Arrays.ConvertGrid.print;

public class MinimumCoins {
    /**
     * You are given an array which represents the denomination of coins you have, you can use any coin any number of times, the task is to get to
     * a value with minimum number of coins
     * Eg: {1,2,6,9} , target= 12;
     * Greedily => the coins taken will be {9,2,1} i.e 3 coins
     * Answer => {6,6} i.e 2 coins
     */
    public static void main(String[] args) {
        int[] arr = {9,6,2,1};
        int target = 12;
        int coins = minCoins(arr.length-1,target,arr);
        int coin = minCoinsTab(arr,target);
        System.out.println(coin);
    }

    /**
     * IMP Tip: When you have a problem where it's stated you can use the value any number of times, go with the similar pick and not-Pick
     * algorithm, when it's time to pick do not reduce the index so, it will keep picking the same number over and over until it can't.
     * TC: here the time complexity is more than 2^n it is because we are staying at one index for some time. Similarly, the space complexity
     * is more than of n (recursion stack space)
     */

    public static int minCoins(int index,int target,int[] denom){
        if(index == 0){
            if(target % denom[0] == 0)
                return target / denom[index];
            return (int)1e9;
        }

        int notTake = 0 + minCoins(index-1,target,denom);

        int take = Integer.MAX_VALUE;
        if(denom[index] <= target){
            take = 1 + minCoins(index,target-denom[index],denom);
        }

        return Math.min(notTake,take);

    }

    /**
     * Remember the handeling of base case is crucial here you wrote the proper code but didn't handel the else condition of Int Max
     *         int[][] dp = new int[denom.length][target+1];
     *         for(int i = 0; i <= target;i++){
     *             if(i % denom[0] == 0)
     *                 dp[0][i] = i/denom[0] ;
     */

    public static int minCoinsTab(int[] denom,int target){
        int[][] dp = new int[denom.length][target+1];
        for(int i = 0; i <= target;i++){
            if(i % denom[0] == 0)
                dp[0][i] = i/denom[0] ;
            else
                dp[0][i] = (int) 1e9;
        }

        for(int index=1;index<denom.length;index++){
            for(int c=0;c <= target; c++){
                int notTake = dp[index - 1][c];

                int take = Integer.MAX_VALUE;
                if(denom[index] <= c){
                    take = 1 + dp[index][c-denom[index]];
                }

                dp[index][c] = Math.min(take, notTake);
            }
        }
//        print(dp);
        return dp[denom.length-1][target];
    }
}
