package DataStructure.DP.String;

import static DataStructure.Arrays.ConvertGrid.print;

/**
 * Given a string if you reverse it, you will have two Strings and since they are supposed to have a palindrome they will come out as the
 * Longest common subsequence
 *
 * consider eg: bbabcbcab reverse = bacbcbabb
 * You can easily see(I doubt that) the longest repeating Palindromic subsequence: babcbab
 */
public class LargestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        int result = lcsPalindromicSubsequence(s);
        System.out.println(result);
    }

    public static int lcsPalindromicSubsequence(String s){
        String reverse = "";
        for(int i=s.length()-1; i >= 0; i--){
            reverse += s.charAt(i);
        }
        return longestCommonSubsequence(s,reverse);
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return longestCommonSubVal(s,sb.toString());
    }



    public static String longestCommonSubVal(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // for (int i = 0; i < text1.length(); i++) {
        //     dp[i][0] = 0;
        // }
        // for (int i = 0; i < text2.length(); i++) {
        //     dp[0][i] = 0;
        // }

        //babad
        //dabab
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = text1.length();
        int j = text2.length();
        String s = "";
        while(i > 0 && j > 0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                s = text1.charAt(i-1) + s;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }

        }
        return s;
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
//        print(dp);
        return dp[text1.length()][text2.length()];
    }
}
