package Java8.LambdaF;

import java.util.*;

import static DataStructure.Arrays.ConvertGrid.print;

public class ComparatorDemo {


    public static void main(String[] args) {
        int[][] arr = {{4,5},{1,3},{2,7},{9,1}};
        print(arr);
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        print(arr);
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(20);
        list.add(16);
        list.add(36);
        System.out.println(list);
     //   Collections.sort(list,new CustomComparator());
        Collections.sort(list,(i1,i2) -> i2 - i1);
        Collections.sort(list,Comparator.reverseOrder());
        System.out.println(list);

    }

}
class CustomComparator implements Comparator<Integer> {

//    @Override
//    public int compare(Integer i1,Integer i2){
//        return i2-i1;
//    }

    public int compare(Integer i1,Integer i2){
        return i2.compareTo(i1);
    }


}
