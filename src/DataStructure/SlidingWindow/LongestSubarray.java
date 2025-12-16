package DataStructure.SlidingWindow;

import java.util.Arrays;

public class LongestSubarray {

    public static void main(String[] args) {
        int[] arr = {-2,4,5,10,-9,3,12,5,-2,2,9};
        int k = 4;
        System.out.println(longestSubArrayWithSumK(new int[]{1,-1,2},1));
        System.out.println(Arrays.toString(longestSubArrayWithSum(new int[]{10,10,2,1},3)));
        System.out.println(LSAO(new int[]{1,1,1,1,2,2,2,1,1,1,1,1},5));
    }

    /**
     *Largest subarray length with sum less than or equal to k
     */
    public static int LSA(int[] nums,int k) {
        int l=0, r = 0 , n = nums.length;
        int sum = 0, maxLen = 0;
        while(r < n){
            sum = sum + nums[r];

            //if the sum has become greater than k we move or left pointer and reduce the sum
            while(sum > k){
                sum = sum - nums[l];
                l++;
            }

            //Since this is a valid value for the sum we can just count the maxlength
            maxLen = Math.max(maxLen,r-l+1);

            r++;
        }
        return maxLen;
    }

    /**
     * Optimization of the above code to avoid un
     */
    public static int LSAO(int[] nums,int k) {
        int l=0, r = 0 , n = nums.length;
        int sum = 0, maxLen = 0;
        while(r < n){
            sum = sum + nums[r];

            //if the sum has become greater than k we move our left pointer and reduce the sum but only once, so the
            // maxlength won't become less than the max value
            if(sum > k){
                sum = sum - nums[l];
                l++;
            }

            //Since this is a valid value for the sum we can just count the maxlength
            if(sum <= k)
                maxLen = Math.max(maxLen,r-l+1);

            r++;
        }
        return maxLen;
    }

    public static int longestSubArrayWithSumK(int[] arr,int k){
        int l = 0,r = 0;
        int max = 0;
        int sum = 0;
        while(r < arr.length){
            sum = sum + arr[r];
            if(sum <= k){
                max = Math.max(max,r-l+1);
            }else{
                sum = sum - arr[l];
                l++;
            }
            r++;
        }
        return max;
    }

    public static int[] longestSubArrayWithSum(int[] arr,int k){
        int l = 0,r = 0;
        int max = 0,sum = 0;
        int left =0,right = 0;
        while(r < arr.length){
            sum = sum + arr[r];
            //This might give error answers if used for subarrays so you need to shrink it befoe expanding again
            /*
            while(sum > k){
            sum -= arr[l--];
            }
            if(sum <= k){
                if(max < r-l+1){
                    max = r - l + 1;
                    left = l;
                    right = r;
                }
             }
              r++;
             */
            if(sum <= k){
                if(max < r-l+1){
                    max = r - l + 1;
                    left = l;
                    right = r;
                }
            }else{
                sum = sum - arr[l];
                l++;
            }
            r++;
        }
        int[] res = new int[right - left + 1];
        int index = 0;
        for(int i=left;i<=right;i++){
            res[index] = arr[i];
            index++;
        }
        return res;
    }
}
