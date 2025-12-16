package DataStructure.DP.Subsequences;

import static DataStructure.Arrays.ConvertGrid.print;

/**
 * My dude wants to rob from houses and you are assisting him(Yes, you're) he has a bag of L(weight) we have a list of weights and the respective
 * list of prices of the items, you have to maximise the Loot he can make within the size of bag.
 */
public class KnapSack {

    public static void main(String[] args) {
        int[] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        int max = 5;
        int maxLoot = f(max,weight.length-1,weight,value);
        int[][] dp = new int[weight.length][max+1];
        int maxLoot2 = fspaceOptimal(weight,value,max);
        System.out.println(maxLoot2);
    }

    public static int f(int wt,int index,int[] weight,int[] value){
        if(index == 0){
            if(weight[index] <= wt)
                return value[index];
            return Integer.MIN_VALUE;
        }

        int notTake = f(wt,index-1,weight,value);

        int take = Integer.MIN_VALUE;

        if(weight[index] <= wt){
            take = value[index] + f(wt-weight[index],index-1,weight,value);
        }

        return Math.max(take,notTake);
    }

    public static int f(int max,int index,int[] weight,int[] value,int[][] dp){
        if(index == 0){
            if(weight[index] <= max){
                return value[index];
            }
            return (int) -1e9;
        }

        if(dp[index][max] != 0){
            return dp[index][max];
        }

        int notTake = 0 + f(max,index-1,weight,value,dp);

        int take = Integer.MIN_VALUE;

        if(weight[index] <= max){
            take = value[index] + f(max-weight[index],index-1,weight,value,dp);
        }

        return dp[index][max] = Math.max(take,notTake);
    }

    public static int fTab(int[] weight,int[] value,int maxW){
        int[][] dp = new int[weight.length][maxW+1];
        //base case, when index=0, so at any point at index=0 any weight which is less than maxWeight can be picked
        for(int w=weight[0]; w <= maxW ; w++){
            dp[0][w] = value[0];
        }
        for(int index=1;index<weight.length;index++){
            for(int w=0;w <= maxW;w++){
                int notTake = 0 + dp[index-1][w];

                int take = Integer.MIN_VALUE;

                if(weight[index] <= w){
                    take = value[index] + dp[index-1][w-weight[index]];
                }
                dp[index][w] = Math.max(take,notTake);
            }
        }
        print(dp);
        return dp[weight.length-1][maxW];

    }

    public static int fspaceOp(int[] weight,int[] value,int maxW){
        int[] previous = new int[maxW+1];
        int[] current = new int[maxW+1];
        for(int i=weight[0]; i <= maxW;i++)
            previous[i] = value[0];
        for(int index = 1;index < weight.length;index++){
            for(int w=0; w <= maxW; w++){

                int notTake = 0 +  previous[w];

                int take = Integer.MIN_VALUE;

                if(weight[index] <= w){
                    take = value[index] + previous[w-weight[index]];
                }

                current[w] = Math.max(take,notTake);
            }
            previous = current;
        }
        return previous[maxW];
    }

    /**
     * Single array Space Optimization we are using the same array to store the previous result, and using the same to populate current values
     * this works because we are filling the array from right to left and the any current value at any point depends on the elements of the inidex
     * lesser than the currents.
     *
     * nottake = prev[w];
     *
     * take = prev[w-arr[index]] + val[index];
     *
     * It is evident that we require the element at the same index of previous row and some element whose index is likely less than the current index
     * So we can fill values from right to left in the same previous row, as we have both the current value and previous, we overwrite it over the same
     * array right to left. Thus 2d dp reduced to 1d dp.
     *
     */

    public static int fspaceOptimal(int[] weight,int[] value,int maxW){
        int[] previous = new int[maxW+1];
        for(int i=weight[0]; i <= maxW;i++)
            previous[i] = value[0];
        for(int index = 1;index < weight.length;index++){
            for(int w=maxW; w >= 0 ; w--){

                int notTake = 0 +  previous[w];

                int take = Integer.MIN_VALUE;

                if(weight[index] <= w){
                    take = value[index] + previous[w-weight[index]];
                }

                previous[w] = Math.max(take,notTake);
            }
        }
        return previous[maxW];
    }

}

