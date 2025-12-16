package DataStructure.Arrays;

import java.util.HashMap;

public class SubarrayWithXORK {

    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int k=6;
        int count = countSubWithXORK(arr,k);
        System.out.println(count);
    }

    /**
     * The intuition is same as when we are calculating subarray with sum k, we keep a track of if the prefix sum has been here before, if occured
     * how many times did it occur that many subarrays can be formed.
     * @param arr
     * @param k
     * @return Total count of subarrays whose XOR results in K(target)
     */
    public  static int countSubWithXORK(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int xor = 0,count=0;
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            xor = xor ^ arr[i];
            int xorBefore = xor ^ k;
            if(map.containsKey(xorBefore)){
                count+=xorBefore;
            }
            map.put(xor,map.getOrDefault(arr[i],0)+1);
        }
        return count;
    }
}
