package DataStructure.DP.String;
import java.util.Arrays;

import static DataStructure.Arrays.ConvertGrid.print;

/**
 * Standard DP Question, consider eg:Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Here the largest common sequence is ace which has a length of 3.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String text1 = "abcba";
        String text2 = "abcbcba";
//        int result = lcs(text1.length() - 1, text2.length() - 1, text1, text2);
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//        int result2 = lcs2Memoized(text1.length(), text2.length(), text1, text2, dp);
        longestCommonSubsequence(text1,text2);
        int result = longestCommonSubsequenceOptimal(text1,text2);
        System.out.println(result);
    }

    private static int lcs(int index1, int index2, String text1, String text2) {
        /**
         * base case, I thought the base case where index is 0 can be written but is incorrect, as it's possible one of the indexes has become zero
         * and other is not. The one which has not reached the index 0, say index2 has not reached 0, then it can be checked for it's remaining indexes
         * if it matches with the index1 0 character.
         */

        if (index1 < 0 || index2 < 0)
            return 0;

        if (text1.charAt(index1) == text2.charAt(index2))
            return 1 + lcs(index1 - 1, index2 - 1, text1, text2);

        return Math.max(lcs(index1 - 1, index2, text1, text2), lcs(index1, index2 - 1, text1, text2));
    }

    private static int lcsMemoized(int index1, int index2, String text1, String text2) {
        /**
         * base case, I thought the base case where index is 0 can be written but is incorrect, as it's possible one of the indexes has become zero
         * and other is not. The one which has not reached the index 0, say index2 has not reached 0, then it can be checked for it's remaining indexes
         * if it matches with the index1 0 character.
         */

        if (index1 < 0 || index2 < 0)
            return 0;

        if (text1.charAt(index1) == text2.charAt(index2))
            return 1 + lcs(index1 - 1, index2 - 1, text1, text2);

        return Math.max(lcs(index1 - 1, index2, text1, text2), lcs(index1, index2 - 1, text1, text2));
    }

    /**
     * Shifting of indexes for the problem, for the indexes lesser than zero we return a 0 so instead of that we can simply return 0 at index 0
     * The passed value is index1 and index2 but the considered value would be index1-1, here we just need to increase the the size of the dp array
     */
    private static int lcs2(int index1, int index2, String text1, String text2) {
        /**
         * base case, I thought the base case where index is 0 can be written but is incorrect, as it's possible one of the indexes has become zero
         * and other is not. The one which has not reached the index 0, say index2 has not reached 0, then it can be checked for it's remaining indexes
         * if it matches with the index1 0 character.
         */

        if (index1 == 0 || index2 == 0)
            return 0;

        if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1))
            return 1 + lcs2(index1 - 1, index2 - 1, text1, text2);

        return Math.max(lcs2(index1 - 1, index2, text1, text2), lcs2(index1, index2 - 1, text1, text2));
    }

    private static int lcs2Memoized(int index1, int index2, String text1, String text2, int[][] dp) {
        /**
         * base case, I thought the base case where index is 0 can be written but is incorrect, as it's possible one of the indexes has become zero
         * and other is not. The one which has not reached the index 0, say index2 has not reached 0, then it can be checked for it's remaining indexes
         * if it matches with the index1 0 character.
         */

        if (index1 == 0 || index2 == 0)
            return 0;

        if (dp[index1][index2] != 0)
            return dp[index1][index2];

        if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1))
            return dp[index1][index2] = 1 + lcs2Memoized(index1 - 1, index2 - 1, text1, text2, dp);

        return dp[index1][index2] = Math.max(lcs2Memoized(index1 - 1, index2, text1, text2, dp), lcs2Memoized(index1, index2 - 1, text1, text2, dp));
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < text2.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        print(dp);
        return dp[text1.length()][text2.length()];
    }

    public static int longestCommonSubsequenceOptimal(String text1, String text2) {
        int[] previous = new int[text2.length() + 1]; // The base conditions says whatever the value of j if the i is 0 the value is 0 ;

        int[] current = new int[text2.length() + 1];
        System.out.println(Arrays.toString(current));
        //abcde
        //ace
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    current[j] = 1 + previous[j - 1];
                else
                    current[j] = Math.max(previous[j], current[j - 1]);
            }
            System.out.println(Arrays.toString(current));
            previous =  current.clone();
        }
        return previous[text2.length()];
    }
}
























