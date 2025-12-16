package DataStructure.DP.Grids2D;

import java.util.Arrays;

import static DataStructure.Arrays.ConvertGrid.print;

public class MinJumps {

    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1};
        int s = jump(arr);
        System.out.println("Array:"+ Arrays.toString(arr) +"\nTotal jumps required:"+s);
    }
    //Driver for Recursion
    public static int jump(int[] nums) {
        //dp
        int[][] dp = new int[nums.length][nums.length];
//        int r =  min(nums,0,0,dp);
        return minTab(nums);
    }
    //Recursion and Memoization
    public static int min(int[] nums,int index,int steps,int[][] dp){
        if(index == nums.length - 1)
            return steps;

        if(dp[index][steps] != 0){
            return dp[index][steps];
        }

        int minV = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            minV = Math.min(minV,min(nums,index+i,steps+1,dp));
        }
        return dp[index][steps] = minV;
    }

    public static int minTab(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        for(int index=nums.length-2;index >= 0;index--){
            for(int steps=0;steps<nums.length;steps++){
                int minV = Integer.MAX_VALUE;
                for(int i=1;i<=nums[index];i++){
                    if(index+i < nums.length)
                        minV = Math.min(minV,dp[index+i][steps+1]);
                    else
                        minV = 1;
                }
                dp[index][steps] = minV;
            }
        }
        print(dp);
        return dp[0][0];
    }
}
