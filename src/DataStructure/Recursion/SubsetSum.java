package DataStructure.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<Integer> result = (subsetSum(arr,0,0));
        Collections.sort(result);
        System.out.println(result);
    }

    public static List<Integer> subsetSum(int[] arr, int index, int sum){
        List<Integer> list = new ArrayList<>();
        if(index == arr.length){
            list.add(sum);
            return list;
        }
        list.addAll(subsetSum(arr,index+1,sum+arr[index]));
        list.addAll(subsetSum(arr,index+1,sum));
        return list;
    }
}
