package DataStructure.DP.OneD;


public class NonAdjacentSum {

    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int ans = sum(arr,arr.length-1,0,0);
        int[] dp = new int[arr.length];
//        int ans2 = sum(arr,arr.length-1,dp);
        int ans3 = sumTab(arr,dp);
        int ans4 = sumOptimal(arr);
        System.out.println("Maximum:"+ans4);
//        System.out.println(Arrays.toString(dp));
    }
    // More clear recursion approach with Memoization
    public static int sum(int[] arr,int index,int[] dp){
        if(index == 0){
            return arr[index];
        }
        if(index < 0){
            return 0;
        }
        if(dp[index] != 0){
            return dp[index];
        }

        int pick = arr[index] + sum(arr,index-2,dp);

        int notPick = 0 +  sum(arr,index-1,dp);

        return dp[index] = Math.max(pick,notPick);
    }
    //2 1 4 9
    public static int sumTab(int[] arr,int[] dp){
        dp[0] = arr[0];
        //It was an error to consider this as the base condition don't include index==1,dp[1] = arr[0];
        //So the bottom up approach will start with an index 1
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];
            if(i>1)
                pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[arr.length-1];
    }

    public static int sumOptimal(int[] arr){
        int prev = arr[0]; //(i-2)
        int secondPrev = 0; //(i-1)
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];
            if(i > 1){
                pick += secondPrev;
            }
            int notPick = prev;
            secondPrev=prev;
            prev = Math.max(pick,notPick);

        }
        return prev;
    }

    public static int sum(int[] arr,int index,int sum,int max){
        //if the number reaches the index zero we can't go further back so we can add it to the sum and return.
        if(index == 0){
            sum += arr[index];
            return sum;
        }
        //if the index is 1 the recursive call will become negative in this case we can't add anything so,we return existing sum.
        if(index < 0){
            return sum;
        }


        //we have chosen an index we will add it to our sum,and now we will check the non-adjacent numbers in the array
        int left = sum(arr,index-2,sum+arr[index],max);
        //we have not chosen the index we will check the sum from the index-1 index
        int right = sum(arr,index-1,sum,max);

        //The above is very similar and popular use case of pick non pick

        return Math.max(left,right);
    }
}
