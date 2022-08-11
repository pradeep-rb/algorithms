package aJan22.graph;

import java.util.*;
import java.util.stream.Collectors;

//684
/*
    revise:  Was stuck on how to prevent the bounce between two adjacent nodes during dfs given the bidirectional
    nature of the graph. Thats when the 'seen' set came to rescue.

   The 'seen' set needs to be cleared between subsequent explorations of the graph.
   Follow up: 685
 */

/*
complexity o(n^2) " : for every node added, we search every other node in the graph
 */
public class RedundantConnection {

    Set<Integer> seen = new HashSet();

    public int[] findRedundantConnection(int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge: edges) {
            seen.clear();
            if(exploreDfs(graph, edge[0], edge[1])) return edge;

            graph.computeIfAbsent(edge[0],  k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1],  k -> new ArrayList<>()).add(edge[0]);
        }

      return  null;
    }

    private boolean exploreDfs(Map<Integer, List<Integer>> graph, int src, int dest) {
        if( seen.contains(src)) return false;
        if(src == dest) return true;
        seen.add(src);

        for (int nei: graph.getOrDefault(src, new ArrayList<>())) {
            if(exploreDfs(graph, nei, dest)) return  true;
        }
        return false;
    }


    public static void main(String[] args) {

        RedundantConnection rc = new RedundantConnection();
        //rc.findRedundantConnection(new int[][]{ {1,2}, {1,3}, {2,3} }   );
        System.out.println(Arrays.stream(rc.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(",")));
    }

}
