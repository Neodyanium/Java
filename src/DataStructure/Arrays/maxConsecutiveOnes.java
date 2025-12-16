package DataStructure.Arrays;

public class maxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        findMaxConsecutiveOnes(arr);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0,max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
            }else{
                System.out.println(count);
                max = Math.max(count,max);
                count=0;
            }
        }
        return max;
    }
}
