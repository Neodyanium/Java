package DataStructure.Arrays;

public class Stocks {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

    }

    public static int buyAndSell(int[] arr){
        int min=arr[0],max=0;
        for(int i=1;i<arr.length;i++){
            min  = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]-min);
        }
        return max;
    }
}
