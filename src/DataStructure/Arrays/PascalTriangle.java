package DataStructure.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(pascalElement(5,3));
//        getPascalRow(5);
        System.out.println(pascalTriangle(6));
    }

    /**
     * It returns the nth row and cth element from pascals triangle
     * It uses the formula to calculate combination formula nCr
     * @param n
     * @param c
     * @return
     */
    public static int pascalElement(int n,int c){
        // we can avoid subtracting n-1 and c-1 if we simply pass the argument already subtracted by 1
        n = n-1;
        c = c-1;
        int res = 1;
        /**
         * Good way to find the combination
         * n!/ n! (n-r)! consider eg: 10C3 = 10 * 9 * 8 * 7! / 7! * 3! => 10*9*8/3*2*1
         *
         */
        for(int i=0;i<c;i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        return res;
    }

    /**
     * O(n)
     * @param n
     * 1 5 10 10 5 1
     * Simply first the first one. Iterate from 1 till n
     * Observations: n = 6
     * 1  1 * 5(n-1)  5 * 4(n-2)  10 * 3(n-3)   10 * 2(n-4)  5 * 1(n-5)   1
     *        1(i)        2(i)         3(i)          4(i)        5(i)
     * So we can generate a formula: ans = ans * (n-i) followed by ans = ans/i , we can print this ans, ans was initially 1
     *
     */
    public static void PascalRow(int n) {
        int ans = 1;
        System.out.print(1 + " ");
        for(int i=1;i<n;i++){
            ans = ans * (n-i);
            ans = ans / i ;
            System.out.print(ans + " ");
        }
    }


    /**
     * We have used Pascal row's logic over and over to get the list for each row. It is a good idea to keep the GeerateRow function separate
     * @param n
     * @return
     */
    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            List<Integer> list = new ArrayList<>();
            int ans = 1;
            list.add(ans);
            for(int k=1;k<i;k++){
                ans = ans * (i-k);
                ans = ans / k;
                list.add(ans);
            }
            result.add(list);
        }
        return result;
    }
}
