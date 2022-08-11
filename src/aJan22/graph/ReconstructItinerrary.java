package aJan22.graph;

import java.util.*;

//332
/*
    revise:  note the line  String dest = destList.pollFirst(). In this problem we care about if an edge was already visited
    or not as opposed to a node.
    This line: graph.forEach( (k, v) -> Collections.sort(v)) takes care of the lexical order
    This is pretty much a variation of topological sort with a little twist in the lexical order.

    Although backtracking is one of the possible solutions, back tracking is not really necessary.
    The problem has a gaurenteed result and the dfs algorithm will indeed discover the  optimal path.

    Note that in the tree parlance this is a postOrder traversal of the graph
    Worst case complexity:  decided by sorting whose complexity depends on the graph structure
    NlogN where N = E/2 (A star graph with one noe in the center)
 */
public class ReconstructItinerrary {
    // origin -> list of destinations
    LinkedList<String> ans = new LinkedList<>();
    Map<String, LinkedList<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for ( List<String> ticket: tickets) graph.computeIfAbsent(ticket.get(0), k -> new LinkedList<>()).add(ticket.get(1));
        graph.forEach( (k, v) -> Collections.sort(v));
        dfs("JFK");
        return  ans;
    }

    private void dfs(String curr) {
        LinkedList<String> destList = graph.getOrDefault(curr, new LinkedList<>());
        while (!destList.isEmpty()) {
            String dest = destList.pollFirst();
            dfs(dest);
        }
        ans.addFirst(curr);
    }


    public static void main(String[] args) {
        ReconstructItinerrary ri = new ReconstructItinerrary();
        //ri.findItinerary(Arrays.asList(  Arrays.asList("JFK","SFO"), Arrays.asList("JFK","ATL"), Arrays.asList("SFO","ATL"), Arrays.asList("ATL","JFK") , Arrays.asList("ATL","SFO")));
        ri.findItinerary(Arrays.asList(  Arrays.asList("JFK","ZUL"), Arrays.asList("JFK","NRT"), Arrays.asList("NRT","JFK")));
    }
}
