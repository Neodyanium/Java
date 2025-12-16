package DataStructure.DP.Subsequences;

import java.util.Arrays;

public class SubsetSumK {

    public static void main(String[] args) {
        int target = 4;
        int[] arr = {6,1,2,1};

        boolean ifExist = sumEqualsKRecursion(arr,arr.length-1,target);
        //You should make the dp array according to the constraints provided
        int[][] dp = new int[arr.length][target+1];  //It means that it index will take values from 0 till n-1 and target can be 0 till target
        for(int[] array:dp){
            Arrays.fill(array,-1);
        }
        boolean ifExist2 = sumEqualsKMemoized(arr,dp,target,arr.length-1);

        boolean ifExist3 = sumEqualsKTabulation(arr,target);
        System.out.println(ifExist3);

//        boolean ifExists4 = sumEqualsKOptimal(arr,target);
//        System.out.println(ifExists4);
    }


    /**
     *Proper recurrence written, you need to return the stuff in the
     */
    public static boolean sumEqualsKRecursion(int[] arr,int index,int target){
        if(target == 0)
            return true;

        if(index == 0){
            return arr[0] == target;
        }

        boolean notTake = sumEqualsKRecursion(arr,index-1,target);

        boolean take = false;
        if(target >= arr[index]){
            take = sumEqualsKRecursion(arr,index-1,target-arr[index]);
        }

        return notTake || take;
    }

    public static boolean sumEqualsKMemoized(int[] arr,int[][] dp,int target,int index){
        if( target == 0) return true;
        if(index == 0)
            return arr[0] == target;
        if(dp[index][target] != -1){
            return dp[index][target] == 1 ;
        }

        boolean notTake = sumEqualsKMemoized(arr,dp,target,index-1);

        boolean take = false;
        if(target >= arr[index]){
            take = sumEqualsKMemoized(arr,dp,target-arr[index],index-1);
        }

        dp[index][target] = (notTake || take) ? 1 : 0;
        return take || notTake;
    }

    private static boolean sumEqualK(int[] arr,int index, int target) {
        if(index == arr.length){
            return target == 0;
        }
        if(target == 0){
            return true;
        }

        return sumEqualK(arr,index+1,target-arr[index]) || sumEqualK(arr,index+1,target);

    }

    public static boolean sumEqualsKTabulation(int[] arr,int target){
        boolean[][] dp = new boolean[arr.length][target+1];
        if(arr[0] <= target)
            dp[0][arr[0]] = true;
        for(int index = 0;index<arr.length;index++){
            dp[index][0] = true;
        }
        for(int index=1;index<arr.length;index++){
            for(int k = 1;k<=target;k++){
                boolean notTake = dp[index-1][k];

                boolean take = false;
                if(k >= arr[index]){
                    take = dp[index-1][k-arr[index]];
                }

                dp[index][k] = notTake || take;
            }
        }
        for(boolean[] a:dp)
            System.out.println(Arrays.toString(a));
        return dp[arr.length-1][target];
    }

    public static boolean sumEqualsKOptimal(int[] arr,int target){
        boolean[] dp = new boolean[target + 1];
        dp[arr[0]] = true;
        dp [0] = true;
        for(int index = 1;index<arr.length;index++){
            boolean[] current = new boolean[target+1];
            current[0] = true;
            for(int k = 1; k <= target; k++ ){
                boolean notTake = dp[k];

                boolean take = false;
                if(k >= arr[index]){
                    take = dp[k-arr[index]];
                }

                current[k] = notTake || take;
            }
            dp = current;
        }
        return dp[target];
    }
}
