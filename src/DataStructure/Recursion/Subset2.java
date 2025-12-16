package DataStructure.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate all the unique subsets
 */
public class Subset2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> result = uniqueSubsets(arr);
        System.out.println(result);
    }

    public static List<List<Integer>> uniqueSubsets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        uniqueSubsets(arr, 0, new ArrayList<>(),result);
        return result;
    }

    public static void uniqueSubsets(int[] arr, int index, List<Integer> list,List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for(int i = index; i < arr.length; i++) {
            if(i != index && arr[i] == arr[i-1])
                continue;    // i > index usually
            list.add(arr[i]);
            uniqueSubsets(arr,index+1,list,result);
            list.remove(list.size()-1);
        }
    }
}
