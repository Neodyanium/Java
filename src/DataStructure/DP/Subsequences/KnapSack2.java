package DataStructure.DP.Subsequences;

import java.util.Arrays;

import static DataStructure.Arrays.ConvertGrid.print;

/**
 * Same question but now you can steal the same thing any number of times, before it fills the bag
 */
public class KnapSack2 {
    public static void main(String[] args) {
        int[] weight = {2,4,6};
        int[] value = {5,11,13};
        int maxVal = 10;
        int n = weight.length;
        int result = foptimal(weight,value,maxVal);
        System.out.println(result);
    }

    public static int f(int index,int maxVal,int[] weight,int[] value){
        if(index == 0){
            if(weight[0] <= maxVal){
                return (weight[0] / maxVal) * value[0];
            }
            return 0;
        }

        int notTake = f(index-1,maxVal,weight,value) ;

        int take = Integer.MIN_VALUE;

        if(weight[index] <= maxVal){
            take = value[index] + f(index,maxVal-weight[index],weight,value);
        }

        return Math.max(take,notTake);

    }

    public static int f(int index,int maxVal,int[] weight,int[] value,int[][] dp){
        if(index == 0){
            if(weight[0] <= maxVal){
                return (weight[0] / maxVal) * value[0];
            }
            return 0;
        }

        if(dp[index][maxVal] != 0)
            return dp[index][maxVal];

        int notTake = f(index-1,maxVal,weight,value) ;

        int take = Integer.MIN_VALUE;

        if(weight[index] <= maxVal){
            take = value[index] + f(index,maxVal-weight[index],weight,value);
        }

        return dp[index][maxVal] = Math.max(take,notTake);

    }

    /**
     * int[] weight = {2,4,6};
     * int[] value = {5,11,13};
     * int maxVal = 10;
     */

    public static int f(int[] weight,int[] value,int maxVal){
        int[][] dp = new int[weight.length][maxVal+1];
        for(int w=0;w <= maxVal;w++){
            dp[0][w] =  (w/weight[0]) * value[0] ;
        }
        for(int index = 1;index < weight.length ;index++){
            for(int w = 0; w <= maxVal; w++){
                int notTake = dp[index-1][w];

                int take = 0;

                if(weight[index] <= w){
                    take = value[index] + dp[index][w-weight[index]];
                }

                dp[index][w] = Math.max(take,notTake);
            }
        }
        print(dp);
        return dp[weight.length-1][maxVal];
    }

    public static int fOp(int[] weight,int[] value,int maxVal){
        int[] previous = new int[maxVal+1];
        int[] current = new int[maxVal+1];
        for(int w=0;w <= maxVal;w++){
            previous[w] =  (w/weight[0]) * value[0] ;
        }
        for(int index = 1;index < weight.length ;index++){
            for(int w = 0; w <= maxVal; w++){
                int notTake = previous[w];

                int take = 0;

                if(weight[index] <= w){
                    take = value[index] + current[w-weight[index]];
                }

                current[w] = Math.max(take,notTake);
            }
            previous = current;
        }
        return previous[maxVal];
    }

    public static int foptimal(int[] weight,int[] value,int maxVal){
        int[] previous = new int[maxVal+1];
        for(int w=0;w <= maxVal;w++){
            previous[w] =  (w/weight[0]) * value[0] ;
        }
        for(int index = 1;index < weight.length ;index++){
            for(int w = 0; w <= maxVal; w++){
                int notTake = previous[w];

                int take = 0;

                if(weight[index] <= w){
                    take = value[index] + previous[w-weight[index]];
                }

                previous[w] = Math.max(take,notTake);
            }
        }
        return previous[maxVal];
    }
}
