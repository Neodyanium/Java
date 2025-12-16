package DataStructure.DP.Subsequences;

import java.util.Arrays;

public class TwoEqualSubset {
    /**
     * Problem: You have to tell whether the array can have 2 subsets such that their sum is equal.
     * Array = {2,3,3,3,4,5} subset = {2,3,5} , {3,3,4} and there sum is 10.
     *
     * Solution: We can get the sum of total array, here it is 20. So it can be divided if any of the subset sum becomes 10. Also,You can only
     * divide the array into in two equal sub arrays only if the total array sum is even. The problem is now reduced to get a certain target sum
     */

    public static void main(String[] args) {
        int[] arr = {5,6,5,11,6};
        boolean ifPossible = equalSubsets(arr);
        System.out.println(ifPossible?"Yes It can be divided in 2 Subsets" : "No it can't be divided into 2 subsets");
    }


    public static boolean equalSubsets(int[] arr){
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 == 0){
           return  f(arr,sum/2);
        }
        return false;
    }

    public static boolean f(int[] arr,int target){
        boolean[] dp = new boolean[target+1]; //It's the first row, so all the range of targets
        dp[0] = true;
        if(arr[0] <= target){
            dp[arr[0]] = true;
        }
        for(int index = 1; index < arr.length; index ++){
            boolean[] current = new boolean[target+1];
            current[0] = true;
            for(int k = 1;k <= target;k++){

                boolean notTake = dp[k];

                boolean take = false;
                if(arr[index] <= k ){
                    take = dp[k-arr[index]];
                }

                current[k] = take || notTake;
            }
            dp = current;
        }
        return dp[target];
    }
}
