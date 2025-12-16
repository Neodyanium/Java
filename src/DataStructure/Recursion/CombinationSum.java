package DataStructure.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * It mentions patterns for backtracking questions, check it out
 * https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 */
public class CombinationSum {


    /**
     * It is not difficult to figure out, you want to get to the target sum, we can have recursive algorithm to get calculate if the sum of any
     * subsequence give us the target sum, but here a change we can choose any number any number of times.
     * consider example: 2,3,6,7  -> result: [[2,2,3],[7]]
     * we can see we choose number at index 0 once, then twice then didn't chooose the number at index 0 anymore and then chose number at index 1
     * and avoid choosing number at index 2 and index 3. Simple
     *
     * recusive algo => (array,index,target,list)
     * 1) if number at index is less or equal to target only then choose the same number or else don't choose the number and move to next index,
     * while choosing subtract the number from target and add it to the list data structure.
     * 2)After you came back remove the number from the list data structure and call with the next index (All possible combo)
     * 3) Base condition is when the index is as same length as array and target is 0.
     *
     * Keep Debugging it, it is similar to the subsequences but still little different and intuitive
     *
     *
     * @param arr
     * @param list
     * @param index
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] arr,List<Integer> list,int index,int target){
        List<List<Integer>> result = new ArrayList<>();
        if(index == arr.length){
            if(target == 0) {
                result.add(new ArrayList<>(list));
            }
            return result;
        }
        if(arr[index] <= target){
            list.add(arr[index]);
            result.addAll(combinationSum(arr,list,index,target-arr[index]));
            list.remove(list.size()-1);
        }
        result.addAll(combinationSum(arr,list,index+1,target));
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int targetSum = 7;
        List<List<Integer>> result = combinationSum(arr,new ArrayList<>(),0,targetSum);
        System.out.println(result);
    }
 }
