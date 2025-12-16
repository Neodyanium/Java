package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternativeIntegers {
    public static void main(String[] args) {
        int[] arr = {-4, 1, -2, 4, 2, 4,-3,-7,-2,-6};
        System.out.println(Arrays.toString(alternativeNumbers2(arr)));
    }

    /**
     * You can create 2 arrays half the size of original array add all positives in one array and add all negatives to other one;
     * Now iterate n/2 times and put the first positive and negative pair and repeat the procedure.
     */
    public static int[] alternativeNumbers(int[] arr) {
        int pos = 0, neg = 1;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                ans[neg] = arr[i];
                neg += 2;
            } else {
                ans[pos] = arr[i];
                pos += 2;
            }
        }
        return ans;
    }

    /**
     * Follow up what would you do if you are not sure of the number of positives and negatives do brute force
     */
    public static int[] alternativeNumbers2(int[] arr) {
        int n=0;
        ArrayList<Integer> pos=new ArrayList<>(),neg = new ArrayList<>();
        for(int num:arr){
            if(num < 0)
                neg.add(num);
            else
                pos.add(num);
        }
        if(pos.size() > neg.size()){
            for(int i=0;i< neg.size();i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size();
            for(int i=neg.size()*2;i<arr.length;i++){
                arr[i] = pos.get(index++);
            }
        }else{
            for(int i=0;i<pos.size();i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index=pos.size();
            for(int i=pos.size()*2;i<arr.length;i++){
                arr[i] = neg.get(index++);
            }
        }
        return arr;


    }

}
