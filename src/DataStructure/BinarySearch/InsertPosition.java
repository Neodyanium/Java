package DataStructure.BinarySearch;

public class InsertPosition {

    public static void main(String[] args){
        int[] arr = {1,2,4,7};
        int target = 6;
        int index = position(arr,target);
        System.out.println(index);
    }

    public static int position(int[] arr,int target){
        int start = 0,end = arr.length;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }else if(target < arr[mid]){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        return start;
    }
}
