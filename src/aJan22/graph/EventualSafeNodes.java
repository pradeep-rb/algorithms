package aJan22.graph;

import java.util.ArrayList;
import java.util.List;

//802
/*
    using the DFS white/black/gray technique.  If you encounter a gray node when exploring a given node, a cycle exists and therefore not safe.
    if the dfs terminates in a black node it is safe.

 */
public class EventualSafeNodes {
    List<Integer> ans =  new ArrayList<>();
    //0 -  not visited,   1 - visited, 2 - visited
    int[] visited;
    int[][] graph;

    private boolean exploreDFS(int curr ) {
        //already visited
        if( visited[curr] == 2 ) return true;
        if( visited[curr] == 1 ) return false;

        visited[curr] = 1;
        for (int nei :  graph[curr]) {
             if(!exploreDFS(nei)) return false;
        }

        visited[curr] = 2;
        return true;
    }


    public List<Integer> eventualSafeNodes(int[][] graph){
        visited = new int[graph.length];
        this.graph = graph;

        for (int i = 0; i < graph.length; i++) {
           if (exploreDFS(i)) ans.add(i);
        }

        return ans;
    }


    public static void main(String[] args) {
        EventualSafeNodes es = new EventualSafeNodes();
        es.eventualSafeNodes(new int[][] { {1,2},{2,3},{5},{0},{5},{},{}});
    }

}
