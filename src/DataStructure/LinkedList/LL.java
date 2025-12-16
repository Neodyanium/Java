package DataStructure.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    // 8 4 2 1

    public Node find(int index){
        if(index > size)
            throw new RuntimeException("Index Out of Range");
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insert(int value,int index){
        if(index > size)
            throw new RuntimeException("Index Out of Range");
        if(index ==0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
        }
        Node prev = find(index-1);
        Node node = new Node(value);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public int deleteFirst(){
        if(size == 0)
                throw new RuntimeException("Empty Linked List");
        int val = head.val;
        head = head.next;
        size--;
        if(head == null){
            tail = null;
        }
        return val;
    }

    public int deleteLast(){
        if(size == 1){
            return deleteFirst();
        }
        Node secondLast = find(size - 2);
        int val = secondLast.next.val;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if(index >= size)
            throw new RuntimeException("Index Out of Bounds");
        if(index == 0)
            return deleteFirst();
        if(index == size-1)
            return deleteLast();
        // 45 32 20 18 67
        Node node = find(index-1);
        int val = node.next.val;
        node.next = node.next.next;
        size--;
        return val;
    }

    protected class Node{
       private int val;

       private Node next;

       Node(int n){
           this.val = n;
       }

       Node(int n,Node next) {
           this.val = n;
           this.next = next;
       }
        public String toString(){
            return ""+val;
        }
    }

    /**Interesting Methods Starts Here
     *
     * @param val
     * @param index
     */
    public void insertRec(int val,int index){
        head = insertRec(val,index,head);
    }

    /**
     *
     * @param val
     * @param index
     * @param node
     */
    public Node insertRec(int val,int index,Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRec(val,--index,node.next);
        return node;
    }

    // 1 2 3 4
    //Remove Duplicates from Linked List
    public void removeDuplicates(){
        Node node = head;
        while(node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
                size--;
            }else{
                node=node.next;
            }
        }
        tail=node;
        tail.next=null;
        display();
    }

    /**
     * merge two sorted Linked List
     * @param first
     * @param second
     */
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while(f != null && s != null){
            if(f.val < s.val){
                ans.insertLast(f.val);
                f=f.next;
            }
            else{
                ans.insertLast(s.val);
                s=s.next;
            }
        }
        if(f != null){
            while(f != null){
                ans.insertLast(f.val);
                f=f.next;
            }
        }
        if(s != null){
            while(s != null){
                ans.insertLast(s.val);
                s = s.next;
            }
        }
        return ans;
    }

    //Both them starts at the head and then progress fast pointer 2 steps and slow 1 step
    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }


    public int lengthOfCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                slow = slow.next;
                int count = 1;
                while(slow != fast){
                    slow = slow.next;
                    count++;
                }
                return count;
            }
        }
       return -1;
    }



    public static void main(String[] args) {
        LL first = new LL();
        LL second = new LL();
        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(4);

        second.insertLast(1);
        second.insertLast(3);
        second.insertLast(4);
        second.insertLast(9);

        merge(first,second).display();
    }

    //LeetCode Solution
    public static ListNode merge(ListNode first,ListNode second){
        ListNode result = new ListNode(0);
        ListNode dummyNode = result;
        while(first != null && second != null){
            if(first.val < second.val){
                dummyNode.next = first;
                first=first.next;
                dummyNode = dummyNode.next;
            }else{
                dummyNode.next = second;
                second = second.next;
                dummyNode = dummyNode.next;
            }
        }
        if(first != null){
            while(first != null ){
                dummyNode.next = first;
                first=first.next;
                dummyNode = dummyNode.next;
            }
        }
        if(second != null){
            while(second != null ){
                dummyNode.next = second;
                second=second.next;
                dummyNode = dummyNode.next;
            }
        }
        return result.next;
    }


}
