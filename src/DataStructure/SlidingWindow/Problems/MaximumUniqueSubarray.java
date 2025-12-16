package DataStructure.SlidingWindow.Problems;

import java.util.HashSet;

public class MaximumUniqueSubarray {

    public static int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, max = 0;
        while(r < nums.length){
            if(!set.contains(nums[r])){
                set.add(nums[r]);
                sum += nums[r];
                max = Math.max(max,sum);
                r++;
            }else{
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
        }
        return max;
    }

}
