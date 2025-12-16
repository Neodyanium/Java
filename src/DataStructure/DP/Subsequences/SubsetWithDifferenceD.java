package DataStructure.DP.Subsequences;

/**
 * Problem: You have to return the count of total subsets whose sum of difference will be equal to D. If S1 is the subset with sum bigger than that
 * of S2
 *
 * Solution: S1-S2= D , also S1 = TotalSum - S2. i.e. TotalSum-S2-S2 = D and S2 = TotalSum - D / 2.
 * So we need to find if the target subset TotalSum - D/2 exists and count them.
 */
public class SubsetWithDifferenceD {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        int d = 0;
        int ifExists = getDiffTab(arr,d);
        System.out.println(ifExists);
    }

    public static int getDiffTab(int[] arr,int d){
        int totalSum = 0;
        for(int n:arr){
            totalSum += n;
        }
        if(totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        int[][] dp = new int[arr.length][((totalSum -d)/2) +1];
        return minDiff(arr,(totalSum -d)/2,dp);
    }
    public static int getDiff(int[] arr,int d){
        int totalSum = 0;
        for(int n:arr){
            totalSum += n;
        }
        if(totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        return getDiff(arr,d,(totalSum-d)/2,arr.length-1);
    }

    public static int getDiff(int[] arr,int d,int sum,int index){
        int mod = (int) 1e9 + 7;
        if(index == 0){
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || arr[0] == sum) return 1;
            return 0;
        }
        int notTake = getDiff(arr,d,sum,index-1);

        int take = 0;
        if(arr[index] <= sum){
            take = getDiff(arr,d,sum-arr[index],index-1);
        }
        return (take + notTake) % mod;
    }

    public static int minDiff(int[] arr,int target,int[][] dp){
        int mod = (int) 1e9 + 7;
        //Very Important to think how to initialise with the base conditions
        if(arr[0] == 0) dp[0][0] = 2; //At index 0 if the target is 0 and also the arr[0] = 0 then return 2
        else dp[0][0] = 1;  // element at arr[0] is not 0 so and target is still 0 at index 0, so there 1 way if we don't select the no. at arr[0]

        if(arr[0] != 0 && arr[0] <= target) //if index is 0 and the target is equal to arr[0] then there is one way.
            dp[0][arr[0]] = 1;

        for(int index = 1;index < arr.length; index++){
            for(int k=0; k<=target; k++){
                int notTake = dp[index-1][k];
                int take = 0;
                if(arr[index] <= k){
                    take = dp[index-1][k-arr[index]];
                }
                dp[index][k] = (notTake + take) % mod;
            }
        }
        return dp[arr.length-1][target];
    }

}
