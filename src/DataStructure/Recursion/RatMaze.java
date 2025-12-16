package DataStructure.Recursion;

import java.util.ArrayList;
import java.util.List;

import static DataStructure.Arrays.ConvertGrid.print;

/** Rat has to reach the end of maze and 0s are blocked path, rat can walk only on one and answer must be lexicographically sorted
 * Solved as I saw fit, main concept is maintaining a visited 2d array so when we are pondering over choices of which direction to go we don't
 * return to where we came from.
 * conditions should be checked whether the direction is possible and then make recursion call within it, to find all the possible paths make sure
 * not to create and if else ladder, all choices must be persuadable so use only if statements
 *
 * to maintain lexicography go D,L,R,U so no separate sorting required
 *
 */
public class RatMaze {

    public static void main(String[] args) {
        int[][] maze =
                {
                        {1,0,0,0},
                        {1,1,0,1},
                        {1,1,0,0},
                        {0,1,1,1}
                };
        print(maze);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        List<String> result = solve(maze, visited, 0, 0,"");
        int[] di = {1,0,0,-1};
        int[] dj = {0,-1,1,0};
        List<String> result2 = optimalOrWot(maze, visited, 0, 0,"",di,dj);
        System.out.println(result2);

    }

    private static List<String> optimalOrWot(int[][] maze, boolean[][] visited, int row, int col, String s, int[] di, int[] dj) {
        List<String> result = new ArrayList<>();
        if(row == maze.length-1 && col == maze[0].length-1){
            result.add(s);
            return result;
        }
        String temp = "DLRU";
        for(int i=0;i<4;i++){
            int nextRow = row + di[i];
            int nextCol = col + dj[i];
            if(nextRow  < maze.length &&  nextCol < maze[0].length && nextRow >=0 && nextCol >= 0 && !visited[nextRow][nextCol] && maze[nextRow][nextCol]==1){
                visited[nextRow][nextCol] = true;
                result.addAll(optimalOrWot(maze,visited,nextRow,nextCol,s+temp.charAt(i),di,dj));
                visited[nextRow][nextCol] = false;
            }
        }
        return result;
    }

    public static List<String> solve(int[][] maze,boolean[][] visited,int row,int col,String s){
        List<String> result = new ArrayList<>();
        if(row == maze.length-1 && col == maze[0].length-1){
            result.add((s));
            return result;
        }
        //Downward direction
        if(row < maze.length-1 && maze[row+1][col] == 1 && !visited[row+1][col]){
            visited[row+1][col] = true;
            s += "D";
            result.addAll(solve(maze,visited,row+1,col,s));
            s = s.substring(0,s.length()-1);
            visited[row+1][col] = false;
        }
        //Towards the left
        //since String is an immutable Object
        if(col > 0 && maze[row][col-1] == 1 && !visited[row][col-1]){
            visited[row][col-1] = true;
            result.addAll(solve(maze,visited,row,col-1,s+"L"));
            visited[row][col-1] = false;
        }
        //Isn't it Obvious where we are going
        if(col < maze[0].length-1 && maze[row][col+1] == 1 && !visited[row][col+1]){
            visited[row][col+1] = true;
            s += "R";
            result.addAll(solve(maze,visited,row,col+1,s));
            s = s.substring(0,s.length()-1);
            visited[row][col+1] = false;
        }
        if(row > 0 && maze[row-1][col] == 1 && !visited[row-1][col]){
            visited[row-1][col] = true;
            s += "U";
            result.addAll(solve(maze,visited,row-1,col,s));
            s = s.substring(0,s.length()-1);
            visited[row-1][col] = false;
        }
        return result;
    }


}
