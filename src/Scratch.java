import DataStructure.LinkedList.ListNode;

public class Scratch {

    public static void main(String[] args) {
        ListNode list = new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));
        list = bubbleSort(length(list)-1,0,list);
        list.display(list);
    }
    public static ListNode sortList(ListNode head) {
        head = bubbleSort(length(head)-1,0,head);
        return head;
    }

    public static ListNode bubbleSort(int row,int col,ListNode head){
        if(row == 0){
            return head;
        }
        if(col < row){
            ListNode f = getNode(col,head);
            ListNode s = getNode(col+1,head);
            if(f.val > s.val){
                if(head == f){
                    f.next = s.next;
                    s.next = f;
                    head = s;
                }else{
                    // 2 4 1 3
                    ListNode prev = getNode(col-1,head);
                    prev.next = f.next;
                    f.next = s.next;
                    s.next = f;
                }
            }
            head = bubbleSort(row,col+1,head);
        }else{
            head = bubbleSort(row-1,0,head);
        }
        return head;
    }

    public static ListNode getNode(int index,ListNode head){
        ListNode temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    public static int length(ListNode head){
        ListNode temp = head;
        int len=0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }


}
