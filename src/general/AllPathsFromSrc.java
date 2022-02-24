package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSrc {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> path = new ArrayList();
        path.add(0);
        ans.addAll(allPathsSourceTarget(graph, 0, path));
        return ans;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph, int curr,  List<Integer>  currPath) {
        List<List<Integer>>  ans = new ArrayList<>();
        if(graph[curr].length == 0) {
            ans.add(currPath);
            return ans;
        }
        else {
            for (int j = 0; j < graph[curr].length ; j++) {
                int newCurr = graph[curr][j];
                List<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(newCurr);
                ans.addAll(allPathsSourceTarget(graph,  newCurr, newPath));

            }
        }

        return  ans;
    }




        public static void main(String[] args) {
        AllPathsFromSrc aps = new AllPathsFromSrc();
        System.out.println(aps.allPathsSourceTarget(
                new int[][]{{1,2}, {3}, {3}, {}}
        ));

    }



}
