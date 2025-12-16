package DataStructure.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Similar subsequences problems can come with return only single subarray in such case use a flag, or return a boolean when first subsequence is
 * found since you can't return list of answer pass it as the parameter in recursive function.
 *
 * One more similar is get me the number of such subsequences, here you won't even need to store the elements in list just maintain the sum and index
 * when you get a result return 1, the choice where you select and where you don't each might return ans so keep summing them and return at the end.
 */
public class SubsequenceWithSumK {

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int targetSum = 2;
        List<List<Integer>> list = listsubsWithSumK(arr,targetSum,0,0,new ArrayList<>());
        System.out.println(list);
    }

    public static List<List<Integer>> listsubsWithSumK(int[] arr,int targetSum,int sum,int index,List<Integer> list){
        List<List<Integer>> result = new ArrayList<>();
        if(index >= arr.length){
            if(sum == targetSum){
                result.add(new ArrayList<>(list));
                return result;
            }
            else
                return result;
        }
        list.add(arr[index]);
        result.addAll(listsubsWithSumK(arr,targetSum,sum + arr[index],index+1,list));
        list.remove(list.size()-1);
        result.addAll(listsubsWithSumK(arr,targetSum,sum,index+1,list));
        return result;
    }
}
