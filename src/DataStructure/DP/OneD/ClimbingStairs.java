package DataStructure.DP.OneD;
import java.util.Scanner;

// a person can climb at max 1 or 2 steps, given n stairs in how many ways can he climb the stairs
public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of Stairs:");
        int n = in.nextInt();
        int ways = countWaysOptimal(n);
        System.out.println("The total ways to climb the stairs:"+ways);
    }

    public static int countWays(int n){
        int count = 0;
        //The base case is important n <= 2 is wrong if n is 2 there is still 2 ways to climb, but with 1 or zero there is definitely only one choice
        if(n <= 1){
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    public static int countWaysOptimal(int n){
        int count = 0;
        if(n <= 1){
            return 1;
        }
        count += countWaysOptimal(n-1);
        count += countWaysOptimal(n-2);
        return count;
    }

    // 1  1  2   3    4    7
}
