package DataStructure.DP.String;

import static DataStructure.Arrays.ConvertGrid.print;

public class LargestCommonSubString {
    /**
     * In the last problem what we did solved for a subsequence but here we want a contiguous array. We can use the similar tabulation approach
     * what we did in the tabulation was looked back was there any substring whose length is greater and checked for previous row and column,
     * here also need to do the same but only for the if the previous index  was a match
     */

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcd";
        int l = largestCommonSubstring(s,t);
        System.out.println(l);
    }


    /**
     * If strings are abcd and abed
     *  [0, 0, 0, 0, 0]
     * [0, 1, 0, 0, 0]
     * [0, 0, 2, 0, 0]
     * [0, 0, 0, 0, 0]
     * [0, 0, 0, 0, 1]
     * You can see well all the matched characters and the first to match is 1, if they are consecutively matched it increases
     * If both strings are abcd
     *
     * [0, 0, 0, 0, 0]
     * [0, 1, 0, 0, 0]
     * [0, 0, 2, 0, 0]
     * [0, 0, 0, 3, 0]
     * [0, 0, 0, 0, 4]
     */

    public static int largestCommonSubstring(String text1,String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int max = 0;
        for(int i = 1;i<= text1.length(); i++){
            for(int j=1; j<= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        print(dp);
        return max;
    }

}
