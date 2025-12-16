package DataStructure.SlidingWindow.Problems;

/**
 * calculate the subarrays for sum  <= goal and calculate the subarrays for sum <= goal - 1 and then you can subtract
 */
public class TotalBinarySubarrayWithSumK {

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        System.out.println(totalBinarySubarray(arr,2));
    }

    public static int totalBinarySubarray(int[] arr,int goal){
        return subarrays(arr,goal)-subarrays(arr,goal-1);
    }

    public static int subarrays(int[] arr,int goal){
        if(goal < 0) return 0;
        int l=0,r=0,sum=0,count=0;
        while(r < arr.length){
            sum+=arr[r];
            while(sum > goal){
                sum -= arr[l];
                l++;
            }
            count += r- l +1;
            r++;
        }
        return count;
    }

}
