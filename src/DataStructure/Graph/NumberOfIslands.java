package DataStructure.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a grid of
 */
class Pair {
    int key;
    int value;

    public Pair(int k, int v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int[][] visited, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int r = queue.peek().getKey();
            int c = queue.peek().getValue();
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int delr = r + x[i];
                int delc = c + y[i];
                if (delr >= 0 && delr < n && delc >= 0 && delc < m && grid[delr][delc] == '1' && visited[delr][delc] == 0) {
                    visited[delr][delc] = 1;
                    queue.offer(new Pair(delr, delc));
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumberOfIslands noi = new NumberOfIslands();

        int ans = noi.numIslands(grid);
        System.out.println("Total Islands:" + ans);
    }


}
