package DataStructure.SlidingWindow;

import java.util.Arrays;

/**
 * Problem: You have string consisting of only three letters, return total substrings containing all three Characters
 *
 */
public class TotalSubarray {
    public static void main(String[] args) {
        System.out.println(totalSubstrings("aabbcc"));
        //aabbc
        //aabbcc
        //abbc
        //abbcc
        System.out.println(totalSubstrings("bbacba"));
    }

    public static int totalSubstrings(String s) {
        int[] arr = {-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a'] = i;
            if(arr[0] != -1 && arr[1] != -1 && arr[2] != -1){
                count = count + 1 + Arrays.stream(arr).min().getAsInt();
            }
        }
        return count;
    }
}

