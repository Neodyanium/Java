package Comp.AtCoder.Question3;

import java.util.*;
//The number of operations matched but I guess their order is important as well
//    size: 3
//  arr: 3 1 2
// My op:
// 2
//2 3
//1 2
//Expected: (Can't believe)
// 2
//1 2
//2 3
public class CSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[in.nextInt()];
        for(int i=0;i<arr.length;i++){
            arr[i]= in.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        //sort
        int operations = 0,i=0;
        while(i<arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
                operations++;
                list.add(i+1);
                list.add(correct+1);
            }else{
                i++;
            }
        }
        System.out.println(operations);
        for(int j=0;j<list.size();j+=2){
            System.out.println(list.get(j)+" "+list.get(j+1));
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}




