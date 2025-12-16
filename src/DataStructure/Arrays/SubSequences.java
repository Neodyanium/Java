package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(generateSub(arr));
    }

    public static List<List<Integer>> generateSub(int[] arr){
        return generateSub(arr,0,new ArrayList<>());
    }

    public static List<List<Integer>> generateSub(int[] arr,int index,List<Integer> list){
        List<List<Integer>> finalList= new ArrayList<>();
        if(index >= arr.length){
           finalList.add(new ArrayList<>(list));

           return finalList;
        }
        list.add(arr[index]);
        finalList.addAll(generateSub(arr,index+1,list));
        list.remove(list.size()-1);
        finalList.addAll(generateSub(arr,index+1,list));
        return finalList;
    }


}
