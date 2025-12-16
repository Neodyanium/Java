package DataStructure.DP.String2;

/**
 * You are given two strings, how many strings can be subsequences of String2 is present in String 1.
 * eg: bagbbag and bag
 * Total subs = 5
 */
public class DistinctSubsequences {


    public static void main(String[] args) {
        String s = "bagbbag";
        String t = "bag";
        int res = distinctSubsCount(s.length() - 1, t.length() - 1, s, t);
        int r = distinctSubsCountTabulation(s, t);
        int result = distinctSubsCountOptimal(s,t);
        System.out.println(result);
    }


    /**
     * We are starting at the indexes of the last element of both the Strings, we check if the characters are matching at the current index, if so
     * we will choose it and both i and j will be reduced by 1. if it doesn't match we will reduce i th index by 1. It keeps checking to find the
     * matching character. So if the ith index ran out and j is still at index >= 0 then we are sure there is no subsequence as String 2. Now while
     * when the characters match, there could also be a chance that there are other matching characters further left of String so we check for the
     * matching characters + what if we don't choose it and look for another character match.This can be easily understood by the recurrence relationship
     * used below.
     */
    public static int distinctSubsCount(int i, int j, String s, String t) {
        if (j < 0) return 1;

        if (i < 0) return 0;

        if (s.charAt(i) == t.charAt(j))
            return distinctSubsCount(i - 1, j - 1, s, t) + distinctSubsCount(i - 1, j, s, t);

        return distinctSubsCount(i - 1, j, s, t);
    }

    /**
     * You can use the one based indexing so that you can write tabulation more easily
     */
    public static int distinctSubsCount1b(int i, int j, String s, String t) {
        if (j == 0)
            return 1;
        if (i == 0)
            return 0;
        if (s.charAt(i - 1) == s.charAt(j - 1))
            return distinctSubsCount1b(i - 1, j - 1, s, t) + distinctSubsCount1b(i - 1, j, s, t);
        return distinctSubsCount1b(i - 1, j, s, t);
    }

    public static int distinctSubsCount1bMemoized(int i, int j, String s, String t, int[][] dp) {
        if (j == 0)
            return 1;
        if (i == 0)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        if (s.charAt(i - 1) == s.charAt(j - 1))
            return dp[i][j] = distinctSubsCount1b(i - 1, j - 1, s, t) + distinctSubsCount1b(i - 1, j, s, t);
        return dp[i][j] = distinctSubsCount1b(i - 1, j, s, t);
    }

    /**
     * Tabulation is simple, you create and n+1 x m+1 array due to 1 based indexing, make initialization according to base conditions,
     * we loop from i=0 to n and j = 0 the values will all be 1 when j=0
     * similarly loop from j=1 (j=0 is handled already not to make mistake here) to m values are 0. Base conditions done.
     * Make 2 for loops and copy the recursion just replace the recursion call with dp array
     */

    public static int distinctSubsCountTabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    public static int distinctSubsCountOpt(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] previous = new int[m + 1];
        previous[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] current = new int[m + 1];
            current[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    current[j] = previous[j - 1] + previous[j];
                else
                    current[j] = previous[j];
            }
            previous = current;
        }
        return previous[m];
    }

    /**
     *  Most optimised Solution using single array, it depends on the current element and a previous element, so if we just go from right to left
     *  we can use the same array for previous elements and current element.
     */


    public static int distinctSubsCountOptimal(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] previous = new int[m + 1];
        previous[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    previous[j] = previous[j - 1] + previous[j];
            }
        }
        return previous[m];
    }

}
