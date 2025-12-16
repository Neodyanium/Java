package DataStructure.SlidingWindow;

import java.util.Arrays;

public class ConstantWindow {

    public static void main(String[] args) {
        int[] arr = {-2,4,5,10,-9,3,12,5,-2,2,9};
        int k = 4;
        System.out.println(maximumSubarraySum(arr,4));
        System.out.println(Arrays.toString(maximumSubarray(arr,4)));
    }

    /**
     *
     * @param arr integer array rerceived
     * @param k length of the subaaray to calculate maximum sum
     * Have a look at how is it working in order of n
     * @return returns maximum sum
     */
    public static int  maximumSubarraySum(int[] arr,int k){
        int left = 0;
        int right = k-1;
        int sum = 0;
        for(int i=left;i<=right;i++){
            sum+=arr[i];
        }
        int max = 0;
        while(right < arr.length - 1){
            sum = sum - arr[left];
            left++;
            right++;
            sum = sum + arr[right];
            max = Math.max(max,sum);
        }
        return max;
    }

    /**
     *
     * @param arr Array recived
     * @param k subarray size
     * Logic is very similar to the above program, it's just that as we check if new max is found here we store that subarrays start and end
     * @return the subarray which has the maximum sum result
     */
    public static int[] maximumSubarray(int[] arr,int k){
        int left=0,right=k-1,sum=0;
        for(int i=left;i<=right;i++){
            sum += arr[i];
        }
        int max = 0;
        int l=0,r=0;
        while(right < arr.length-1){
            sum = sum - arr[left];
            left++;
            right++;
            sum = sum + arr[right];
            if(sum > max){
                max = sum;
                l = left;
                r=right;
            }
        }
        int[] result = new int[r-l+1];
        int index=0;
        for(int i=l;i<=r;i++){
            result[index] = arr[i];
            index++;
        }
        return result;
    }

}
