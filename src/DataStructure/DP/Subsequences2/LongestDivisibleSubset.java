package DataStructure.DP.Subsequences2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Here subset is any derivative within the array the order is not important, what we want is a subset where the all the numbers are divisible
 * eg; {1,16,7,8,4} : ans: {16,8,4,1} or { 1,4,8,16 } the order is unimportant. Utilised the same way we have calculated the LIS.(converting)
 *
 * Solution: Sort the array so it becomes the increasing order automatically, now only thing to remains is go through the array. and look back
 * which elements are divisible by current element (done via 2 for loops). we are saving on each dp[i] the largest subseq i.e divisible they
 * could get to, we create a hash to store the indexes whenever we upgraded our dp[i] so, we can back track it later.
 *
 * It is very imp to initialise the Hash Array. When we are to trace back if no elements are exactly divisible all the elements the hash array will
 * be all 0, the max index will become 1, so till max index 1 is != to 0 so the while loop executes which it shouldn't. And we get the extra element
 * in the addition.
 */
public class LongestDivisibleSubset {


    public static void main(String[] args) {
        int[] arr = {20,19,11,25,21}; //11 19 20 21 25
        List<Integer> list = longestDivisibleSubset(arr);
        System.out.println("Answer Array: " +list);
    }

    public static List<Integer> longestDivisibleSubset(int[] arr){
        System.out.println("Initial Array: " + Arrays.toString(arr));
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        int[] hash = new int[arr.length];
        int lastIndex = 0,max=0;
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        for(int i=1;i<arr.length;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(arr[i] % arr[j] == 0){
                    dp[i] = 1 + dp[j] ;
                    hash[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        System.out.println("DP Array: " +Arrays.toString(dp));
        System.out.println("Hash Array: " +Arrays.toString(hash));
        List<Integer> list = new ArrayList<>();
        while(hash[lastIndex] != lastIndex){
            list.add(0,arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        list.add(0,arr[lastIndex]);
        return list;
    }
}
/*
    Miscellaneous

    If you don't initialise the hash array for each i, Here array starting from 0

    Initial Array: [20, 19, 11, 25, 21]
    Sorted Array: [11, 19, 20, 21, 25]
    DP Array: [1, 1, 1, 1, 1]
    Hash Array: [0, 0, 0, 0, 0]
    Answer Array: [11]

    Initial Array: [20, 19, 11, 25, 21]
    Sorted Array: [11, 19, 20, 21, 25]
    DP Array: [1, 1, 1, 1, 1]
    Hash Array: [0, 1, 2, 3, 4]
    Answer Array: [11]

    i starting from 1

    Initial Array: [20, 19, 11, 25, 21]
    Sorted Array: [11, 19, 20, 21, 25]
    DP Array: [1, 1, 1, 1, 1]
    Hash Array: [0, 0, 0, 0, 0]
    Answer Array: [11, 19]

    Initial Array: [20, 19, 11, 25, 21]
    Sorted Array: [11, 19, 20, 21, 25]
    DP Array: [1, 1, 1, 1, 1]
    Hash Array: [0, 1, 2, 3, 4]
    Answer Array: [19]

    if max=1 and we leave the hash part
    7
    12 6 4 9 21 25 9
    fails

 */
