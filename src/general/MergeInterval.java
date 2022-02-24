package general;

import java.util.*;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        Deque<int[]> queue = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> ( a[0] - b[0]) );

        queue.add(intervals[0]);
        for (int[] interval: intervals) {
            int[] topInterval = queue.peekLast();
            if(topInterval[1] >= interval[0]) {
                queue.removeLast();
                queue.addLast(new int[]{topInterval[0], Math.max(topInterval[1], interval[1])});
            }
            else {
                queue.addLast(interval);
            }
        }
        return  queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
       //int[][] ans = mi.merge(new int[][] {{15,18}, {2,6}, {1,3}, {8,10}} );
       //int[][] ans = mi.merge(new int[][] {{1,4}, {4,5}} );
        int[][] ans = mi.merge(new int[][] {{2,3}, {4,5}, {6,7}, {8,9}, {1, 10}} );
       for(int[] an: ans) {
           System.out.println(Arrays.toString(an));
       }
    }
}
