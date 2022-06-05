package aJan22.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
  133

  Make a deep copy of an undirected graph.


  Algorithm:
  Clone graph(node)
     if node is already visited return a reference to the clone
     clone the node and explore neighbors.
        for each neighbor CloneGraph and add the cloned neighbor to the neighbor list of the clone
  return clone

  1) how do you keep track of visited nodes
        use a map. have a reference to the cloned node as the value
  2) How to explore the graph ?
       use dfs / recursion
  3) Since the graph is undirected, do you need to keep track of where a node was visited from ?
       not necessary. If a node has already been visited, just return a reference to its clone which is stored in the map

 */

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    Map<Node, Node> visited = new HashMap();

    public Node cloneGraph(Node node) {
        if(node == null)  return null;
        if(visited.containsKey(node))  return visited.get(node);

        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone) ;

        for(Node nei: node.neighbors) {
            Node clonedNei = cloneGraph(nei);
            clone.neighbors.add(clonedNei);

        }

        return clone;
    }


}
