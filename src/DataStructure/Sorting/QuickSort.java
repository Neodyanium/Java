package DataStructure.Sorting;

import static DataStructure.Arrays.SortArrays.swap;
import static Problems.Solution.print;

public class QuickSort {

    /**
     * Consider array for example: 4 6 2 1 9 3 8 7
     * IMP: 1) Pick up a pivot element and place it in the correct place in the sorted array.(Pick first or last or random)
     * 2) How to know the correct place? Place the elements smaller than itself to the left and bigger than it to the right
     * so: 2 1 3 4 6 9 8 7 (Pivot 4 is at the correct place) we can clearly observe we can do the same for left Subarray from pivot and right Subarray from pivot
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {4,6,2,1,9,3,8,7};
        print(arr);
        quickSort(arr,0,arr.length-1);
        System.out.println("\nSorted array");
        print(arr);
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low < high){
            int pivotIndex = sort(arr,low,high);

            quickSort(arr,low,pivotIndex-1);

            quickSort(arr,pivotIndex+1,high);
        }
    }

    //4,6,2,1,9,3,8,7
    public static int sort(int[] arr,int low,int high){
        int pivot = arr[low];
        int i=low ,j=high;
        while(i < j){
            while(i < high && arr[i] <= pivot){
                i++;
            }
            while(j > low && arr[j] > pivot){
                j--;
            }
            //Imp step to remember we ony swap when they haven't cross, if they have crossed they are already at the point where numbers are alredy
            //in proper position with pivot
            if(i<j)
                swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
}
