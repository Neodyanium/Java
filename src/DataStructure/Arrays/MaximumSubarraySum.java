package DataStructure.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = {-10,5,2,4,-3,9,3,1,1,0,0,-4,2};
        System.out.println(maxSum(arr));
        System.out.println(Arrays.toString(maxSumArray(arr)));
    }

    /**
     *As simple as it can be based on the observation, iterate over the array and add the sum if sum is negative simply ignore it by considering
     * sum=0, if the sum is positive keep moving forward and keep saving the max sum.
     * @param arr
     * @return
     */
    public static int maxSum(int[] arr){
        int sum=0,maxS=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum > maxS){
                maxS = sum;
            }
            if(sum < 0)
                sum=0;
        }
        return maxS;
    }

    /**
     *Incase you want the subaarray make two variables, check if sum is zero (we are starting or restarting the subarray) so assign start again.
     * and whenever you are updating the max sum you can update the end. At the end you can simply return Arrays.copyOfRange()
     * @param arr
     * @return
     */
    public static int[] maxSumArray(int[] arr) {
        int sum=0,max=0,start=0,startans=0,end=0;
        for(int i=0;i<arr.length;i++){
            if(sum == 0){
                start=i;
            }
            sum += arr[i];
            if(sum >= max){
                max=sum;
                startans=start;
                end=i;
            }
            if(sum < 0){
                sum=0;
            }
        }
        return Arrays.copyOfRange(arr,startans,end+1);
    }
}
