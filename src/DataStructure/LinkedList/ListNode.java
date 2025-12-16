package DataStructure.LinkedList;

import java.util.HashSet;

/**
 * To solve Linked List Questions you will only require little visualization of how you will make changes from node to node it isn't that much
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return display(this);
    }

    public static String display(ListNode node) {
        String s = "";
        while (node != null) {
            s += node.val + " -> ";
            node = node.next;
        }
        s += "End";
        return s;
    }


    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMidMergeSort(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //5 4 6 2
    public static ListNode getMidMergeSort(ListNode head) {
        ListNode premid = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            premid = (premid == null) ? head : premid.next;
            fast = fast.next.next;
        }
        ListNode mid = premid.next;
        //connection breaked
        premid.next = null;
        return mid;
    }

    /**
     * @param first
     * @param second
     * @return Make a result LL and a dummynode with same reference as result node,while one of them is not null compare the values of
     * the node and add smaller into the dummynode move the dummynode forward and LL forward(from where small value found)
     * why the hell am I writing for such simple function
     */
    public static ListNode merge(ListNode first, ListNode second) {
        ListNode result = new ListNode(0);
        ListNode dummyNode = result;
        while (first != null && second != null) {
            if (first.val < second.val) {
                dummyNode.next = first;
                first = first.next;
                dummyNode = dummyNode.next;
            } else {
                dummyNode.next = second;
                second = second.next;
                dummyNode = dummyNode.next;
            }
        }
        if (first != null) {
            while (first != null) {
                dummyNode.next = first;
                first = first.next;
                dummyNode = dummyNode.next;
            }
        }
        if (second != null) {
            while (second != null) {
                dummyNode.next = second;
                second = second.next;
                dummyNode = dummyNode.next;
            }
        }
        return result.next;
    }

    //Both them starts at the head and then progress fast pointer 2 steps and slow 1 step
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * @param head - After you have detected that there is a loop(slow and fast at the same node)
     *             Stop either of the pointers and move another forward and count the length until the pointers meet again
     * @return
     */
    public static int lengthOfCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = slow.next;
                int count = 1;
                while (slow != fast) {
                    slow = slow.next;
                    count++;
                }
                return count;
            }
        }
        return -1;
    }

    /**
     * @param head Start of the ListNode
     * @return The node where the loop starts in a Linked List
     * Used 3 pointers start,fast and slow.
     * fast and slow is used to find the existence of the loop, if it exists then we will use start pointer
     * IMP move start pointer and slow/fast pointer one step ahead till they arrive at same node.
     */
    public static ListNode startOfCycle(ListNode head) {
        ListNode start = head, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (start != slow) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }

    /**
     * Hidden Linked List Cycle approach can be used for the Happy Number Question to detect any infinite loop
     *
     * @param n
     * @return Brute Force and then Optimised approach
     */
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            //condition 1
            if (sum == 1)
                return true;
            //Infinite loop of sometimes repeating numbers
            if (set.contains(sum))
                break;
            else
                set.add(sum);
            //Increasingly  infinetely that it exceeds integer range
            if (sum < 0)
                break;
            n = sum;
            sum = 0;
        }
        return false;
    }

    public static boolean isHappyO(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = square(slow);
            fast = square(square(fast));

        } while (slow != 1);

        return true;
    }

    public static int square(int number) {
        int sum = 0;
        while (number != 0) {
            int rem = number % 10;
            sum += rem * rem;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(3, new ListNode(4)));
        /**
         * The following has a cycle
         *  1  2  3  4  9
         *  ^-----------^
         */
//        ListNode second = new ListNode(1);
//        second.next = new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(9,second))));

        //1 2 3 4 5 6 (6 connected to 4)
//        ListNode node6 = new ListNode(6);
//        ListNode node5 = new ListNode(5,node6);
//        ListNode node4 = new ListNode(4,node5);
//        ListNode node3 = new ListNode(3,node4);
//        ListNode node2 = new ListNode(2,node3);
//        ListNode node1 = new ListNode(1,node2);
//        node6.next =node4;
//
//        ListNode unsortedList = new ListNode(5,new ListNode(4,new ListNode(6,new ListNode(2))));
//        display(mergeSort(unsortedList));
//        String s = "aA";
//
//        display(createListNode(3,4,1,2));
        // 2 1 4 3
        ListNode list = createListNode(1, 2, 3, 4, 5);

        ListNode head = reverseBetween(list, 2, 4);
        display(head);
        ListNode l = createListNode(7,7,3,7,9,7,6,8,9,9);

        System.out.println(display(doubleIt(createListNode(1,8,9))));;

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }

    private static ListNode reverseRangeList(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        for (int i = 1; i < left; i++) {
            prev = current;
            current = current.next;
        }
        ListNode newEnd = current;
        ListNode first = prev;

        //reverse iterative type we reverse in a moving forward kind of manner, so it's suitable for ranged reverse.
        ListNode next;
        for (int i = 0; i <= right - left; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (first == null) {
            head = prev;
        } else {
            first.next = prev;
        }

        newEnd.next = current;
        return head;

    }

    public static ListNode createListNode(int... nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    // 3 4 1 2

    /**
     * @param head - It's the head of first node other required pointers are previous and next
     *             You have a current node that starts from 0th index so the previous is initially null and next is always 1 Node ahead of
     *             current;
     *             how to reverse, check if current(head) node is null if not, fetch the next node(Current's next) so you have link to future node
     *             assign the current's next to previous (actual reverse), for the next iteration our previous node will be current node so assign
     *             previous to current. And finally move the current to next. If you follow this notice how you break links and keep them ass-
     *             ing them back to previous nodes. At the end the current will be null and next will also be null. The reversed list head will
     *             be previous pointer.
     * @return returns the head of the list after it is effectivel reversed
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode recursiveReverse(ListNode head) {
        // Special case...
        if (head == null || head.next == null) return head;
        // Create a new node to call the function recursively and we get the reverse linked list...
        ListNode res = recursiveReverse(head.next);
        // Set head node as head.next.next...
        head.next.next = head;
        //set head's next to be null...
        head.next = null;
        return res;     // Return the reverse linked list...
    }

    public static ListNode doubleIt(ListNode head) {
        long num = 0;
        ListNode prev = null;
        ListNode current = new ListNode();
        long no,carry=0;
        while(head != null){
            long r = head.val;
            no = r > 4 ? (r*2)%10: r * 2 ;
            current.val = (int)(no + carry);
            carry = r > 4 ? 1 : 0;
            current.next = new ListNode();
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            head = head.next;
        }
        if(carry==1){
            current = new ListNode(1);
            current.next = prev;
            prev=current;
        }
        return prev;
    }
}