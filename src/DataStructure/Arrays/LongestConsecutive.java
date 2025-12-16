package DataStructure.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] arr = {10,12,13,4,5,10,12,11,13,14,6,7,10,8,15};
        int ans = longestSubsequenceO(arr);
        System.out.println(ans);
    }

    /**N * NlogN
     * 1)Sort
     * 2) Check for 3 conditions after creating a last value variable which stores last value, one count variable and one max
     * a) if current-1 == lastValue then we can increase the count
     * b) if current == lastValue then we don't need to do anything (after sorting repeated values will be at the front) and since we are looking for
     * subsequences we can avoid it.
     * c) if current != lastValue it clearly means that it is not an increasing sequence so update the last value to current and reset the count to 1.
     * @param arr
     * @return
     */
    public static int longestSubsequence(int[] arr) {
        int lastSmall = Integer.MIN_VALUE;
        int count=1,max=1;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]-1 == lastSmall){
                count += 1;
                lastSmall = arr[i];
            }else if(arr[i] != lastSmall){
                count=1;
                lastSmall = arr[i];
            }
            max = Math.max(count,max);
        }
    return max;
    }

    /**
     * O(N) + O(N + at Max(N)) = 3N
     * storing in set + iterating over each set elem N & if it is the start of sequence go till it's failure
     * Here we are using an n extra space with set
     * We now iterate over the elements of the set and check if the element had a number less than it (If there is we can say that we are in middle
     * of a sequence and we won't like to count from here.
     * Keep checking until n-1 element is not present, it means we are at the start of sequence. Use a while loop and count till n+1 elements exists
     * when the conditions become false, we can update the max.
     * @param arr
     * @return
     */

    public static int longestSubsequenceO(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int count = 1,max=1;
        for(int n:arr){
            set.add(n);
        }
        for(int n:set){
            if(!set.contains(n-1)){
                int elem = n;
                count = 1;
                while(set.contains(elem+1)) {
                    count++;
                    elem++;
                }
            }
            max = Math.max(count,max);
        }
        return max;
    }
}
