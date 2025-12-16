package DataStructure.Recursion;
import java.util.*;
public class GoldMaze {

    public static void main(String[] args) {
        int[][] arr  =
                {
                        {0,6,0},
                        {5,8,7},
                        {0,9,0}
                };
        System.out.println(getMaximumGold(arr));
    }
    public static int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        int result ;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    visited[i][j] = true;
                    result = checkPath(visited,i,j,grid,0,0);
                    visited[i][j] = false;
                    max = Math.max(result,max);
                }
            }
        }
        return max;
    }
    public static int checkPath(boolean[][] visited,int i,int j,int[][] grid,int sum,int max){

        sum += grid[i][j];
        //DOWN
        if(i < grid.length-1 && grid[i+1][j] != 0 && !visited[i+1][j]){
            visited[i+1][j] = true;
            max = checkPath(visited,i+1,j,grid,sum,max);
            visited[i+1][j] = false;
        }

        //RIGHT
        if(j < grid[0].length-1 && grid[i][j+1] != 0 && !visited[i][j+1]){
            visited[i][j+1] = true;
            max = checkPath(visited,i,j+1,grid,sum,max);
            visited[i][j+1] = false;

        }


        //UP
        if(i > 0 && grid[i-1][j] != 0 && !visited[i-1][j]){
            visited[i-1][j] = true;
            max = checkPath(visited,i-1,j,grid,sum,max);
            visited[i-1][j] = false;
        }

        //LEFT
        if(j > 0 && grid[i][j-1] != 0 && !visited[i][j-1]){
            visited[i][j-1] = true;
            max = checkPath(visited,i,j-1,grid,sum,max);
            visited[i][j-1] = false;
        }


        max = Math.max(sum,max);
        return max;
    }
}
