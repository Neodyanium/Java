package DataStructure.Sorting;

import static Problems.Solution.print;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,1,9,3,8,7};
        print(arr);
        insertionSort(arr);
        System.out.println("Sorted array:");
        print(arr);
    }

    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){

            int j=i-1;
            int temp = arr[i];

            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;

        }
    }


}
