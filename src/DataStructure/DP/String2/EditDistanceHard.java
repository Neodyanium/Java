package DataStructure.DP.String2;

/**
 * You are given two Strings and you have a given set of operations, what are the minimum number of operations to convert the String1 to String2
 * Operations: 1) Delete anywhere, 2) Insert Anywhere(From String S2), 3)Replace anywhere(From String S2)
 * eg: s1 = horse   and s2=ros
 * replace h with r (rorse) , delete r (rose), delete e (ros) => So the minimum operations requuired is 3.
 */
public class EditDistanceHard {

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int ops = minOperations(s1.length() - 1, s2.length() - 1, s1, s2);
        int min = minOperations1based(s1.length(), s2.length(), s1, s2);
        int res = minOperationsTabulation(s1,s2);
        System.out.println(res);
    }

    public static int minOperations(int i, int j, String s1, String s2) {

        /**
         * if the index for the string s2 runs out it means that we have matched all the String s2 characters and String s1 still has remaining
         * characters so, we will need to delete those and each deletion is 1 point , so index i+1 will be total deletions.
         *
         * Similar case is when s1 runs out and s2 still remains it means it is still not equal to the s2 so we make remaining s2 characters insertion
         * in s1 that will be j+1
         */
        if (j < 0)
            return i + 1;
        if (i < 0)
            return j + 1;

        //If both the characters match, so we don't need to perform any operation we can simply check for remaining string.
        if (s1.charAt(i) == s2.charAt(j))
            return 0 + minOperations(i - 1, j - 1, s1, s2);

        /**
         * Now if they don't match we have three operations we can perform and we need to choose the one which has minimum number of steps
         * Insertion: we will add at the end of s1 the same character as s2 so, they match now we can move back a index on s2 as last of both match.
         *            see here we have added at the end of s1 so i is already one index back and we only make a call with i,j-1
         *
         * Deletion: we will delete at the last index, so we will need to move the previous index for String s1 while s2 remains at same index(i-1,j)
         *
         * Replace: We will replace the character at s1 with character at s2 so it matches, if both of them match we will need to get both the index to
         *          the previous indexes
         */

        return 1 + Math.min(minOperations(i, j - 1, s1, s2),
                Math.min(minOperations(i - 1, j, s1, s2),
                        minOperations(i - 1, j - 1, s1, s2)));


    }

    public static int minOperations1based(int i, int j, String s1, String s2) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return 0 + minOperations1based(i - 1, j - 1, s1, s2);

        return 1 + Math.min(minOperations1based(i - 1, j, s1, s2),
                Math.min(minOperations1based(i, j - 1, s1, s2), minOperations1based(i - 1, j - 1, s1, s2)));
    }

    public static int minOperationsMemoization(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (dp[i][j] != 0)
            return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return dp[i][j] = 0 + minOperations1based(i - 1, j - 1, s1, s2);

        return dp[i][j] = 1 + Math.min(minOperations1based(i - 1, j, s1, s2),
                Math.min(minOperations1based(i, j - 1, s1, s2), minOperations1based(i - 1, j - 1, s1, s2)));
    }

    public static int minOperationsTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        //base conditions
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 0 + dp[i - 1][j - 1];

                else dp[i][j] = 1 + Math.min(dp[i - 1][j],
                        Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[n][m];
    }

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[] previous = new int[m+1];
        int[] current = new int[m+1];
        for(int i=0; i <= m; i++ )
            previous[i] = i;

        for(int i=1; i<= n; i++){
            current[0] = i;
            for(int j=1; j<= m; j++){

                if(str1.charAt(i-1) == str2.charAt(j-1))
                    current[j] = previous[j-1];
                else
                    current[j] = 1 + Math.min(previous[j],Math.min(current[j-1],previous[j-1]));

            }
            previous = current.clone();
        }
        return previous[m];
    }

}
