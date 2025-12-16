package DataStructure.Arrays;


import java.util.Arrays;

public class SortArrays {

    public static void main(String[] args) {
        int[] arr = {2,2,1,0,2,1,2,1,0,0,1,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr){
        int zCount=0,oCount=0;
        for (int j : arr) {
            if (j == 0) zCount++;
            else if (j == 1) oCount++;
        }
        for(int i=0;i<zCount;i++){
            arr[i] = 0;
        }
        for(int i=zCount;i<zCount+oCount;i++){
            arr[i] = 1;
        }
        for(int i=zCount+oCount;i<arr.length;i++){
            arr[i] = 2;
        }
    }

    // 0000000000011111111111<102101021021210102>22222222
    //            low(first-1) mid(unsorted part) high(first sorted -2)

    /**
     * The conditions are easily understandable but how many times are we iterating
     * The iterating variable is mid variable we are while(mid < last) we keep checking if mid is 0 1 or 2 and perform operations
     * @param arr
     */
    public static void Sort012(int[] arr) {
        int low=0,mid=0,high=arr.length-1;
        while(mid<high){
            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }else{
                swap(arr,mid,high);
                high--;
            }
        }
    }
    public static void  swap(int[] arr,int id1,int id2){
        int temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }


}
