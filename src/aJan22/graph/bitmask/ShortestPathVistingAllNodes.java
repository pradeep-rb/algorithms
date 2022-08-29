package aJan22.graph.bitmask;

import java.util.*;

//847
/*
    no of states (size of seen matrix) = N nodes * 2^N possibilities for mask
   complexity = N comparisons for every state *  N * 2^N states  = O (N^2 * 2^N)

 */
public class ShortestPathVistingAllNodes {

    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) return 0;
        int n = graph.length;
        // if n = 3, ending mask is  8 (1000) - 1 =  7 (111) which means all 3 nodes have been visited.
        int endingMask =  (1 << n) - 1;;
        // keeps track to see if a node and the path it has taken for the node to get there has already been visited or not
        // infinite bounce between parent and child is precisely avoided for this reason.
        boolean[][] seen = new boolean[n][endingMask];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)  {
            // seed the queue with all the nodes
            queue.add(new int[]{i, 1 << i});
            seen[i][ 1 << i] = true;
        }

        int steps = 0;
        while ( !queue.isEmpty()) {
            int size = queue.size();
            while ( size > 0) {
                int[] node = queue.poll();
                for (int nei: graph[node[0]]) {
                    // Or operation makes it so that it adds the new node presence in to the new mask
                    int nextMask = node[1] |  (1 << nei);
                    if( nextMask == endingMask) return  steps + 1;
                    // if a combination of the node and the other nodes visited so far has already been seen, then skip.
                    if( seen[nei][nextMask]) continue;
                    queue.add(new int[]{nei, nextMask});
                    seen[nei][nextMask] = true;
                }
                size--;
            }
            steps++;
        }


        return -1;
    }


    public static void main(String[] args) {
        ShortestPathVistingAllNodes spn = new ShortestPathVistingAllNodes();
        System.out.println(spn.shortestPathLength(new int[][] {{1,2,3}, {0}, {0}, {0}}));
    }

}
