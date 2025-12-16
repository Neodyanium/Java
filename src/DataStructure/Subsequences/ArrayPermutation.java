package DataStructure.Subsequences;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {

    public static void main(String[] args) {
        System.out.println(arrayPermutation(new int[]{1,2,3},0,new ArrayList<>()));;
    }

    /**
     * Simple algorithm, You recursively swap for all possible options(of permutation) and make the changes with the original array and retain
     * the changes back when you return.
     * eg: [1,2,3] swap starting (i= index, n-1) initially index = 0; options: [1,2,3] ; [2,1,3] ; [3,2,1]
     * so for all the above arrays 0th index was swapped with 0,1,2
     * [1,2,3] => start with index 1 options:  [1,2,3] ; [1,3,2]
     * so for all above arrays 1th index was swapped with 1,2
     * [1,2,3] => start with index 2 options: [1,2,3]
     * [1,3,2] => strat with index 2 options: [1,3,2]
     * so for all above arrays 1th index was swapped with 2,2
     * Same procedures are repeated
     * @param arr
     * @param index
     * @param ans
     * @return
     */
    public static List<List<Integer>> arrayPermutation(int[] arr,int index,List<List<Integer>> ans){
        if(index==arr.length){
            List<Integer> list = new ArrayList<>();
            for(int n:arr){
                list.add(n);
            }
            ans.add(new ArrayList<>(list));
            return ans;
        }
        for(int i = index;i<arr.length;i++){
            swap(arr,i,index);
            arrayPermutation(arr,index+1,ans);
            swap(arr,i,index);
        }
        return ans;
    }

    public static void swap(int[] arr,int i,int index){
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}