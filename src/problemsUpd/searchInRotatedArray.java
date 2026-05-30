package problemsUpd;

public class searchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {3,1};
        int target = 1 ;
        int index = search(arr,target);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        int index = -1, low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (high - low) / 2 + low;

            if(nums[mid] == target){
                index = mid;
                break;
            }

            if(nums[low] < nums[mid]){
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }
        }
        return index;
    }
}
