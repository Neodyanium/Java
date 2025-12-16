package DataStructure.Arrays;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,1,-4};
        arr = new int[]{2,0,0,3};
        System.out.println(longestSubArray(arr, 3));
    }

    /**
     *
     * @param arr
     * @param k
     * I have an array and I am going to iterate over it calculating the prefix sum, after I add the current integer to my sum variable I check
     * whether this is equal to k, if yes we will update the maximum length, later check if sum - k has occured before by checking the same sum-k
     * in the hashmap. if it exists then it means a subaaray with sum=k has occured before this so let's update the map if the current subarrays length is
     * is greater than the previous subarrays( current index - map(previous sum to k index) ). After this if the value is not present in Hashmapp we
     * add it. This is essentail to get the max length(consider eg:[2,0,0,3] k=3, if we kept updating the map prefix sum would be 2 at index=2.
     * @return Most Optimal if array has -ve,0 and +ve integers
     */
    public static int longestSubArray(int[] arr, int k) {
        int max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                max = Math.max(max, i + 1);
            }
            int rem = sum - k;
            if(map.containsKey(rem))
                max = Math.max(max, i - map.get(rem));
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }

    /**
     * Sliding Window approach for the same, but only applicable if positives and 0, reason is consider arr=[1,1,1,1,3,1,-4] and k=4
     * here the longest subarray would be 7 but if we follow two pointer approach after 4 consecutive ones when we encounter 3 the window will
     * automatically shrink effectively reducing what could be the max length with sum k
     * @param arr
     * @param k
     * @return
     */

    public static int longestSubArraySW(int[] arr, int k) {
        int max = 0, sum = 0;
        int i=0,j=0;
        while(j < arr.length){
            while(i <= j && sum > k){
                sum -= arr[i];
                i++;
            }
            sum+=arr[j];
            if(sum == k){
                max = Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
    }


}
