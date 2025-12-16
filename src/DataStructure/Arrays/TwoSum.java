package DataStructure.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumBe(new int[]{2,6,5,8,1},14)));
        System.out.println(twoSumBeO(new int[]{2,6,5,8,1},14));
    }

    /**
     * It's an easy approach, n1 + n2 = target, start the iteration and check if the target - arr[i](that would be n2) is present in the map
     * if it is not just store the current number with its index in the map. If you keep iterating you will eventuallly find the n2 and you can
     * return the indexes
     * @param arr
     * @param target
     * @return
     */

    private static int[] twoSumBe(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target - arr[i])){
                return new int[]{i,map.get(target-arr[i])};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    /**
     * It can be used as boolean funtion to check whether there exists a pair. if you want still want the indexes what you can do is make a new
     * data structure with pair-of array values and indexes and sort them based on values. the indexes won't change. the rest of the approach
     * remains same as the below.
     * @param arr
     * @param target
     * @return
     */

    private static boolean twoSumBeO(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0 ,r = arr.length-1;
        while(l < r){
            if(arr[l] + arr[r] < target)
                l++;
            else if(arr[l] + arr[r] > target)
                r--;
            else
                return true;
        }
        return false;
    }


}
