package DataStructure.DP.Subsequences;

import java.util.Arrays;

/**
 *
 */
public class SubsetSumKCount {

    public static void main(String[] args) {
        int target = 0;
        int[] arr = {0};

        int ifExist = sumEqualsKRecursionCount(arr,arr.length-1,target);
        System.out.println(ifExist);
        //You should make the dp array according to the constraints provided
        int[][] dp = new int[arr.length][target+1];  //It means that it index will take values from 0 till n-1 and target can be 0 till target
        int ifExist2 = sumEqualsKMemoizedCount(arr,dp,target,arr.length-1);
        int ifExist3 = sumEqualsKTabulationCount(arr,target);
//        System.out.println(ifExist3);

        int ifExists4 = sumEqualsKCountOptimal(arr,target);
//        System.out.println(ifExists4);
    }


    /**
     *Proper recurrence written, you need to return the stuff.
     *  if(target == 0)
     *             return 1;
     *
     *   if(index == 0){
     *      return (arr[0] == target) ? 1:0;
     *   }
     * Here if the array has some instances of 0, we are working by reducing the sum, so there will come some choice where if we don't choose
     * the target will become 0 and it will be returned so no choose and not choose take place even if the array has more element to visit.
     * Consider the array {0,0} and target = 0 ->
     */
    public static int sumEqualsKRecursionCount(int[] arr, int index, int target){
        //removed
//        if(target == 0)
//            return 1;

        if(index == 0){
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || target == arr[0]) return 1;
            return 0;
        }

        int notTake = sumEqualsKRecursionCount(arr,index-1,target);

        int take = 0;
        if(target >= arr[index]){
            take = sumEqualsKRecursionCount(arr,index-1,target-arr[index]);
        }

        return notTake + take;
    }

    public static int sumEqualsKMemoizedCount(int[] arr, int[][] dp, int target, int index){
        if( target == 0) return 1;
        if(index == 0)
            return (arr[0] == target)?1:0;
        if(dp[index][target] != 0){
            return dp[index][target];
        }

        int notTake = sumEqualsKMemoizedCount(arr,dp,target,index-1);

        int take = 0;
        if(target >= arr[index]){
            take = sumEqualsKMemoizedCount(arr,dp,target-arr[index],index-1);
        }

        return  dp[index][target] =take + notTake;
    }

    private static int sumEqualK(int[] arr,int index, int target) {
        if(index == arr.length){
            return target == 0 ? 1 : 0;
        }
        if(target == 0){
            return 1;
        }

        return sumEqualK(arr,index+1,target-arr[index]) + sumEqualK(arr,index+1,target);

    }

    public static int sumEqualsKTabulationCount(int[] arr, int target){
        int[][] dp = new int[arr.length][target+1];
        if(arr[0] <= target)
            dp[0][arr[0]] = 1;
        for(int index = 0;index<arr.length;index++){
            dp[index][0] = 1;
        }
        for(int index=1;index<arr.length;index++){
            for(int k = 1;k<=target;k++){
                int notTake = dp[index-1][k];

                int take = 0;
                if(k >= arr[index]){
                    take = dp[index-1][k-arr[index]];
                }

                dp[index][k] = notTake + take;
            }
        }
        return dp[arr.length-1][target];
    }

    public static int sumEqualsKCountOptimal(int[] arr, int target){
        int[] dp = new int[target + 1];
        if(arr[0] <= target)
            dp[arr[0]] = 1;
        dp [0] = 1;
        int[] current = new int[target+1];
        current[0] = 1;
        for(int index = 1;index<arr.length;index++){

            for(int k = 1; k <= target; k++ ){
                int  notTake = dp[k];

                int take = 0;
                if(k >= arr[index]){
                    take = dp[k-arr[index]];
                }

                current[k] = notTake + take;
            }
            dp = current;
        }
        return dp[target];
    }
}
