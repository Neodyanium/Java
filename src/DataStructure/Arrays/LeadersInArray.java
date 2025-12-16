package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray {

    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        System.out.println(leaders(arr));
    }

    /** (It was an easy question but remember the O(n) solution was thought by you)
     * A leader is an element where there are no element greater than itself on the right,
     * simple logic: We can look at it from the right side of array and maintain a max element,while traversing right to left if any element
     * encountered is greater than current max then we know that he is a leader as no one is bigger than him at right side. And we will simul.
     * update our max.
     */
    //[10,22,12,3,0,6]
    public static List<Integer> leaders(int[] arr){
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i=arr.length-1;i >=0;i--){
            if(arr[i] > max){
                list.add(arr[i]);
                max = arr[i];
            }
        }
        return list;
    }
}
