package aJan22.graph;

import java.util.*;

// Tarjan's Algorithm
// 1192. Critical Connections in a Network
/*
   Tarjans Algorithm does the following for every node
   *  assigns an id for every newly discovered node
   *  maintains the id of a node reachable from the current node whose id happens to be the lowest among all nodes
        reachable from the current node
 */
public class CriticalConnections {
    boolean visited[];
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    int nodeRank[]; // maintains the id of the lowest ranked node reachable from the current node.
    int id = 0;

    private void exploreDfs( int curr, int parent) {
        visited[curr] = true;
        int currRank = nodeRank[curr] = id++;

        for (int nei: graph.getOrDefault(curr, new ArrayList<>() ) ) {
            if(nei == parent) continue;
            if(!visited[nei] ) {
                exploreDfs(nei, curr);
                if(currRank < nodeRank[nei]) ans.add( Arrays.asList(curr, nei));
            }
            nodeRank[curr] = Math.min( nodeRank[curr], nodeRank[nei] );
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        for (List<Integer> connection: connections) {
            graph.computeIfAbsent(connection.get(0), k -> new ArrayList<>()).add(connection.get(1));
            graph.computeIfAbsent(connection.get(1), k -> new ArrayList<>()).add(connection.get(0));
        }
        visited = new boolean[n];
        nodeRank = new int[n];
        exploreDfs(connections.get(0).get(0), -1);
        return ans;
    }

    public static void main(String[] args) {
        CriticalConnections cc = new CriticalConnections();
        //cc.criticalConnections(4,  Arrays.asList(  Arrays.asList(0,1 ) , Arrays.asList(1, 2 ) , Arrays.asList(2,0 ), Arrays.asList(1,3 )));
        //cc.criticalConnections(6,  Arrays.asList(  Arrays.asList(0,1 ) , Arrays.asList(1, 2 ) , Arrays.asList(2,0 ), Arrays.asList(1,3 ), Arrays.asList(3,4 ), Arrays.asList(4,5 ), Arrays.asList(5,3 )));
        //cc.criticalConnections(5,  Arrays.asList(  Arrays.asList(0,1 ) , Arrays.asList(2, 0 ) , Arrays.asList(3,0 ), Arrays.asList(4,1 ), Arrays.asList(4,2 ), Arrays.asList(4,0 )));
        //cc.criticalConnections(5,  Arrays.asList(  Arrays.asList(1,0 ) , Arrays.asList(2, 0 ) , Arrays.asList(3,0 ), Arrays.asList(4,1 ), Arrays.asList(4,2 ), Arrays.asList(4,0 )));
        cc.criticalConnections(5,  Arrays.asList(  Arrays.asList(1,0 ) , Arrays.asList(2, 0 ) , Arrays.asList(3,0 ), Arrays.asList(4,0 ), Arrays.asList(2,1 ), Arrays.asList(3,2 ), Arrays.asList(4,2 )));
    }

}
