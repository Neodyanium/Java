package DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

import static DataStructure.Graph.AdjacencyList.unidirect;

/**
 * So what you know is the number of nodes so what we can perform depth first search for the node. For different components to form there won't be
 * any edge connecting them, so we will only perform dfs when the node is not visited and apply dfs on that node, if we counted the dfs here we will
 * get the number of different components
 */
public class NumberOfConnectedComponents {
    public static void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        if(!visited[node]){
            visited[node] = true;
            for(int n : adjList.get(node)){
                dfs(n,visited,adjList);
            }
        }
    }

    public static int getComponents(List<List<Integer>> adjList,int nodes){
        boolean[] visited = new boolean[nodes+1];
        int count = 0;
        for(int i=1;i<=nodes;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,adjList);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nodes = 5;

        int[][] relations = {{1,2},{2,3},{4,5}};

        List<List<Integer>> adjList = unidirect(nodes,3,relations); //second parameter is edge

        System.out.println(adjList);

        int result = getComponents(adjList,nodes);
        System.out.println(result);
    }
}
