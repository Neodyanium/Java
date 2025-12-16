package DataStructure.Recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = getPartitions(s, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(ans);
    }

    /**
     * The function returns all the palindromic partitions within the string
     *
     * @param s
     * @param index
     * @param ans
     * @param path
     */

    public static List<List<String>> getPartitions(String s, int index, List<List<String>> ans, List<String> path) {
        //base condition is whenever out partition reaches at the end i.e. index becomes same as String length
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return ans;
        }

        /**
         * Check if a substring is a palindrome if it is, continue with next substring as the actual string in recursion call
         * if anywhere you don't find the palindrome it will return and i value will increase, so bigger partitions are tested whetherr they can
         * form palindromic partitions.
         */

        for (int i = index; i < s.length(); i++) {
            //checks if the string from index till i is palindrome or not
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                getPartitions(s, i + 1, ans, path);
                path.remove(path.size() - 1);
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() {
        /* For understanding of input and output
            s = "aaab"
            output = [["a","a","a","b"],["a","aa","b"],["aa","a","b"],["aaa","b"]]

            s = "abcaa"
            output = [["a","b","c","a","a"],["a","b","c","aa"]]

            s = "abbab"
            output = [["a","b","b","a","b"],["a","b","bab"],["a","bb","a","b"],["abba","b"]]

            s = "abaca"
            output = [["a","b","a","c","a"],["a","b","aca"],["aba","c","a"]]

            s = "aaa"
            output = [["a","a","a"],["a","aa"],["aa","a"],["aaa"]]
         */
    }
}
