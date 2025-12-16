package DataStructure.DP.OneD;

import java.util.Scanner;

/**
 * If you don't use certain kind of optimization for recursion, it will reach Golden Ratio near about n = 45,recursion tree goes so deep over and over
 * TC becomes O(n) , SC becomes O(n) + O(n) (stack space and array)
 */
public class Fibonacci {

    //Memoization, the 1d array is used to store subproblems solution so, they can be returned directly.
    int[] dp;

    Fibonacci(int n){
        dp = new int[n+1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number to calculate Fibonacci Number:");
        int n= in.nextInt();
        Fibonacci f = new Fibonacci(n);
        System.out.println(f.nFiboOptimal(n));
    }

    public int nFiboNumber(int n){
        if(n <= 1){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        return dp[n] = nFiboNumber(n-1) + nFiboNumber(n-2);
    }

    /**
     Construct the logic from base case to the required answer.
     we can observe from the base case that dp[0] = 0 and dp[1] = 1. The recursion was called for any other values above them i.e. from 2 till n
     Same logic is used to calculate the rest of the values without using recursion.
     TC= O(n) and SC=O(n) the dp array used.
     */
    public int nFiboTabulated(int n){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * Based on observation, we only needed to know past 2 values to calculate the current fibonacci number using that knowledge we can simply
     * eliminate the use of the array to store past results,
     */

    public int nFiboOptimal(int n){
        int prev2 = 0;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int current = prev + prev2;
            //for the next iteration the current will become previous and the current previous will become second previous
            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
