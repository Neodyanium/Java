package DataStructure.DP.String;

/**
 * The problem is we have a string, what are the minimum number of additions that you can do so that the entire string becomes Palindrome
 *
 * Solution: If you look at the String look out for the largest palindromic subsequence, since we want the entire string to be palindrome
 * we won't change the biggest palindromic subsequence, now whatever the elements remain we will need the same number of additions to make the
 * entire String a palindrome.
 * Eg:abcaa : lcs = aaa or aca
 * consider for aaa, this large palindromic subsequence will stay, since there is a bc between the first two a's we make the palindrome we will add
 * bc in reverse so abcacba so that it becomes a palindrome.
 * if we consider aca we have b between the a and c we add to just before the ending so it's a c a => a b c b a, we also have a between c and a
 * so will need to add the same before the c so a b c b a => a b a c a b a
 */
public class MinimumChangeToPalindrome {

    public static void main(String[] args) {
        String s = "abcaa";
        int min = minimumAdditions(s);
        System.out.println(min);
    }

    public static int minimumAdditions(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1;i >= 0; i--)
            sb.append(s.charAt(i));
        String t = sb.toString();
        return s.length() - lcs(s,t);
    }

    public static int lcs(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
