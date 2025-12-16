package DataStructure.Graph;

import static DataStructure.Arrays.ConvertGrid.print;

public class AdjacencyMatrix {

    /**
     * You are given that there are n nodes and m edges.
     * eg: N=5  and M=6
     * 1 2
     * 1 3
     * 3 4
     * 2 4
     * 2 5
     * 4 5
     * It's a unidirectional graph, so the path goes both ways, we can use array of array to represent the edges between 2 nodes.
     * This should be used when the graph nodes are 0/1 indexed or smaller as array is used to store them
     */
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] relations = {{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};

        int[][] adjMat = unidirect(n,m,relations);

        print(adjMat);

        adjMat = direct(n,m,relations);

        print(adjMat);

    }

    private static int[][] direct(int n, int m, int[][] relations) {
        int[][] arr = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int u = relations[i][0] , v = relations[i][1];
            arr[u][v] = 1;
        }
        return arr;
    }

    private static int[][] unidirect(int n, int m, int[][] relations) {
        int[][] arr = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int u = relations[i][0] , v = relations[i][1];
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        return arr;
    }


}
