package DataStructure.Recursion;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {1,2,2,1,1};
        int target = 4;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    /**
     * It is a bit hard to think of, you will need to choose a combination(so no repetition of same element) the result also needs to be in
     * lexicographically sorted order hence need to sort array before continuing operation.
     *
     * Recursive call has (array,index,target,data structure) we are using a for loop as we will make a choice between all the array elements
     * and we make a condition if array element exceeds target we will break as the candidates would also be greater than target. we have another
     * condition in the same for iteration if you have element already in ds we don't add in another time.
     * Here the base condition is only the target value == 0, the for loop already ensures we are well within range
     *
     * @param arr
     * @param target
     * @param index
     * @param ds
     * @param result
     */

    public static void combinationSum(int[] arr, int target, int index, List<Integer> ds, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target) break;
            if (i > index && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            combinationSum(arr, target - arr[i], i + 1, ds, result);
            ds.remove(ds.size() - 1);
        }
    }

}
