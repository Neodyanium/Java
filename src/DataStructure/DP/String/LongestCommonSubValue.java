package DataStructure.DP.String;

import java.util.Arrays;

import static DataStructure.Arrays.ConvertGrid.print;

public class LongestCommonSubValue {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "bdgek";

        String result = longestCommonSubsequenceOptimal(text1,text2);

        System.out.println(result);
    }

    /**
     * for strings abcde and bdgek this is how the dp array looks like, to get a String output we can use something similar to backtrack.
     *          a  b  c  d  e
     *      [0, 0, 0, 0, 0, 0]
     *    b [0, 0, 0, 0, 0, 0]
     *    d [0, 1, 1, 1, 1, 1]
     *    g [0, 1, 1, 1, 1, 1]
     *    e [0, 1, 2, 2, 2, 2]
     *    k [0, 1, 2, 2, 3, 3]
     *
     *    we will start from the index n m and check it the characters at the indexes match if they don't we check which element is maximum among
     *    the previous row(i-1,j) and previous column(i,j-1). we will move to the index which holds greater value. If the character is equal we
     *    have a match and we can add it to our string and move back exactly i-1 j-1 indexws we continue this till i and j are greate+r than 0.
     */


    public static String longestCommonSubsequenceOptimal(String text1,String text2){
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<m;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1]);
                }
            }
        }
        int i = n,j=m;
        String s = "";
        while(i > 0 && j >0){
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


    public static String longestCommonSubsequence(String text1, String text2) {
        String[] previous = new String[text2.length() + 1]; // The base conditions says whatever the value of j if the i is 0 the value is 0 ;
        String[] current = new String[text2.length() + 1];
        for(int i=0;i<=text2.length();i++){
            previous[i] = "";
            current[i] = "";
        }


        //abcde
        //ace
        for (int i = 1; i <= text1.length(); i++) {

            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    current[j] = text1.charAt(i-1) + previous[j - 1];
                else{
                    current[j] = previous[j].length() > current[j - 1].length() ? previous[j] : current[j-1] ;
                }

            }
//            System.out.println(Arrays.toString(current));
            previous =  current.clone();
        }
        return previous[text2.length()];
    }
}
