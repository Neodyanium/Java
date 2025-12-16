package DataStructure.DP.Grids2D;

import java.util.Arrays;

/**
 * Task: Ninja can perform one of the three tasks on a one day and earn the points, he can't do same activity twice in a row. Find the maximum
 * points he can earn. Ding-Ding
 * <p>
 * <p>
 * eg: {10,50,20}
 * {30,100,20}
 * <p>
 * Ninja can perform Activity 3 on day 1 so 20 points accumulated & do activity 2 on day 2 so, he earns 100. That would be the max possible points
 */
public class NinjaTraining2d {
    public static void main(String[] args) {
        int[][] activities = {{10, 20, 30},
                {15, 10, 20},
                {40, 5, 30}};
        int max = maxNenRecursion(activities, activities.length - 1, 3);
        int[][] dp = new int[activities.length][4];
//        int max2 = maxNenMemoized(activities, activities.length - 1, 3, dp);
//        int max3 = maxNenTabulation(activities, dp);
        int max4 = maxNenOptimal(activities);
        /*
        [30, 30, 20, 30]
        [40, 45, 45, 45]
        [75, 80, 80, 80]
        80
         */
        System.out.println(max4);
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int maxNenRecursion(int[][] activityPoints, int day, int last) {
        /**
         * Base case: if you are on the first day(top-down) then choose the maximum point which was not performed yesterday.
         * Other case: Choose every point, which was not performed the day before and when you are back from the base case store the max.
         */
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(activityPoints[day][i], max);
                }
            }
            return max;
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = activityPoints[day][i] + maxNenRecursion(activityPoints, day - 1, i);
                max = Math.max(max, point);
            }
        }
        return max;
    }

    /**
     * Stack Overflow in last test even after Memoization:https://www.naukri.com/code360/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
     *
     * @param activityPoints
     * @param day
     * @param last
     * @param dp
     * @return
     */
    public static int maxNenMemoized(int[][] activityPoints, int day, int last, int[][] dp) {
        /**
         * Base case: if you are on the first day(top-down) then choose the maximum point which was not performed yesterday.
         * Here we also store the base conditions value probably not necessary as you probably won't reach them it would be resolved with 1st
         * row or higher rows as the days increase.
         * But it is crucial when we do bottom up, as initial values of dp array are to be stored at the start.
         * Other case: Choose every point, which was not performed the day before and when you are back from the base case store the max.
         */

        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(activityPoints[day][i], max);
                }
            }
            return dp[day][last] = max;
        }

        if (dp[day][last] != 0) {
            return dp[day][last];
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = activityPoints[day][i] + maxNenMemoized(activityPoints, day - 1, i, dp);
                max = Math.max(max, point);
            }
        }
        return dp[day][last] = max;
    }

    public static int maxNenTabulation(int[][] activityPoints, int[][] dp) {
        //The base condition was when index equals to zero, here if index is zero we have four options of values.
        dp[0][0] = Math.max(activityPoints[0][1], activityPoints[0][2]);
        dp[0][1] = Math.max(activityPoints[0][0], activityPoints[0][2]);
        dp[0][2] = Math.max(activityPoints[0][0], activityPoints[0][1]);
        dp[0][3] = Math.max(activityPoints[0][0], Math.max(activityPoints[0][2], activityPoints[0][1]));

        //for the days starting from 1 to n-1
        for (int day = 1; day < activityPoints.length; day++) {
            //And these are all the possible values of last it can be 0,1,2,3
            for (int last = 0; last < 4; last++) {

                //The following is loop is similar to our choose all choices recursion, here task 0 to 2 can be performed

                dp[day][last] = 0; //what we are supposed to calculate

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = activityPoints[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(point, dp[day][last]);
                    }
                }
            }
        }
        return dp[dp.length - 1][3];
    }

    public static int maxNenOptimal(int[][] activityPoints) {
        int[] dp = new int[4];
        dp[0] = Math.max(activityPoints[0][1], activityPoints[0][2]);
        dp[1] = Math.max(activityPoints[0][0], activityPoints[0][2]);
        dp[2] = Math.max(activityPoints[0][0], activityPoints[0][1]);
        dp[3] = Math.max(activityPoints[0][0], Math.max(activityPoints[0][2], activityPoints[0][1]));

        for (int day = 1; day < activityPoints.length; day++) {
            System.out.println(Arrays.toString(dp));
            // Past data per day
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        temp[last] = Math.max((activityPoints[day][task] + dp[task]), temp[last]);
                    }
                }
            }
            dp = temp;
        }
        System.out.println(Arrays.toString(dp));
        return dp[3];
    }
}
