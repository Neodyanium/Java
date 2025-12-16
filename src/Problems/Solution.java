package Problems;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.List;
import java.util.stream.*;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    //You can flip either whole row or whole column, you want an output such that sum of each binary row, gives maximum sum.
    public static int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Set score to summation of first column
        int score = (1 << (n - 1)) * m;

        // Loop over all other columns
        for (int j = 1; j < n; j++) {
            int countSameBits = 0;
            for (int i = 0; i < m; i++) {
                // Count elements matching first in row
                if (grid[i][j] == grid[i][0]) {
                    countSameBits++;
                }
            }
            // Calculate score based on the number of same bits in a column
            countSameBits = Math.max(countSameBits, m - countSameBits);
            // Calculate the score contribution for the current column
            int columnScore = (1 << (n - j - 1)) * countSameBits;
            // Add contribution to score
            score += columnScore;
        }
        return score;
    }

    /**
     *Given nums = [2, 2, 2, 1, 2, 2, 1, 2, 2, 2] and k = 2:
     *
     * Subarrays starting at index 0:
     * [2, 2, 2, 1, 2, 2, 1]
     * [2, 2, 2, 1, 2, 2, 1, 2]
     * [2, 2, 2, 1, 2, 2, 1, 2, 2]
     * [2, 2, 2, 1, 2, 2, 1, 2, 2, 2]
     *
     * Subarrays starting at index 1:
     * [2, 2, 1, 2, 2, 1]
     * [2, 2, 1, 2, 2, 1, 2]
     * [2, 2, 1, 2, 2, 1, 2, 2]
     * [2, 2, 1, 2, 2, 1, 2, 2, 2]
     *
     * Subarrays starting at index 2:
     * [2, 1, 2, 2, 1]
     * [2, 1, 2, 2, 1, 2]
     * [2, 1, 2, 2, 1, 2, 2]
     * [2, 1, 2, 2, 1, 2, 2, 2]
     *
     * Subarrays starting at index 3:
     * [1, 2, 2, 1]
     * [1, 2, 2, 1, 2]
     * [1, 2, 2, 1, 2, 2]
     * [1, 2, 2, 1, 2, 2, 2]
     */

    public static int countOfNiceArrays(int[] arr,int target){
        return 1;
    }

    public static void clock() {
        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        in.nextLine();
        while (loop != 0) {
            String rawTime = in.nextLine();
            int time = Integer.parseInt(rawTime.split(":")[0]);
            if (time == 0) {
                System.out.println(12 + ":" + rawTime.split(":")[1] + " AM");
            } else if (time / 12 == 0) {
                System.out.println(rawTime.split(":")[0] + ":" + rawTime.split(":")[1] + " AM");
            } else if (time % 12 == 0) {
                System.out.println(12 + ":" + rawTime.split(":")[1] + " PM");
            } else {
                if (time % 12 < 10) {
                    System.out.println("0" + time % 12 + ":" + rawTime.split(":")[1] + " PM");
                } else
                    System.out.println(time % 12 + ":" + rawTime.split(":")[1] + " PM");
            }
            loop--;
        }
    }

    //Bruteforce solution of sliding window
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product < k)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0, product = 1;
        for (int right = 0, left = 0; right < nums.length; right++) {

            product *= nums[right];

            while (product >= k) {
                product /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

    public static List<Integer> subarraySums(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // Calculate the sum of the subarray starting from index i
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result.add(sum);
            }
        }

        return result;
    }

    public static int maxDepth(String s) {
        int l = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                max = Math.max(l, ++l);
            } else if (s.charAt(i) == ')')
                l--;
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int score = matrixScore(arr);
        System.out.println(score);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);
        if (len == 1) return null;
        ListNode current = head;
        for (int i = 1; i < len - n; i++) {
            current = current.next;
        }
        ListNode rem = current.next;
        current.next = rem.next;
        return head;
    }

    public static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static class MeetComparator implements Comparator<Meet> {
        @Override
        public int compare(Meet o1, Meet o2) {
            if (o1.time < o2.time) return -1;
            else if (o1.time > o2.time) return 1;
            return 0;
        }
    }


    static class Meet {
        int person1;
        int person2;
        int time;

        Meet() {
        }

        Meet(int person1, int person2, int time) {
            this.person1 = person1;
            this.person2 = person2;
            this.time = time;
        }

        public String toString() {
            return "[" + this.person1 + "," + this.person2 + "," + this.time + "]";
        }

    }

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Meet> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);
        for (int i = 0; i < meetings.length; i++) {
            list.add(new Meet(meetings[i][0], meetings[i][1], meetings[i][2]));
        }
//        MeetComparator mc = ;
        Collections.sort(list, new MeetComparator());
        for (Meet m : list) {
            if (set.contains(m.person1)) {
                set.add(m.person2);
            } else if (set.contains(m.person2)) {
                set.add(m.person1);
            }
        }
        return new ArrayList(set);
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slowptr = head;
        ListNode fastptr = head;
        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if (fastptr.val == slowptr.val)
                return true;
        }
        return false;

    }


    public static String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DI", "DII", "DIII", "CM"};
        String[] tens = {"", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return thousands[(num / 1000)] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10]
                + units[(num % 10)];
    }

    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for (int i = 0; i < trust.length; i++) {
            map.put(trust[i][0], 1);
        }
        for (int i = 0; i < trust.length; i++) {
            if (!map.containsKey(trust[i][1])) {
                result = trust[i][1];
                break;
            }
        }
        return result;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            count += matrix[i].length;
            if (k > count) {
                continue;
            } else {
                System.out.println(matrix[i][matrix[i].length - (count - k) - 1]);
                break;
            }
        }
        return 1;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(String[] str) {
        for (String a : str) {
            System.out.print(a + " ");
        }
    }

    private static void print(char[] s) {
        for (char a : s) {
            System.out.print(a + " ");
        }
    }

    public static void print(ArrayList<Integer> arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void print(Set<Integer> keySet) {
        for (int a : keySet) {
            System.out.print(a + " ");
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (list1 != null) {
            arr.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            arr.add(list2.val);
            list2 = list2.next;
        }
        if (arr.isEmpty())
            return new ListNode();
        Collections.sort(arr);
        System.out.println(arr);
        ListNode head = new ListNode(arr.get(0));
        ListNode current = head;
        for (int i = 1; i < arr.size(); i++) {
            current.next = new ListNode(arr.get(i));
            current = current.next;
        }

        return head;
    }

    public static boolean isPalindrome(int x) {
        boolean flag = false;
        int temp = x, sum = 0;
        while (x > 10) {
            int last = x % 10;
            sum = sum * 10 + last;
            x = x / 10;
        }
        if (sum == temp)
            flag = true;
        return flag;
    }


    public static int removeDuplicates(int[] nums) {
        int index = 1, rep = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    rep++;
                    continue;
                } else {
                    int temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;
                    index++;
                    if (rep > 1)
                        i = j;
                    break;
                }
            }
        }
        print(nums);
        return index;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(')');
            else if (s.charAt(i) == '{')
                stack.push('}');
            else if (s.charAt(i) == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != s.charAt(i))
                return false;
        }
        return stack.isEmpty();
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        print(s);
    }

    //    public static int majorityElement(int[] nums) {
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
////        Leetcode\|/
//        for(int n:nums){
//            hashMap.put(n,hashMap.getOrDefault(n,0)+1);
//        }
//        System.out.println(hashMap);
////        for(int i = 0;i<nums.length;i++){
////            if(hashMap.containsKey(nums[i])){
////                hashMap.put(nums[i],hashMap.get(nums[i])+1);
////            }
////            else{
////                hashMap.put(nums[i],1);
////            }
////        }
//        int finalkey= 0;
//        int maxval = Integer.MIN_VALUE;
//        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
//            if(entry.getValue() > maxval){
//                finalkey = entry.getKey();
//                maxval = entry.getValue();
//            }
//        }
//        return finalkey;
//    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }
        int maxKey = 0;
        int maxVal = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxKey = entry.getKey();
                maxVal = entry.getValue();
            }
        }

        return maxKey;
    }

    Double ret(int a) {
        return a * 8.5761487346857614873468;
    }

    public static int strStr(String haystack, String needle) {
        int needleLen = needle.length(), iterations = haystack.length() - needle.length() + 1;
        if (haystack.contains(needle)) {
            for (int i = 0; i < iterations; i++) {
                if (haystack.substring(i, needleLen + i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //2,0,2,1,1,0
    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == nums[j + 1]) {
                } else if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        print(nums);
    }

    public static void sortColors2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[smallest] == nums[j]) {
                } else if (nums[smallest] > nums[j]) {
                    smallest = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[smallest];
            nums[smallest] = temp;
        }
        print(nums);
    }

    public static void swap(int a, int b) {
        System.out.println("Provided:" + "a:" + a + " b:" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Swapped:" + "a:" + a + " b:" + b);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1)
            return "";
        Arrays.sort(strs);
        int i = 0;
        String str1 = strs[0], strs2 = strs[strs.length - 1];
        while (i < str1.length() && i < strs2.length()) {
            if (str1.charAt(i) == strs2.charAt(i))
                i++;
            else break;
        }
        return str1.substring(0, i);
    }

    public static int reverse(int x) {
        long result = rev(x);
        if (result < Integer.MAX_VALUE && result > Integer.MIN_VALUE) {
            return (int) result;
        } else return 0;
    }

    public static long rev(int n) {
        long sum = 0L;
        int flag = 1;
        if (n < 0) {
            n = n * -1;
            flag = -1;
        }
        while (n > 0) {
            int r = n % 10;
            sum = sum * 10 + r;
            n = n / 10;
        }
        return (sum * flag);
    }

    public static int[] countBits(int n) {
        //Very Slow in Leet code
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int ones = 0, index = i;
            do {
                if (index % 2 == 1) {
                    ones++;
                }
                index = index / 2;
            } while (index >= 1);
            nums[i] = ones;
        }
        return nums;
    }

    public static int[] countBits2(int num) {
        //LeetCode Solution
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        print(f);
        return f;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (l1 != null) {
            arr.add(l1.val);
            l1 = l1.next;
        }
        return new ListNode();
    }

    //Good use of Looping Structure
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        //1,2,3,4,5,6,7,8,9,10,1
        while (fast != null && fast.next != null) {
            slow = slow.next;//2
            fast = fast.next.next;//

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(hashMap.containsKey(nums[i])){
//                hashMap.put(nums[i],hashMap.get(nums[i]+1));
//                if(hashMap.get(nums[i]) > 1)
//                    return true;
//            }
//            else{
//                hashMap.put(nums[i],1);
//            }
//        }
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
            if (hashMap.get(n) > 1)
                return true;
        }
        return false;
    }

    public static int maxProfit(int[] prices) {
        int largest = Integer.MIN_VALUE, idx1 = 0, idx2 = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > largest) {
                largest = prices[i];
                idx1 = i;
            }
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < idx1; i++)
            if (prices[i] < smallest) {
                smallest = prices[i];
                idx2 = i;
            }
        return prices[idx1] - prices[idx2];
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                arr[index] = i;
                index++;
                if (index > 2)
                    return arr;
            }
        }
        return new int[]{-1, -1};
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int sub = Arrays.stream(candies).max().getAsInt() - extraCandies;
        List<Boolean> arr = new ArrayList<>();
        for (int n : candies) {
            if (n >= sub)
                arr.add(true);
            else
                arr.add(false);
        }
        return arr;
    }

    public static int sqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    public static String mergeAlternately(String word1, String word2) {

        return " ";
    }

    public static void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        String[] arr = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (!(hm.getOrDefault(pattern.charAt(i), "").equals(arr[i])))
                    return false;
            } else {
                hm.put(pattern.charAt(i), arr[i]);
            }
        }
        return true;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode start = head;
        boolean flag = false;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                continue;
            } else if (head.next != null && head.next.val == val) {
                flag = true;
                if (head.next.next == null)
                    head.next = null;
                else {
                    flag = true;
                    head.next = head.next.next;
                }
            } else return head;
            head = head.next;
        }
        if (!flag) return head;
        return start;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode start;
        ListNode currentReference = null;
        while (head != null) {

        }
        return currentReference;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
//        return (((n*(n+1))/2) - (sum));

        // OR WIth Binary Search
        int left = 0, right = nums.length - 1;
        while (left < right) {
            System.out.println("Mai Yaha ti kaha");
            int mid = (left + right) / 2;
            //if number at middle is greater than the index missing number is at left
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack s2 = new Stack();
        Stack t2 = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!s2.empty()) s2.pop();
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!t2.empty()) t2.pop();
            }
        }
        return s2.equals(t2);
    }

    public static int differenceInBits(int n) {
        String s = Integer.toString(n, 2);
        System.out.println(s);
        return 2;
    }

    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int bits = 0;
        while (z >= 1) {
            if (z % 2 == 1)
                bits++;
            z = z / 2;
        }
        return bits;
    }

    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (isInteger(operations[i])) {
                stack.push(Integer.parseInt(operations[i]));
            } else if (operations[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (operations[i].equals("C")) {
                if (!stack.empty()) stack.pop();
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int c = a + b;
                stack.push(b);
                stack.push(a);
                stack.push(c);
            }
        }
        int sum = 0;
        while (!stack.empty())
            sum += stack.pop();
        return sum;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public static boolean isPowerOfFour(int n) {
        while (n % 4 == 0) {
            int num = n / 4;
            for (int i = num; i >= 0; i++) {
                if (n == Math.pow(4, num))
                    return true;
                num--;
            }
        }
        return false;
    }
}

class Parent {
    private int k = 10;

    public Number marry() {
        System.out.println("Parent Choice");
        return 1;
    }
}

//class Child extends Parent{
//    public Double marry(){
//        System.out.println("Child Choice");
//        return 2d;
//    }
//}

//sadbutsad sad sad adb dbu but uts tsa sad 9 3 7
//hello -> ll -> he el ll lo 5 2 4
//africa ca -> af fr ri ic ca
//africa ric -> afr fri ric ica


abstract interface doable {

}

strictfp class Person {
    String name;
    transient volatile String password;

    static final void setName() {
        System.out.println("This is my name");
    }

    Double ret(int a) {
        return a * 8.5761487346857614873468;
    }

}


class Animal {
    static PrintStream sound;

    static class venom {

    }


    static void className() {
        System.out.println("Animal Class");
    }

    public static void main(String[] args) {


    }
}






