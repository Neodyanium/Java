package DataStructure.DP.Subsequences2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[30];
        for(int i=30;i >= 1; i--){
            arr[30-i] = i;
        }
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        int len = LIS(arr);
//        List<Integer> list = longestIncreasingSubList(arr);
        System.out.println(len);
        
    }

    public static int longestIncreasingSub(int index, int previous, int[] arr) {
        if (index == arr.length) {
            return 0;
        }

        int len = longestIncreasingSub(index + 1, previous, arr);


        if (previous == -1 || arr[index] > arr[previous]) {
            len = Math.max(len, 1 + longestIncreasingSub(index + 1, index, arr));
        }
        return len;
    }

    /**
     * Since the previous index here is negative which can't be stored in the array what we can do is shift the coordinate, which means just
     * increment the value of previous to previous + 1 while storing the values the in dp array
     */
    public static int longestIncreasingSubMemo(int index, int previous, int[] arr, int[][] dp) {
        if (index == arr.length) {
            return 0;
        }

        if (dp[index][previous + 1] != 0) {
            return dp[index][previous + 1];
        }

        int len = longestIncreasingSub(index + 1, previous, arr);


        if (previous == -1 || arr[index] > arr[previous]) {
            len = Math.max(len, 1 + longestIncreasingSub(index + 1, index, arr));
        }

        return dp[index][previous + 1] = len;
    }

    /**
     * Since the base condition initialise the dp array to Zero no need to initialise them, write base conditions then possible states
     * the index varies form 0 to n-1 so here it will vary from n-1 to 0, same with previous but previous is always atleast 1 smaller than current
     * Similar to the memoization coordinate shift you have to shift in the tabulation as well
     */
    public static int longestIncreasingSubTabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int previous = index - 1; previous >= -1; previous--) {

                int len = 0 + dp[index + 1][previous + 1];


                if (previous == -1 || arr[index] > arr[previous]) {
                    len = Math.max(len, 1 + dp[index + 1][index + 1]);
                }

                dp[index][previous + 1] = len;

            }
        }
        return dp[0][-1 + 1];
    }

    public static int longestIncreasingSubSpaceOptimization(int[] arr) {
        int n = arr.length;
        int[] current = new int[n + 1];
        int[] ahead = new int[n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int previous = index - 1; previous >= -1; previous--) {

                int len = 0 + ahead[previous + 1];


                if (previous == -1 || arr[index] > arr[previous]) {
                    len = Math.max(len, 1 + ahead[index + 1]);
                }

                current[previous + 1] = len;
            }
            ahead = current;
        }
        return ahead[-1 + 1];
    }

    //{5,4,11,1,16,8}

    /**
     * If we look at the array the max len of substring is at least 1. So we initialise a new array with values 1 and take a max variable
     * We are essentially keeping a record of what is the largest increasing subsequence ending at the current element.
     * dp = {1,1,1,1,1}
     * We iterate over all the elements for every element.
     * for 5 no iterations so value remains 1
     * for 4 1 iteration but 4 < 5 so value remains 1
     * for 11 we have 2 iterations, so we can consider taking 5/4 in the LIS, and dp(11 value) will store 1+ max() between which has the more value
     * of LIS both has 1 so 11 will have value 2
     * for 1 all the elements are bigger
     * for 16 it can form with 5 and 4 and 11 and even 1, among those 11 has max value of 2 so 1+2 is 3.
     * This max is maintained at all the iterations
     */
    public static int longestIncreasingSubOptimal(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return max;
    }

    //{5,4,11,1,16,8}
//    It is very imp to initialise the Hash Array. When we are to trace back if no elements are exactly divisible all the elements the hash array will
// * be all 0, the max index will become 1, so till max index 1 is != to 0 so the while loop executes which it shouldn't. And we get the extra element
//            * in the addition.
    public static List<Integer> longestIncreasingSubList(int[] arr) {
        int[] dp = new int[arr.length];
        int[] hash = new int[dp.length];
        Arrays.fill(dp, 1);
        int lastIndex = 0;
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] =  j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(hash[lastIndex] != lastIndex){
            list.add(0,arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }

        list.add(0,arr[lastIndex]);

        return list;

    }

    public static int LIS(int[] arr){
        int last = 0;
        int len = 1;
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i] > list.get(last)) {
                list.add(arr[i]);
                last++;
                len++;
            }else {
                int ind = Collections.binarySearch(list,arr[i]);
                if(ind < 0){
                    System.out.println("For element "+ arr[i] + " "+ind);
                    ind = -ind - 1;
                }
                list.set(ind,arr[i]);
            }
        }
        System.out.println(list);
        return len;
    }



}