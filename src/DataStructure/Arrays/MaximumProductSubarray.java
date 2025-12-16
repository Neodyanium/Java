package DataStructure.Arrays;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] arr = {3,2,-1,0,5,-2,0,4,-3,4,-6,3,-2,6};
        int prod = maximumProduct(arr);
        System.out.println(prod);
    }

    /**
     * Observations:
     * 1) If all the number are positives, we can multiply all the elements
     * 2) If the number of negative numbers are even, we can still multiply
     * 3) If the number of negatives are odd then? array => 3,2,-1,4,-6,3,-2,6  then prefix array and suffix array: 3,2 and 4,-6,3,-2,6 or
     *    3,2,-1,4 and 3,-2,6 or 3 2 1 4 5 3 and 6
     * 4) If the element is 0, it makes the product 0, so to make the product == 1 if it became 0, so the 0 doesn't continue.
     *
     * We can see that all of the conditions can be checked if we just take prefix product and suffix product while maintaining the maximum
     *
     * @param arr
     * @return
     */
    public static int maximumProduct(int[] arr){
        int prefix = 1,suffix = 1,max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(prefix == 0) prefix=1;
            if(suffix == 0) suffix=1;
            prefix = prefix * arr[i];
            suffix = suffix * arr[arr.length-1-i];
            max = Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }
}
