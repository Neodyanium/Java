package DataStructure.Graph;


import java.util.ArrayList;
import java.util.List;


public class AdjacencyList {

    public static void print(List<List<Integer>> list){
        for(int i=1;i<list.size();i++){
            System.out.print(i + " -> [");
            for(int j=0;j<list.get(i).size();j++){
                if(j == list.get(i).size()-1)
                    System.out.print(list.get(i).get(j));
                else System.out.print(list.get(i).get(j) + " ");
            }
            if(i == list.size()-1)
                System.out.println("]");
            else System.out.println("],");
        }
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] relations = {{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};

        List<List<Integer>> adjList = unidirect(n,m,relations);

        print(adjList);
    }

    public static List<List<Integer>> unidirect(int n, int m, int[][] relations) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adjList.get(relations[i][0]).add(relations[i][1]);
            adjList.get(relations[i][1]).add(relations[i][0]);
        }
        return adjList;
    }

    private static List<List<Integer>> directed(int n, int m, int[][] relations) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=1;i<m;i++){
            adjList.get(relations[i][0]).add(relations[i][1]);
//            adjList.get(relations[i][1]).add(relations[i][0]);
        }
        return adjList;
    }

}
