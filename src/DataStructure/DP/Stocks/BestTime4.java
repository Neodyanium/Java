package DataStructure.DP.Stocks;

/**
 *  Here you can buy and sell the stocks (1 Transaction) for k number of times, it's simple just little replacements in the 3rd problem
 */
public class BestTime4 {
    public int maxProfit(int k, int[] prices) {

        return f(prices,k*2);

    }

    public static int f(int[] prices,int k){
        int n = prices.length;
        int[] ahead = new int[(k*2)+1];
        int[] current = new int[(k*2)+1];
        for(int index = n-1; index >= 0 ; index--){
            for(int transaction = 0; transaction <= k; transaction++){

                int profit = 0 ;
                if(transaction % 2 == 0){
                    profit = Math.max(-prices[index] + ahead[transaction+1], 0 + ahead[transaction]);
                }else{
                    profit = Math.max(prices[index] + ahead[transaction+1], 0 + ahead[transaction]);
                }
                current[transaction] = profit;
            }
            ahead = current;
        }
        return ahead[0];
    }
}
