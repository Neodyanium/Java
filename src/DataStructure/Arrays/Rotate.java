package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rotate {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        rotateOptimalLeft(arr,3);
        System.out.println(Arrays.toString(arr));
        rotateOptimalRight(arr,3);
        rotateOptimalRight(arr,3);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int i;
        for(i=0;i<nums.length-k;i++)
            list.add(nums[i]);
        int idx=0;
        for(;i<nums.length;i++){
            nums[idx++]=nums[i];
        }
        idx=0;
        int start = k % 2 == 0 ? list.size() :list.size()-1;
        for(int j = start ; j<nums.length;j++){
            nums[j] = list.get(idx++);
        }
    }
    /**
     * It is all about the observations
     * Consider the Array: [1,2,3,4,5,6,7] k=3 , Rotate Right by 3 and it looks like [5,6,7,1,2,3,4]
     * First we limit the rotations(adjust with size)
     * consider if I reversed the last 3 [1,2,3,4,7,6,5]
     * then I reversed the entire Array [5,6,7,4,3,2,1]
     * Then reverse starting from the kth index [5,6,7,1,2,3,4]
     */
    public static void rotateOptimalRight(int[] nums, int k) {
        int r = k % nums.length;
        int n  = nums.length;
        reverse(nums,n - r,n-1);
        reverse(nums,0,n-1);
        reverse(nums,r,n-1);
    }


    public static void reverse(int[] nums,int idx1,int idx2){
        while(idx1 < idx2){
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            idx1++;
            idx2--;
        }
    }
    /** Rotate Left
     * [1,2,3,4,5,6,7] by 3 ==> [4,5,6,7,1,2,3]
     * reverse from 0 till 3(index2)
     * [3,2,1,4,5,6,7]
     * reverse from 3 to n(index n-1)
     * [3,2,1,7,6,5,4]
     * reverse from 0 to n
     * [4,5,6,7,1,2,3]
     */
    public static void rotateOptimalLeft(int[] nums, int k) {
        int r = k % nums.length;
        int n  = nums.length;
        reverse(nums,0,r-1);
        reverse(nums,r,n-1);
        reverse(nums,0,n-1);
    }
}
