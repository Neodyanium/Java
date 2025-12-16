package DataStructure.Arrays;

import java.util.HashMap;

public class NumberOfSubarrays {

    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(subarraysWithSumK(arr,3));
    }
    //{1,2,3,-3,1,1,1,4,2,-3}
    public static int subarraysWithSumK(int[] arr,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0,count=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            int rem = sum -k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
