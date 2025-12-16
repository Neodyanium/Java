package DataStructure.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {0,2,6,8,9};
        System.out.println(Arrays.toString(arr1) + " "+ Arrays.toString(arr2));
        mergeArrayOp2(arr1,arr2);
        System.out.println(Arrays.toString(arr1) + " "+ Arrays.toString(arr2));
    }

    /**
     * This shares similar logic to shell short, keep decreasing the gap between left and right.
     * Algo: 1) Calculate the gap: (size1 + size2 / 2 ) + (size1 + size2) % 2;
     * 2) Run a while loop while gap > 0
     * 3) Initialise a left pointer to zero & right pointer left + gap and run a while loop with right less than total length (size1 +size2)
     * 4) Now we are going to check if value at left pointer is greater than the value at right pointer we will swap them and move forward. We are
     * incrementing both left and right and when the array1 is ends left might point in array2.
     * 5) At any point the left and right pointers can be at : a)left pointer in array 1 and right pointer in array 2
     *                                                         b)left pointer in array 2 and right pointer in array 2
     *                                                         c)left pointer in array 1 and right pointer in array 1(small gap allows it)
     * 6) Manage this positions using if else statements so, we can swap them properly.
     * 7) Add a condition if gap == 1 break, as gap can't be further shrink, add another where you update the gap to half (ceiled if double)
     * @param arr1
     * @param arr2
     */
    private static void mergeArrayOp2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int gap = (n+m)/2 + (n+m)%2;
        while(gap > 0){
            int left=0,right=gap;
            while(right < n+m) {
                //left in array1, right in array2
                if (left < n && right >= n) {
                    swapIfGreater(arr1,arr2,left,right-n);
                }// left in array 2, right in array2
                else if (left >= n) {
                    swapIfGreater(arr2,arr2,left-n,right-n);
                }// Both in array 1
                else {
                    swapIfGreater(arr1,arr1,left,right);
                }
                right++;
                left++;
            }
            if(gap==1) break;
            gap = gap/2 + gap % 2;
        }
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int left, int right) {
        if(arr1[left] > arr2[right]){
            int temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }
    }

    /**
     * Simple approach since it's sorted we can check if the number at the end of array1 is it bigger than the number at the start of array 2
     * if yes we can swap them and take the respective pointers bacck and front at any point if the number of aaray1 is smaller than array2 then
     * we can conclude we have all the elements that were not in proper order
     * @param arr1
     * @param arr2
     */

    private static void mergeArrayOp1(int[] arr1, int[] arr2) {
        int l = arr1.length-1;
        int r = 0;
        while(true){
            if(arr1[l] > arr2[r]){
                int temp = arr1[l];
                arr1[l] = arr2[r];
                arr2[r] = temp;
            }else{
                break;
            }
            l--;
            r++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
