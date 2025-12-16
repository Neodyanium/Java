package DataStructure.Arrays;

import java.util.Arrays;

import static DataStructure.Arrays.SortArrays.swap;

public class MissingRepeatingNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5};
        int[] result = missingAndRepeatedNumber2(arr);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Approaches:
     * 1) Hashing (since 1 to N): If the value is 0 it's missing and if value is 2 then the repeated number
     * 2) Mathematics: Consider X as repeating number and Y as missing number
     * Calculate sum from 1 till n and subtract it from sum of array elements so all the numbers present cancels out and only missing and repeating number stays
     * i.e. 1,2,3,4,6,1 - 1,2,3,4,5,6  => 1 - 5 (X is repeated and 5 is missing) i.e. X-Y= -4
     * Calculate sum of square till n and subtract it from sum of square of array elements,
     * 1^2 - 5^2 , X^2 - Y^2 = -24 , solved to get X + Y = 6, with the two equations solving both equations we can find x= repeating and y=missing
     *
     * @param arr
     * @return
     */

    public static int[] missingAndRepeatedNumber(int[] arr){
        int i=0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        System.out.println("Sorted Array:" + Arrays.toString(arr));
        for(int j=0;j<arr.length;j++){
            if(arr[j] != j + 1){
                return new int[]{arr[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }


    public static int[] missingAndRepeatedNumber2(int[] arr) {
        int n = arr.length;
        int sumN = (n * (n + 1 ))/2;
        int sumSqN = (n * (n+1) * (2*n + 1))/6;
        int sum=0,sumSq=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            sumSq += arr[i] * arr[i];
        }
        int val1 = sum - sumN; // x-y
        int val2 = sumSq - sumSqN; // x^2 - y^2
        int sums = val2/val1; // x+y
        int repeated = (sums+val1)/2; // (x+y) +(x-y)/2  => (2x)/2;
        int missed = sums - repeated ; //(x + y - x)
        return new int[]{repeated,missed};
    }
 }
