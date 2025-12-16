package DataStructure.Sorting;

import java.util.ArrayList;
import java.util.List;

import static Problems.Solution.print;

public class MergeSort {

    /**
     * Following function recursively divides the array from low to mid and mid to high, when the divided arrays can't be divided further they
     * are send to get merged.Since it is recursive when returned the bigger divisions will get merged.
     * @param arr
     * @param low
     * @param high
     */
    public static void mergeSort(int[] arr,int low,int high){
        if(low >= high) return;
        int mid = (low + high)/2;
        //1st half
        mergeSort(arr,low,mid);
        //2nd half
        mergeSort(arr,mid+1,high);
        //merging the 2 halfs
        merge(arr,low,mid,high);
    }

    public static void merge(int[] arr,int low,int mid,int high){
        int i=low,j=mid+1;
        List<Integer> list = new ArrayList<>();
        while(i <= mid && j <= high ){
            if(arr[i] < arr[j]){
                list.add(arr[i]);
                i++;
            }else{
                list.add(arr[j]);
                j++;
            }
        }
        while(i <= mid){
            list.add(arr[i++]);
        }
        while(j <= high){
            list.add(arr[j++]);
        }

        /**Main merging concept, the list is reinitialised every time, and sometimes the low can be much higher so we need to adjust the
         indexes for the list, so we don't go out of bounds
         */
        for(i=low;i<=high;i++){
            arr[i] = list.get(i-low);
        }
    }


    // Driver method
    public static void main(String[] args) {
        int[] arr = { 5,3,2,4,1 };
        print(arr);
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        print(arr);
    }
}

