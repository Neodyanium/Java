package DataStructure.Recursion;
import java.util.*;

import static DataStructure.Arrays.SortArrays.swap;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        boolean[] bool = new boolean[arr.length];
        List<List<Integer>> result = permutation1(arr,new ArrayList<>(),new ArrayList<>(),bool);
        List<List<Integer>> results = permutation2(arr,0,new ArrayList<>(),new ArrayList<>());
        System.out.println(results);
    }

    /**
     * Not very well written but simple to understand by code
     * Logic is we can choose any of one of the elements from all the elements available, after that go to next index do the same, keep repeating
     * till the datastructure has size thaat of the array.
     *
     * @param arr
     * @param ds
     * @param ans
     * @param picks
     * @return
     */

    public static List<List<Integer>> permutation1(int[] arr,List<Integer> ds,List<List<Integer>> ans,boolean[] picks){
        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return ans;
        }
        for(int i=0;i < arr.length;i++) {
            if (!picks[i]) {
                picks[i] = true;
                ds.add(arr[i]);
                permutation1(arr, ds, ans, picks);
                ds.remove(ds.size() - 1);
                picks[i] = false;
            }
        }
        return ans;
    }


    public static List<List<Integer>> permutation2(int[] arr,int index,List<Integer> list,List<List<Integer>> ans){
        if(index == arr.length){
            ans.add(new ArrayList<>(list));
            return ans;
        }

        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            list.add(arr[index]);
            permutation2(arr,index+1,list,ans);
            list.remove(list.size()-1);
            swap(arr,i,index);
        }
        return ans;
    }


}
