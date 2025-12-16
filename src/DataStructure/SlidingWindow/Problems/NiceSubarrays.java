package DataStructure.SlidingWindow.Problems;

public class NiceSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,4,5,1,2};
        System.out.println(niceSubarrays(arr,1));
    }

    //we converted it to the similar problem
    public static int niceSubarrays(int[] arr,int goal){
        return subarrays(arr,goal)-subarrays(arr,goal-1);
    }

    public static int subarrays(int[] arr,int goal){
        if(goal < 0) return 0;
        int l=0,r=0,sum=0,count=0;
        while(r < arr.length){
            sum+=arr[r] % 2;
            while(sum > goal){
                sum -= arr[l] % 2;
                l++;
            }
            count += r- l +1;
            r++;
        }
        return count;
    }
}
