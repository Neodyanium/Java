package DataStructure.BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {4,4,3,2,1};
        System.out.println(search(arr,3,0,1));

    }

    public static int search(int[] arr,int target,int start, int end){
        while(start < end){
            int mid = (end -start)/2;
            if(arr[mid] == target)
                return mid;
            else if(target  < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return end;
    }


    public static int search(int[] arr,int target){
        int start = 0,end = arr.length-1;
        while(start < end){
            int mid = (end -start)/2;
            if(arr[mid] == target)
                return mid;
            else if(target  < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
