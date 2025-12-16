package DataStructure.DP.Subsequences;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        int ways = getWays(arr,target,arr.length-1,0);
        System.out.println(ways);
    }


    /**
     * Problem is you can assign any signs to the array elements, and you would want the sum of total elements to target. So how many of such
     * target elements can you achieve.
     *
     * now now now, You can see it as a problem where you can see them as separate subsets,
     * consider this array as example arr = {1,2,3,1}, {2,3} is subset and {1,1} is a subset and there difference is 3. So if we assign the sign +
     * to the 1st Subset and - to the other and accumulate them it's 3. So the same problem can be solved by using S1-S2 = D (where D is 3)
     * For that thing we calculated the formula S2 = ( total - D ) / 2 (Using S1-S2 = D && S1 + S2 = Total)
     * So the problem is reduced to count how many times target subset appears.
     *
     */

    public static int getWays(int[] arr,int target,int index,int sum){
        if(index == 0){
            if(arr[index] + sum == target || (-1) *arr[index] + sum == target){
                return 1;
            }
            return 0;
        }

        int positive = getWays(arr,target,index-1,sum+arr[index]);

        int negative = getWays(arr,target,index-1,sum + (-1) *(arr[index]));

        return positive+negative;
    }


}
