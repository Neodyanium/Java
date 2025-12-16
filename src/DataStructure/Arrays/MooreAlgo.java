package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MooreAlgo {
    /**
     * Its very fast compared to HashMap Solution
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};

        System.out.println(moreThanHalf(new int[]{1, 1, 2, 2,2}));

        System.out.println(majorityElement(new int[]{1,2,0,2,2,1,0}));
    }

    /**
     * We can use Hashmap to count the instances of all the numbres in 1st pass, then check in the map which key has value greater than n/2;
     * @param arr
     * @return
     */
    /**
     * The Moore's voting algo takes the advantage of the fact that n/2 element will exceed the numbers of other elements, if we keep having it
     *
     * @param arr
     * @return
     */
    public static int moreThanHalf(int[] arr) {
        int elem = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                elem = arr[i];
            }
            if (arr[i] > elem)
                count++;
            else
                count--;
        }
        //Only done to verify if the majority elements does not exists. If it always exists no need of this loop
        int count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                count2++;
            }
        }
        if (count2 > arr.length / 2) {
            return elem;
        }
        return -1;
    }

    public static List< Integer > majorityElement(int [] nums) {
        int count1=0,count2=0,elem1=0,elem2=0;
        for(int i=0;i<nums.length;i++){
            if(count1 == 0 && nums[i] != elem2 ){
                count1=1;
                elem1=nums[i];
            }else if(count2 == 0 && nums[i] != elem1){
                count2 = 1;
                elem2=nums[i];
            }else if(nums[i] == elem1){
                count1++;
            }else if(nums[i] == elem2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>(2);
        count1=count2=0;
        for(int i=0;i<nums.length;i++){
            if(elem1 == nums[i])
                count1++;
            else if(elem2 == nums[i])
                count2++;
        }
        int min = nums.length/3 + 1;
        if(count1 >= min) list.add(elem1);
        if(count2 >= min) list.add(elem2);
        return list;
    }
}
