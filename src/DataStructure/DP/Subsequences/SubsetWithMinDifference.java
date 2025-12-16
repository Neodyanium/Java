package DataStructure.DP.Subsequences;

/**
 * The problem is we have to divide the array into 2 subsets such that the sum of absolute differences between them is minimum
 * Eg: {3,2,7} different subs can be => {3} and {2,7} absolute difference between the sum =>6
 * {3,7} {2} absolute diff is => 8
 * {3,2} {7} AD => 2 (also happens to be the result)
 */
public class SubsetWithMinDifference {


    public static void main(String[] args) {
        int[] arr = {3,9,7,3};
        int target = 0;
        for(int n:arr){
            target += n;
        }
        int min = miDiff(arr,target);
        System.out.println(min);
    }

    /**
     * The Tabulated code to divide the array into two subset with equal some, has a significant last row.
     * The dp array itself is made such that at any indexes we can check what target can be achieved at indexes 1 to target.
     * Now with the current problem what we will ideally require is a minimum sum, so if we can divide the array into to equals that would be great
     * consider the example: {3,2,7} if we calculate the total sum of the array we can make it our target, so we will have all the targets ranging from
     * 0 to 12 and whether it is possible to reach them, so if a target can be achieved that means the subset with that particular target sum exists
     * now we have a subset with some sum and we can calculate the sum of remaining subset by subtracting the subset sum from total sum
     * consider the sum possible turn out to be 5, so other subset will be 12-5 i.e. 7. so we get calculate the difference between them.
     * Subset sum and (total - subset Sum)
     */
    public static int miDiff(int[] arr,int target){

        boolean[][] dp = new boolean[arr.length][target+1];
        for(int index = 0; index < arr.length;index++){
            dp[index][0] = true;
        }
        if(arr[0] <= target){
            dp[0][arr[0]] = true;
        }

        for(int index = 1;index<arr.length;index++){
            for(int k=1;k<=target/2;k++){
                boolean notTake = dp[index-1][k];

                boolean take = false;
                if(arr[index] <= k){
                    take = dp[index-1][k-arr[index]];
                }

                dp[index][k] = take || notTake;
            }
        }

        int min = 100000;
        int n = arr.length;
        for(int k = 0; k <= target/2; k++ ){   //You can go till half the targets as the total - k are bound to repeat
            if(dp[n-1][k]){
                min = Math.min(min,Math.abs(k -  (target - k)));
            }
        }
        return min;
    }
}
