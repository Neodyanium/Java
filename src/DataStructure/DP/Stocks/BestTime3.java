package DataStructure.DP.Stocks;

/**
 * It's a little extension of the previous problem, we could buy and sell multiple times, but here the limit to buy and sell is 2.
 */
public class BestTime3 {

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        int ans = maxProfitTabulation2(arr);
        System.out.println(ans);
    }

    public static int maxProfit(int index,int buy,int cap,int[] prices){
        if(cap == 0){
            return 0;
        }
        if(prices.length == index){
            return 0;
        }
        int profit = 0;
        if(buy == 1){
            profit =   Math.max(- prices[index] + maxProfit(index+1,0,cap,prices) , 0 + maxProfit(index+1,1,cap,prices));
        }else{
            profit = Math.max(prices[index] + maxProfit(index+1,1,cap-1,prices) , 0 + maxProfit(index+1,0,cap,prices));
        }

        return profit;
    }

    public static int maxProfitMemoization(int index,int buy,int cap,int[] prices,int[][][] dp){
        if(cap == 0){
            return 0;
        }
        if(prices.length == index){
            return 0;
        }
        if(dp[index][buy][cap] != 0){
            return dp[index][buy][cap];
        }
        int profit = 0;
        if(buy == 1){
            profit =   Math.max(- prices[index] + maxProfitMemoization(index+1,0,cap,prices,dp) , 0 + maxProfitMemoization(index+1,1,cap,prices,dp));
        }else{
            profit = Math.max(prices[index] + maxProfitMemoization(index+1,1,cap-1,prices,dp) , 0 + maxProfitMemoization(index+1,0,cap,prices,dp));
        }

        return dp[index][buy][cap] = profit;
    }

    public int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        //The following 2 for loops to initialise base condition can be avoided
        for(int buy = 0; buy<= 1; buy++){
            for(int cap = 0; cap < 3; cap++){
                dp[n][buy][cap] = 0;
            }
        }
        for(int index = 0; index < n; index++){
            for(int buy = 0; buy < 2; buy++){
                dp[index][buy][0] = 0;
            }
        }
        for(int index = n-1; index >=0 ; index --){
            for(int buy = 0; buy < 2; buy++){
                for(int cap = 1; cap < 3; cap++){

                    int profit = 0 ;

                    if(buy == 1){
                        profit = Math.max(-prices[index] + dp[index+1][0][cap], dp[index+1][buy][cap]);
                    }else{
                        profit = Math.max(prices[index] + dp[index+1][1][cap-1],dp[index+1][buy][cap]);
                    }

                    dp[index][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];

    }

    public int maxProfitSpaceOptimization(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] current = new int[2][3];

        for(int index = n-1; index >=0 ; index --){
            for(int buy = 0; buy < 2; buy++){
                for(int cap = 1; cap < 3; cap++){

                    int profit = 0 ;

                    if(buy == 1){
                        profit = Math.max(-prices[index] + ahead[0][cap], ahead[buy][cap]);
                    }else{
                        profit = Math.max(prices[index] + ahead[1][cap-1],ahead[buy][cap]);
                    }

                    current[buy][cap] = profit;
                }
            }
            ahead = current;
        }
        return ahead[1][2];

    }

    /**
     * We can think of the number of repetiotions in other sense, we are limited to only 2 set of transactions that is buy sell and another
     * buy sell. That would be total 4 transactions.
     *
     *  B S B S
     *  0 1 2 3
     *
     *  For even we are able to buy and for odd it's
     */

    public static int profit(int index,int transaction,int[] prices){
        if(index == prices.length || transaction == 4){
            return 0;
        }
        int profit = 0;
        if(transaction % 2 == 0){
            profit = Math.max(-prices[index] + profit(index+1,transaction+1,prices),
                    profit(index+1,transaction,prices));
        }else{
            profit = Math.max(prices[index] + profit(index+1,transaction+1,prices),profit(index+1,transaction,prices));
        }
        return profit;
    }

    public static int profitMemoization(int index,int transaction,int[] prices,int[][] dp){
        if(index == prices.length || transaction == 4){
            return 0;
        }
        if(dp[index][transaction] != 0){
            return dp[index][transaction];
        }
        int profit = 0;
        if(transaction % 2 == 0){
            profit = Math.max(-prices[index] + profitMemoization(index+1,transaction+1,prices,dp),
                    profitMemoization(index+1,transaction,prices,dp));
        }else{
            profit = Math.max(prices[index] + profitMemoization(index+1,transaction+1,prices,dp),profitMemoization(index+1,transaction,prices,dp));
        }
        return dp[index][transaction] = profit;
    }

    public static int maxProfitTabulation2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];
        for(int i=0;i<=4;i++){
            dp[n][i] = 0;
        }
        /**
         *  Mistake found if you are choosing 0 as the base case then it's valid, but you have to start the transaction at 4 and reduce it in the
         *  recursion and if you are increasing the transactions which you have done here then my brother the base condition should have been
         *  dp[index][4] = 0;
         */
        for(int index = 0; index <= n; index++){
            dp[index][4] = 0;
        }
        for(int index = n-1; index >= 0 ; index --){
            for(int transaction=0; transaction < 4; transaction++){
                int profit = 0;
                if(transaction % 2 == 0){
                    profit = Math.max(-prices[index] + dp[index+1][transaction+1],
                            dp[index+1][transaction]);
                }else{
                    profit = Math.max(prices[index] + dp[index+1][transaction+1] ,
                            dp[index+1][transaction]);
                }
                dp[index][transaction] = profit;
            }
        }
        return dp[0][0];
    }


}
