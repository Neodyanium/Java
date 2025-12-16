package DataStructure.SlidingWindow.Problems;

public class LongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int max = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            if (map[s.charAt(r)] != 0) {
                if (map[s.charAt(r)] >= l) {
                    l = map[s.charAt(r)] + 1;
                }
            }
            max = Math.max(max, r - l + 1);
            map[s.charAt(r)] = r;
            r++;
        }
        return max;
    }
}

