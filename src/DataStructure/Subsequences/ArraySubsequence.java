package DataStructure.Subsequences;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsequence {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subsequence(arr,0,new ArrayList<>());
    }

    public static void subsequence(int[] arr, int index, List<Integer> list){
        if(index == arr.length){
            System.out.println(list +" ");
            return;
        }
        list.add(arr[index]);
        subsequence(arr,index+1,list);
        list.remove(list.size()-1);
        subsequence(arr,index+1,list);
    }


}
