package aJan22.graph;

import java.lang.reflect.Array;
import java.util.*;

//1519
/*
    // constructed a bi-directional map to account for the cases where the edges were in reverse
    // used a visited array to keep track of the bi-directionality
 */
public class SubtreeWithSameLabel {

    int[] ans;
    Map<Integer, List<Integer>> graph= new HashMap();
    boolean[] visited;


    Map<Character, Integer> traverse(int currNode, String labels) {
        if(visited[currNode]) return new HashMap<>();
        visited[currNode] = true;

        Map<Character, Integer> sameCharCnt = new HashMap<>();
        sameCharCnt.put(labels.charAt(currNode), 1);

        for (int child: graph.get(currNode)) {
            Map<Character, Integer> childCharCnt =  traverse(child, labels);
            for (char key: childCharCnt.keySet()) {
                sameCharCnt.put(key,  sameCharCnt.getOrDefault(key, 0) + childCharCnt.getOrDefault(key, 0));
            }
        }

        ans[currNode] =  sameCharCnt.get(labels.charAt(currNode));
        return sameCharCnt;
    }


    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[labels.length()];
        visited = new boolean[n];
        for (int[] arr:  edges)   {
            graph.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(arr[1]);
            graph.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(arr[0]);
        }
        //System.out.println(graph);
        traverse(0, labels);
        return ans;
    }


    public static void main(String[] args) {
        SubtreeWithSameLabel sl = new SubtreeWithSameLabel();
        //Arrays.stream(sl.countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd")).forEach(System.out::println);
       Arrays.stream(sl.countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed")).forEach(System.out::println);

    }

}
