package DataStructure.SlidingWindow.Problems;

public class MaximumPoints {

    public static void main(String[] args) {
        int[] arr = {4,8,3,1,9,8,6,9,2,1};
        System.out.println(maxPoints(arr,4));
    }

    /**
     *
     * @param arr
     * You are playing cards, you can pick continuously k cards from beginning or end not from middle
     * eg:  4,8,3,1,9,8,6,9,2,1 , if k=3 (4 12 3 or 1 2 9 or 12 4 1 or 2 1 4 etc)
     * @return
     */
    public static int maxPoints(int[] arr,int k){
        int leftSum = 0,rightSum = 0,maxSum=0;
        for(int i=0;i<k;i++){
            leftSum += arr[i];
        }
        maxSum = leftSum;
        int rightIndex = arr.length -1;
        for(int i=k-1;i >=0 ; i--){
            leftSum -= arr[i];
            rightSum += arr[rightIndex--];
            maxSum = Math.max(maxSum,(leftSum+rightSum));
        }
        return maxSum;
    }
}
