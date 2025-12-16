package DataStructure.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermutation {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(9,8,7,6));
        System.out.println(kthPermutation(4,17));

    }

    /**
     * eg: n=4, k=17, arr = [1,2,3,4] based on 0 indexing it will be 16th permutation 3412
     * so we can say there are total 4! permutations each starting with either 1, 2, 3 or 4. So it will be a group of 6.
     * 1(0,5),2(6,12),3(13,18),4(19,24). So 16(K)/6 (n-1)! = 2(group it belongs to), so our group is 3(13,18) . Start would be 3
     * 2nd number is? since we already have 3 remove it so, we get 1 2 4 it can form 3 groups 1(0,1) 2(2,3) 4(4,5) [3 combo of 2]
     * k would be reduced to k % factorial (16 % 6) == 4, so 4(k)/2 (n-1)! i.e = 2 again pick the 2nd choice i.e 4 so => 3,4 , 4 is removed
     * and the groups formed would be 1(0-1) 2(1-2) as and since k is reduced to zero (4 % 2), so we pick 0/ 1 ! which is 0, so 1 picked and removed
     * so its 3,4,1 now list still has one digit so, we will go again and this time the last remaining element is also added.
     *


     */

    public static String kthPermutation(int n,int k){
        StringBuilder sb = new StringBuilder();
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            fact *= i;
            list.add(i);
        }
        list.add(n);
        k = k-1;
        while(true){
            sb.append(list.get(k/fact));
            list.remove(k/fact);
            if(list.isEmpty()){
                break;
            }
            k = k % fact;
            fact = fact/list.size();
        }
        return sb.toString();
    }
}
