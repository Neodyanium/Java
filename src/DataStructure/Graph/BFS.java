package DataStructure.Graph;

import java.util.*;

/**
 * The breadth first search implies as the name suggests you can visualise how a breadth first works with the help of binary trees, we can use
 * similar approach for Graphs, however depending on start node the bfs will change, in case of binary trees the root is consistent there is only
 * one result of bfs, it's not same for Graphs, the first node will be level 0 and the nodes that are directly connected to it would be level 1,
 * then the nodes connected to the level 1 will be next level this will continue until all the nodes are traced.
 *
 * Most of any of the traversals will require a visited array as some of the times all nodes might not be connected, there could be different
 * connected components for the same graph hence it is necessary to maintain visited array
 */
public class BFS {

    public static void main(String[] args) {
        List<List<Integer>> adjList = getList3();
        System.out.println(adjList);
        List<Integer> ans = breadthFirstSearch(adjList,adjList.size());
        System.out.println(ans);
    }

    /**
     * The nodes here are the number of nodes and they are 0 indexed i.e. they start from 0 till node-1
     */
    public static List<Integer> breadthFirstSearch(List<List<Integer>> adjList,int nodes){
        boolean[] visited = new boolean[nodes];
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);

            for(Integer n: adjList.get(node)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }


        return bfs;
    }

    public static List<List<Integer>> getList1(){
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1,2,3));
        adjList.add(Arrays.asList());
        adjList.add(Arrays.asList(4));
        adjList.add(Arrays.asList());
        adjList.add(Arrays.asList());
        adjList.add(new ArrayList<>());
        return adjList;
    }

    public static List<List<Integer>> getList2(){
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1,2));
        adjList.add(Arrays.asList());
        adjList.add(Arrays.asList());
        return adjList;
    }

    public static List<List<Integer>> getList3(){
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1,2));
        adjList.add(Arrays.asList(6,4));
        adjList.add(Arrays.asList(5,6));
        adjList.add(Arrays.asList());
        adjList.add(Arrays.asList(7));
        adjList.add(Arrays.asList(7));
        adjList.add(Arrays.asList());
        adjList.add(Arrays.asList());
        return adjList;
    }

}
