package DataStructure.Arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSumOptimal(arr));
    }



    public static List<List<Integer>> threeSum(int[] arr){
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            HashSet<Integer> map = new HashSet<>();
            for(int j=i+1;j<arr.length;j++){
                int elem = -(arr[i] + arr[j]);
                if(map.contains(elem)) {
                    List<Integer> list = Arrays.asList(arr[i], arr[j], elem);
                    Collections.sort(list);
                    set.add(list);
                }
                    map.add(arr[j]);
                }
            }
        return new ArrayList<>(set);
    }

    /**\
     * arr= 2 0 1 0 - 2 -2 -2 -2 0 0 -1 -1 -1 2 -2 2 2 0 0 2 0 -1 1 1 1 2 1
     * @param arr
     * @return
     */
    public static List<List<Integer>> threeSumOptimal(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i > 0  && arr[i] == arr[i-1]) continue;
            int j=i+1;
             int k = arr.length-1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1]) j++;
                    while(j < k && arr[k] == arr[k+1]) k++;
                }
            }
        }
        return ans;
    }
}
