package DataStructure.SysDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// 2 ways to solve, either use a Sorted List or Optimally use a MinHeap of size K.

class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;

    List<Integer> list;

    public KthLargest(int l, int[] nums) {
        minHeap = new PriorityQueue<>();
        list = new ArrayList<>();
        this.k = l;
        for(int n:nums){
            list.add(n);
            add(n);
        }

    }

    public int add(int val){
        if(minHeap.size() < k || minHeap.peek() < val ){
            minHeap.add(val);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }

        return minHeap.peek();

    }

    public static void main(String[] args) {

    }

    public int insertPosition(int target){
        int start = 0 , end = list.size() -1 ;
        while(start < end){
            int mid = start + (end-start)/2;
            int elem = list.get(mid);
            if(elem == target){
                return mid;
            }else if(target < elem){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public int add2(int val){
        int position = insertPosition(val);
        list.add(position,val);
        return list.get(list.size() - k);
    }



}


//
//
//

//
//
//
//    public static int add(int val){
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        minHeap.add(1);
//        minHeap.add(2);
//        minHeap.remove();
//        System.out.println(minHeap);
//        return 1;
//    }


