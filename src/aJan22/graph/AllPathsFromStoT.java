package aJan22.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//797

/*
    complexity :  2^n possible paths and each path takes n operations to construct
    overall complexity =  O( n * 2^n)
    Also a back tracking problem.
 */

public class AllPathsFromStoT {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        dfs( graph,  0,  list);
        return ans;
    }

    private void dfs(int[][] graph, int node, LinkedList<Integer> path) {
        if(node == graph.length  - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int nei : graph[node]) {
            path.add(node);
            dfs( graph,  nei,   path);
            path.removeLast();
        }
    }


}
