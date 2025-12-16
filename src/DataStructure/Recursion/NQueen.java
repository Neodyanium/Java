package DataStructure.Recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        int n = 4; //board Size
        boolean[][] board = new boolean[n][n];

        List<List<String>> ans = solve(0,board,new ArrayList<>(),n);
        int[] left = new int[n],upperDiagonal = new int[2*n -1],lowerDiagonal = new int[2*n-1] ;
        List<List<String>> ans2 = optimalSolve(0,board,new ArrayList<>(),n,left,upperDiagonal,lowerDiagonal);
        System.out.println(ans2);
    }

    public static List<String> construct(boolean[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<board.length;j++){
                if(board[i][j])
                    sb.append('Q');
                else
                    sb.append('.');
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static List<List<String>> solve(int col, boolean[][] board, List<List<String>> ans,int n){
        if(col == n){
            ans.add(construct(board));
            return ans;
        }

            for(int row=0;row<n;row++){
                if(isSafe(col,row,board,n)){
                    board[row][col] = true;
                    solve(col+1,board,ans,n);
                    board[row][col] = false;
                }
            }

        return ans;
    }

    private static boolean isSafe(int col, int row, boolean[][] board, int n) {
        int rowCopy = row;
        int colCopy = col;
        while(row >= 0 && col >= 0){
            if(board[row][col])
                return false;
            row--;
            col--;
        }
        col = colCopy;
        row = rowCopy;
        while(col >= 0){
            if(board[row][col]) return false;
            col--;
        }
        col = colCopy;
        while(row < n && col >=0){
            if(board[row][col]) return false;
            row++;
            col--;
        }
        return true;
    }

    //        List<List<String>> ans2 = optimalSolve(0,board,new ArrayList<>(),n,left,upperDiagonal,lowerDiagonal);

    public static List<List<String>> optimalSolve(int col,boolean[][] board,List<List<String>> ans,int n,int[] left,int[] upperDiagonal,int[] lowerDiagonal){
        //base condition
        if(col==n){
            ans.add(construct(board));
            return ans;
        }


        //logic to check for position within a column
        for(int row = 0; row <n; row++){
            if(left[row] == 0 && upperDiagonal[row+col] == 0 && lowerDiagonal[n-1 + col - row] == 0){
                board[row][col] = true;
                left[row] = 1;
                upperDiagonal[row+col] = 1;
                lowerDiagonal[n - 1 + col - row]=1;
                optimalSolve(col+1,board,ans,n,left,upperDiagonal,lowerDiagonal);
                board[row][col] = false;
                left[row] = 0;
                upperDiagonal[row+col] = 0;
                lowerDiagonal[n - 1 + col - row]=0;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int n = 1;
        boolean[][] board = new boolean[n][n];
        int[] left = new int[n],upperDiagonal = new int[2*n -1],lowerDiagonal = new int[2*n-1] ;
        List<List<String>> ans1 = solve(0,board,new ArrayList<>(),n);
        List<List<String>> ans2 = optimalSolve(0,board,new ArrayList<>(),n,left,upperDiagonal,lowerDiagonal);
        Assertions.assertEquals(ans1,ans2);
    }
}
