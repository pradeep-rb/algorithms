package asep20.graphsearch.clone.graph;

import java.util.*;
//https://leetcode.com/problems/clone-graph/solution/
public class CloneGraph {

    Map<Node, Node>  visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null) return null;

        if(visited.containsKey(node)) {
            return  visited.get(node);
        }

        Node cloned = new Node(node.val, new ArrayList<>());
        visited.put(node, cloned);

        List<Node> neighbors = node.neighbors;

        for (Node neighbor: neighbors) {
            cloned.neighbors.add(cloneGraph(neighbor));
        }

        return cloned;
    }


    public static void main(String[] args) {

        CloneGraph cg = new CloneGraph();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        cg.cloneGraph(node1);

    }
}
