package DataStructure.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static DataStructure.Arrays.Rotate.reverse;
import static DataStructure.Arrays.SortArrays.swap;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {6,10,8,13,13}; //2,1,5,4,3,0,0
        System.out.println(nextGreaterPermutation(Arrays.asList(6,10,8,13,13)));
        permuatation(arr);

        System.out.println(Arrays.toString(arr));
    }
    // 2 1 5 4 3 0 0

    /**
     * How do you approach the problem, you have a limit of the numbers provided in the array and need to find lexographically greater permutation
     * so what would be the next, we would want to keep the prefix as long as possible, so we keep checking from the right end. if changing the
     * position of 0s at the end will only minimise it, we can say the same for [3 0 0] if 3 is moved the number becomes small, you will see similar
     * pattern if we consider [4 3 0 0] and [5 4 3 0 0]. But we see that [1 5 4 3 0 0] if 1 is replaced by other greater number then we can efectively
     * increase the number and it would have a shared prefix also, but how to get that number if we replace 1 with 5 it would become large
     * [2 5 1 4 3 0 0] but we can also see we could use 4 or 3 instead of 5 and it would still be large. So how do we choose proper large. After
     * choosing the proper index which can be replace (1 in our example) we will choose a number which is large than 1 but should be smallest among
     * large elements than 1 how to achieve this, check from last element till next of 1 (index + 1) greater than 1 and swap the values of element at
     * index and the number found. Now we would want the array after index + 1 should be small as possible we can achieve this by sorting. But it is
     * important to note that the array after index + 1 is descending, so we can simply reverse it.
     *
     * IMP: The break and return statments here play important role.
     * @param arr
     */
    public static int[] permuatation(int[] arr) {
        int index=-1;
        for(int i=arr.length-2;i >= 0; i--){
            if(arr[i]  < arr[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            DataStructure.Arrays.Rotate.reverse(arr,0,arr.length-1);
            return arr;
        }
//        int temp=index+1;
//        for(int i=index+1;i<arr.length-1;i++){
//            if(arr[i] > arr[index]){
//                if(arr[temp] >= arr[i]){
//                    temp=i;
//                }
//            }
//        }
//        swap(arr,index,temp);
        for(int i=arr.length-1;i >= index+1;i--){
            if(arr[index] < arr[i]){
                DataStructure.Arrays.SortArrays.swap(arr,index,i);
                break;
            }
        }
        DataStructure.Arrays.Rotate.reverse(arr,index+1,arr.length-1);
        return arr;
    }

    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int index=-1;
        for(int i=A.size()-2;i >=0;i--){
            if(A.get(i) < A.get(i+1)){
                index = i;
                break;
            }
        }
        if(index == -1){
            Collections.reverse(A);
            return A;
        }
        for(int i=A.size()- 1;i >= index+1;i--){
            if(A.get(i) > A.get(index)){
                swap(A,i,index);
                break;
            }
        }

        return reverse(A,index+1,A.size()-1);
    }

    public static List<Integer> reverse(List<Integer> list, int start,int end){
        while(start < end){
            swap(list,start,end);
            start--;
            end--;
        }
        return list;
    }
    public static void swap(List<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,4};
        int[] result = {1,2,4,3};
        assertArrayEquals(result,permuatation(arr));
        arr = new int[]{2, 1, 5, 4, 3, 0, 0};
        result = new int[]{2,3,0,0,1,4,5};
        assertArrayEquals(result,permuatation(arr));
        arr = new int[]{4,3,2,1};
        result = new int[]{1,2,3,4};
        assertArrayEquals(result,permuatation(arr));
    }
}
