package DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {


    public static void main(String[] args) {
        boolean[] visited = new boolean[BFS.getList1().size()];
        List<Integer> dfs = new ArrayList<>();
//        dfs.add(0);
//        visited[0] = true;
        List<Integer> result = depthFirstSearch(visited,dfs,BFS.getList1(),0);
        System.out.println(result);
    }

    private static List<Integer> depthFirstSearch(boolean[] visited, List<Integer> dfs, List<List<Integer>> adjList,int node) {
        if(!visited[node]){
            visited[node] = true;
            dfs.add(node);
            for(Integer n : adjList.get(node)){
                depthFirstSearch(visited,dfs,adjList,n);
            }
        }
        return dfs;
    }


}
