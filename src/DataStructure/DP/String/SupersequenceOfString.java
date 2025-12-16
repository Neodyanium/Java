package DataStructure.DP.String;

import static DataStructure.Arrays.ConvertGrid.print;

/**
 * There are two Strings you need a provide a superset string so that both strings can be formed from it.
 *eg: brute, groot => bgruoote
 * bleed, blue => bleued
 *
 * The approach is very similar to print lcs, you backtrack and keep adding to the string based on certain conditions, if both the characters
 * at index match you have a common character so, you add it only once. If they don't match you can go previous row or previous column whichever
 * is max. When moving if you are going to previous row add the current row element and move back same with  the column if moving back a column
 * add the current column element and move back. If one of the indexes is 0. Add the remaining elements of other index which has not become 0.
 *
 */
public class SupersequenceOfString {

    public static void main(String[] args) {
        String result = sos("brute","groot");
        System.out.println(result);
        String n ="";
    }

    /** The following is the dp array for the lcs, it helps to see how path is traced and string is formed
     *       g  r  o  o  t
     *   [0, 0, 0, 0, 0, 0]
     * b [0, 0, 0, 0, 0, 0]
     * r [0, 0, 1, 1, 1, 1]
     * u [0, 0, 1, 1, 1, 1]
     * t [0, 0, 1, 1, 1, 2]
     * e [0, 0, 1, 1, 1, 2]
     */

    public static String sos(String text1,String text2){
        int n = text1.length();
        int m= text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        print(dp);
        String result = "";
        int i = n , j= m;
        while( i > 0 && j > 0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                result = text1.charAt(i-1) + result;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                result = text1.charAt(i-1) + result;
                i--;
            }else{
                result = text2.charAt(j-1) + result;
                j--;
            }
        }
        while(i > 0){
            result = text1.charAt(i-1) + result;
            i--;
        }
        while(j > 0){
            result = text2.charAt(j-1) + result;
            j--;
        }
        return result;
    }


}
