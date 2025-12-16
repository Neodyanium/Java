package DataStructure.DP.Stocks;

/**
 * You can buy the stock at any time and can sell the stock any time the following days, you can buy it as many times between the days provided
 * eg:[7,1,5,3,6,4]
 * you can buy it on day 2 and sell of day 3, buy on day 4 and sell on day 5. Profit would be 3+3 = 6. That is the maximum you could make.
 *
 *
 */
public class BestTime2 {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int ans = maxProfit(arr);
        System.out.println(ans);
    }

    /**
     * You could at any point buy or sell the stocks. At anypoint you should know if you are able to buy the stock or not and then you can continue
     * if you have bought to sell and if you have not bought to buy. The task is to maximise the profit so, we will try all the combinations.
     * We are using to parameters: index and buy.
     * Bought: If the buy is 1 you can buy the stocks but, you have two options either to buy and go to next day
     * or not to buy today and continue to next day whichever will give max profit we will choose that. When buying you incur the price so
     * -prices[index] should be added while buying, and prices[index] should be added while selling as we will be gaining it .
     *
     * Sold: If the buy is 0 it means you can sell the stocks, but here too you have the option whether to sell the stock today or sell it another
     * day, so we will try both the ways and choose whichever gives maximum profit, when you are selling you gain prices[index] and you need to set
     * buy to 1, as you have sold you are able to buy again. If you choose not to sell only the index will grow.
     */
    public static int maxProfit(int index,int buy,int[] prices){
        int profit = 0;
        if(index == prices.length){
            return 0;
        }
        if(buy == 1){
            profit = Math.max(-prices[index] + maxProfit(index+1,0,prices),
                    0 + maxProfit(index+1,buy,prices));

        }else{
            profit = Math.max( prices[index] + maxProfit(index+1,1,prices),
                    0 + maxProfit(index+1,buy,prices));
        }
        return profit;
    }

    /**
     * Memoization, the states are from index 0 to n-1 and buy is either 0 or 1 so 2 values. dp array would be n x 2
     */
    public static int maxProfit(int index,int buy,int[] prices,int[][] dp){
        int profit = 0;
        if(index == prices.length){
            return 0;
        }
        if(dp[index][buy] != 0){
            return dp[index][buy];
        }
        if(buy == 1){
            profit = Math.max(-prices[index] + maxProfit(index+1,0,prices,dp),
                    0 + maxProfit(index+1,buy,prices,dp));

        }else{
            profit = Math.max( prices[index] + maxProfit(index+1,1,prices,dp),
                    0 + maxProfit(index+1,buy,prices,dp));
        }

        return dp[index][buy] = profit;
    }

    public static int maxProfitTab(int[] prices){
        int[][] dp = new int[prices.length+1][2];
        for(int index = prices.length-1; index >= 0; index--){
            for(int buy=0; buy <= 1; buy++){
                int profit = 0;

                if(buy == 1){
                    profit = Math.max(-prices[index] + dp[index+1][0],dp[index+1][1]);
                }else{
                    profit = Math.max(prices[index] + dp[index+1][1],dp[index+1][0]);
                }

                dp[index][buy] = profit;

            }
        }
        return dp[0][1];
    }

    public static int maxProfitSpace(int[] prices){
        int[] ahead = new int[2];
        for(int index = prices.length-1; index >= 0; index--){
            int[] current = new int[2];
            for(int buy=0; buy <= 1; buy++){

                int profit = 0;

                if(buy == 1){
                    profit = Math.max(-prices[index] + ahead[0],ahead[1]);
                }else{
                    profit = Math.max(prices[index] + ahead[1],ahead[0]);
                }

                current[buy] = profit;
            }
            ahead = current;
        }
        return ahead[1];
    }

    /**
     * Most Optimised solution, we are using 4 variables instead of 2 size 2 arrays, that stores a pprevious/ahead and current values
     * Here instead of if else we are computing the values directly as, when the if is executed the next one will be else (recursion)
     * if we look at the above space optimization algo the loops exactly executes the 2 time for value of buy as 0 and 1. And are assigned
     * to the dp[n][0] and dp[n][1]. we can eliminate the inner for loop and simply get those 2 values, and keep calculating and reassigning them
     */
    public static int maxProfit(int[] prices) {
        int aheadBuy = 0, aheadNotBuy = 0 , currentBuy = 0, currentNotBuy= 0;
        for(int index = prices.length-1; index >= 0; index--){

            currentBuy = Math.max(-prices[index] + aheadNotBuy,aheadBuy);

            currentNotBuy = Math.max(prices[index] + aheadBuy,aheadNotBuy);

            aheadBuy = currentBuy;

            aheadNotBuy = currentNotBuy;

        }
        return aheadBuy;
    }
}
