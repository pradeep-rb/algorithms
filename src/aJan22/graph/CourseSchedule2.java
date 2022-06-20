package aJan22.graph;

import java.util.*;
import java.util.stream.Collectors;

//210  topological sort by dfs
/*
The tricky part is cycle detection.  DFS alone requires only two states : not visited and visited
revise:  Cycle detection needs a 3rd state : visiting.  Use int[] visited instead of boolean[] visited
 */
public class CourseSchedule2 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite: prerequisites){
            if(prerequisite.length > 0) graph.computeIfAbsent( prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
        }

        Deque<Integer> result = new LinkedList<>();
        int[] visited = new int[numCourses];

        for (int node = 0; node < numCourses; node++) {
            if(exploreDfs(node, graph,  result, visited)) return new int[]{};
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    /*
        0  unvisited
        1  visiting
        2 visited
        returns true if cycle exits
     */
    private boolean exploreDfs(int node, Map<Integer, List<Integer>> graph, Deque<Integer> result, int[] visited ) {

        if(visited[node] == 2 ) return false;
        if(visited[node] == 1 ) return true; //cycle exists

        visited[node] = 1;

        for (int neighbor: graph.getOrDefault(node, new ArrayList<>())) {
            if(exploreDfs(neighbor, graph, result, visited)) return true;
        }
        result.addFirst(node);
        visited[node] = 2;

        return false;
    }


    public static void main(String[] args) {
        CourseSchedule2 cs2 = new CourseSchedule2();
        Arrays.stream(cs2.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})).forEach(System.out::println);
        //Arrays.stream(cs2.findOrder(1, new int[][]{{}})).forEach(System.out::println);
        //Arrays.stream(cs2.findOrder(2, new int[][]{{}})).forEach(System.out::println);
        Arrays.stream(cs2.findOrder(2, new int[][]{{0,1},{1,0}})).forEach(System.out::println);
    }

}
