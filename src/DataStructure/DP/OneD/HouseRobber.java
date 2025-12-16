package DataStructure.DP.OneD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(houseRobber(arr));
    }

    /**
     *     The logic used is similar to NonAdjacent array elements sum, here in house robber the array is circular i.e. the first and last element are
     *     neighbouring elements so can't be included in the sum together
     *     Solution: At a time only the first or the last element can be present in the answer (maximum sum), so what we can do is make an array without
     *     the first element and array without the last element, we can keep the function to calculate the maximum sum separate and call the same
     *     once with array without first element and array without last element and calculate a max between them
     */


    public static long houseRobber(int[] arr) {
        List<Integer> remaining = new ArrayList<>();
        List<Integer> excluded = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i != 0)
                remaining.add(arr[i]);
            if(i != arr.length-1)
                excluded.add(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(remaining);
        System.out.println(excluded);

        return Math.max(houseRobberGen(remaining),houseRobberGen(excluded));
    }

    public static long houseRobberGen(List<Integer> arr){
        long prev = arr.get(0);
        long secondPrev = 0;
        for(int i=1;i<arr.size();i++){
            long pick = arr.get(i);
            if(i > 1)
                pick += secondPrev;
            long notPick = prev;
            secondPrev = prev;
            prev = Math.max(pick,notPick);
        }
        return prev;
    }
}
