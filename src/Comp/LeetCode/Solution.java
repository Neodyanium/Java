package Comp.LeetCode;

import java.util.Arrays;

public class Solution {
    public static int minimumSubarrayLength(int[] nums, int k) {
        if(Arrays.stream(nums).max().getAsInt() >= k){
            return 1;
        }
        int res=0;
        int count = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            res=0;
            for(int j=i;j<nums.length;j++){
                res |= nums[j];
                if(res >= k){
                    count = Math.min(count,j-i+1);
                }
            }

        }
        if(count == Integer.MAX_VALUE) return -1;
        return count;
    }

        public static int maxBottlesDrunk(int numBottles, int numExchange) {
            int drunkbottle = numBottles;
            int emptyBottle = numBottles;
            int gained = 0;
            while(emptyBottle  >= numExchange){
                drunkbottle++;
                emptyBottle = emptyBottle - numExchange;
                numExchange++;
                emptyBottle++;
                // System.out.println(drunkbottle +" "+numExchange);
//                gained++;
//                if(drunkbottle < numExchange && (gained + drunkbottle) >= numExchange){
//                    drunkbottle += gained;
//                    numBottles = gained;
//                    gained=0;
//                }
            }
            return drunkbottle;
        }
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int temp = x;
        int sum=0;
        while(x != 0){
            sum += x % 10;
            x /= 10;
        }
        if(((double) temp / x) % 1 == 0){
            return sum;
        }
        return -1;
    }

    public static long countAlternatingSubarrays(int[] nums) {
        long count=0;
        count+=nums.length;
        for(int i=1;i<nums.length;i++){
            int elem = nums[i-1];
            for(int j=i;j<nums.length;j++) {
                if (nums[j] != elem) {
                    elem = nums[j];
                    count++;
                }
            }
        }
        return count;
    }
    //0 1 3 7
    //
    public static void main(String[] args) {
        String s = " ";
        System.out.println(Character.isAlphabetic(s.charAt(0)));
        System.out.println(countAlternatingSubarrays(new int[]{0,1,1,1}));
    }
}