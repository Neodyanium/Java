package DataStructure.SlidingWindow.Problems;

import java.util.HashMap;

public class Fruits {

    public static void main(String[] args) {
        totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }
    public static int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0,r=0, maxLength=0;
        while(r < fruits.length){
            map.put(fruits[r],map.getOrDefault(r,0)+1);
            if(map.size() <= 2){
                maxLength = Math.max(maxLength,r-l+1);
            }else{
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l]) <= 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            r++;
        }
        return maxLength;
    }
}
