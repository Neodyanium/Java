package DataStructure.DP.String;

import static DataStructure.Arrays.ConvertGrid.print;

/**
 * You have 2 Strings s1 and s2 you can perform any number of deletions and insertions to s1 so, it becomes equal to s2
 * eg: s1 = abcd , s2 = anc , maxOperations delete everything and insert all from s2 => max (n+m) operations
 *
 * Solution: what I can see is if we find the longest common subsequence we won't need to remove those and it will reduce the operations,
 * once you find the number of common subsequence you can subtract it from s1 and s2 length and then add them up
 */
public class StringOperations {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
        int lcs = longestCommonSubsequence(s1,s2);
        int operations = s1.length()-lcs  + s2.length()-lcs;
        System.out.println(operations);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
