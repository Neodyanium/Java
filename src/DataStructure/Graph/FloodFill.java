package DataStructure.Graph;

import static DataStructure.Arrays.ConvertGrid.print;

/**
 * From a starting node you can paint the left right top bottom blocks with the new color. The rule to paint is you can only paint the block which
 * was of old Color provided at the start. This can be solved with dfs or bfs
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        print(floodFill(image,2,0,3));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] result = image.clone();
        int[][] visited = new int[image.length][image[0].length];
        dfs(result, visited, sr, sc, color, image[sr][sc]);
        return result;
    }

    public static void dfs(int[][] grid, int[][] visited, int row, int col, int newColor, int oldColor) {
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        if (visited[row][col] == 0 && grid[row][col] == oldColor) {
            grid[row][col] = newColor;
            visited[row][col] = 1;

            for (int i = 0; i < 4; i++) {
                int newr = row + x[i];
                int newc = col + y[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m) {
                    dfs(grid, visited, newr, newc, newColor, oldColor);
                }
            }
        }
    }

    int count =0, oldColor =0;
    public int[][] floodFillOpt(int[][] image, int sr, int sc, int color) {
        if(count == 0){
            oldColor = image[sr][sc];
            count++;
        }
        if((sr < 0 || sr >= image.length) || (sc < 0 || sc >= image[0].length)){
            return image;
        }
        if(image[sr][sc] != oldColor){
            return image;
        }
        if(image[sr][sc] == color){
            return image;
        }
        image[sr][sc]=color;
        floodFill(image,sr,sc-1,color);
        floodFill(image,sr,sc+1,color);
        floodFill(image,sr-1,sc,color);
        floodFill(image,sr+1,sc,color);
        return image;
    }
}

