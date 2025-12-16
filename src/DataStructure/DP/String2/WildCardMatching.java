package DataStructure.DP.String2;


import java.util.Arrays;

public class WildCardMatching {

    public static void print(boolean[][] arr){
        for(boolean[] ar:arr)
            System.out.println(Arrays.toString(ar));
    }

    public static void main(String[] args) {
        String s1 = "ab*cd";
        String s2 = "abdefcd";
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        boolean flag = matchTabulation(s1,s2);
        System.out.println(flag);
    }

    /**
     * Starting out we check both the Strings from the last indexes and try to match, if both the characters match we can successively move back
     * indexes i and j. We can also move back both indexes if character at String1 is ? as it can match any character. Now if the '*' character
     * appears we can match any number of characters from 0 to any number of characters. So simply added a condition if the character encountered is
     * '*' we will consider it to be 0 and move back 1 index (i-1,j) this then will work with the new index and matching. Or we will consider the
     * * to be matching character and so keep the i same and deduct j (i,j-1). So this will be trying out all possible combinations.
     * Eg: s1 = ab*cd s2  = abdejcd
     * First if is executed twice, then we reach j and *. From here the dej will match * and remaining characters of s2  match the remaining characters
     */

    public static boolean match(int i, int j,String s1,String s2){
        /**
         * Base conditions:
         * if both i and j indexes became negative it means they matched at 0 index and reached negative so, we can return true.
         * if i is exhausted and j has still not it means that we couldn't find a match for element at j so we can safely return false
         * if j is exhausted and i has still not, we could have simply returned false, but if there are any * in the string then it can match
         * with 0 characters too, so if you have only * remaining in the String you can return true else return false.
         */
        if(i < 0 && j < 0)
            return true;

        if( i < 0 && j >= 0)
            return false;

        if(j < 0 && i >= 0){
            for(int ii=0; ii<=i; ii++)
                if(s1.charAt(ii) != '*')
                    return false;
            return true;
        }

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
            return match(i-1,j-1,s1,s2);

        if(s1.charAt(i) == '*')
            return match(i-1,j,s1,s2) || match(i,j-1,s1,s2);

        return false;
    }

    // Memoized plus 1based index
    public static boolean matchMemo(int i,int j,String s1,String s2,int[][] dp){
        if(i == 0 && j == 0)
            return true;
        if(i ==0){
            return false;
        }
        if(j == 0){
            //here index i is not zero, and it's 1 based indexing so k starts at k=1
            for(int k=1; k<=i; k++)
                if(s1.charAt(k) != '*')
                    return false;
            return true;
        }

        if(dp[i][j] != 0)
            return dp[i][j] == 1;

        boolean m = false;
        if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?') {
            m = matchMemo(i - 1, j - 1, s1, s2, dp);
            dp[i][j] = m ? 1 : 0;
            return m;
        }
        boolean nm = false;
        if(s1.charAt(i-1) == '*') {
            nm = matchMemo(i - 1, j, s1, s2, dp) || matchMemo(i, j - 1, s1, s2, dp);
            dp[i][j] = nm ? 1 : 0;
            return nm;
        }

        dp[i][j] = 0;
        return false;
    }

    public static boolean matchTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int j = 1; j <= m; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int k = 1; k <= i; k++){
                if(s1.charAt(k-1) != '*'){
                    flag =false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for(int i=1;i <=n ; i++){
            for(int j=1; j<=m ;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(s1.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
//        print(dp);
        return dp[n][m];
    }

}
