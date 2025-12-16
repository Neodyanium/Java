package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static DataStructure.Arrays.ConvertGrid.print;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{2,4},{8,9},{9,11},{15,18},{16,17}};
        List<List<Integer>> merged = mergeIntervalsOptimal(nums);
        System.out.println(merged);
    }

    private static List<List<Integer>> mergeIntervals(int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i< nums.length;i++) {
            int start = nums[i][0];
            int end = nums[i][1];
            if(!ans.isEmpty() && nums[i][1] <= ans.get(ans.size()-1).get(1)) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j][0] <= end) {
                    end = Math.max(end, nums[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    private static List<List<Integer>> mergeIntervalsOptimal(int[][] nums){
        Arrays.sort(nums,Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(ans.isEmpty() || nums[i][0] > ans.get(ans.size()-1).get(1)  ){
                ans.add(Arrays.asList(nums[i][0],nums[i][1]));
            }else{
                int last = ans.get(ans.size()-1).get(1);
                ans.get(ans.size()-1).set(1,Math.max(last,nums[i][1]));
            }
        }
        return ans;
    }

    private static List<List<Integer>> mergeIntervalsOptimalMine(int[][] nums){
        Arrays.sort(nums,Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(ans.isEmpty()){
                ans.add(Arrays.asList(nums[i][0],nums[i][1]));
                continue;
            }
            int last = ans.get(ans.size()-1).get(1);
            if(nums[i][0] <= last){
                ans.get(ans.size()-1).set(1,Math.max(last,nums[i][1]));
            }else{
                ans.add(Arrays.asList(nums[i][0],nums[i][1]));
            }
        }
        return ans;
    }
}
