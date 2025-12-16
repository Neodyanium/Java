package DataStructure.SlidingWindow.Problems;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,1,1};
        System.out.println(maxConsOnes(arr,2));

    }

    /**
     *
     * @param arr
     * @param k- The amount flips allowed from Zero to One.
     *         Finds maximum subarray's length with k flipped ones. (It is very similar to found the max sub array sum with sum less than k
     * @return
     */
    public static int maxConsOnes(int[] arr,int k) {
        int l = 0,r=0;
        int max=0, zeroes=0;
        while(r < arr.length){
            if(arr[r] == 0){
                zeroes++;
            }
            if(zeroes <= k){
                max = Math.max(max,r-l+1);
            }else{
                if(arr[l] == 0){
                    zeroes--;
                }
                l++;
            }
            r++;
        }
        return max;
    }
}
