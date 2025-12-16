package DataStructure.Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    public int leftIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    public int rightIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }

    public int parentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    public void add(T element){
        list.add(element);
        upheap(list.size() -1);

    }

    public void upheap(int index){
        if(index == 0)
            return;
        int p = parentIndex(index);
        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(index,p);
        }
        upheap(p);
    }

    public T remove(){
        if(list.isEmpty())
            throw new RuntimeException("Empty Heap Found");
        T remove = list.get(0);
        T last = list.remove(list.size() - 1);
        if(!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return remove;
    }

    public void downheap(int index){
        int min = index;

        int left = leftIndex(index);
        int right = rightIndex(index);

        if(left < list.size() && list.get(left).compareTo(list.get(min)) < 0){
            min = left;
        }

        if(right < list.size() && list.get(right).compareTo(list.get(min)) < 0){
            min = right;
        }

        if(min != index){
            swap(min,index);
            downheap(min);
        }
    }
    //See the remove function removes the 1st min element but, it also has a mechanism which adjusts the smallest element as the first element
    // keep removing keep getting smallest in the list

    public ArrayList<T> heapSort(){
        ArrayList<T> sortedList = new ArrayList<>();
        while(!list.isEmpty()){
            sortedList.add(this.remove());
        }
        return sortedList;
    }

    public void swap(int left,int right){
        T temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Initial List:"+heap.list);
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(19);
        System.out.println(heap.list);
        System.out.println(heap.heapSort());


    }
}
