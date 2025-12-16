package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Count the total number of instances where a nums[i] > nums[j] & j > i till n
 * Eg: [5,3,2,4,1] so here are total (5,3) (5,2) (5,4) (5,1) (3,2) (3,1) (2,1) (4,1)
 */
public class CountInversions {


    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        int[] ans = new int[1];
        int count = merge(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    public static int merge(int[] arr,int low,int high) {
        int count = 0;
        if(low >= high){
            return count;
        }
        int mid = (low + high )/2;

        count += merge(arr,low,mid);

        count += merge(arr,mid+1,high);

         count += mergeArray(arr,low,mid,high);

         return count;
    }

    public static int mergeArray(int[] arr,int low,int mid,int high) {
        int count=0;
        List<Integer> list = new ArrayList<>();
        int i=low,j=mid+1;
        while(i <= mid && j<=high){
            if(arr[i] < arr[j]){
                list.add(arr[i++]);
            }else{
                list.add(arr[j++]);
                count = mid - low + 1;
            }
        }
        while(i <= mid){
            list.add(arr[i++]);
        }
        while(j <= high){
            list.add(arr[j++]);
        }


        for(i=low;i<=high;i++){
            arr[i] = list.get(i-low);
        }
    return count;
    }


}
