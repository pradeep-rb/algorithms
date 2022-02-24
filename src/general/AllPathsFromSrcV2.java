package general;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrcV2 {

    List<List<Integer>>  ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList();
        path.add(0);
        dfs(graph, 0, path);
        return ans;
    }

    private void dfs(int[][] graph, int curr,  List<Integer>  currPath) {

        if(graph[curr].length == 0) {
            ans.add(new ArrayList<>(currPath));
        }
        else {
            for (int newCurr: graph[curr] ) {
                currPath.add(newCurr);
                dfs(graph,  newCurr, currPath);
                currPath.remove(currPath.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        AllPathsFromSrcV2 aps = new AllPathsFromSrcV2();
        System.out.println(aps.allPathsSourceTarget(
                new int[][]{{1,2}, {3}, {3}, {}}
        ));
    }



}
