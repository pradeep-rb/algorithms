package aJan22.backtrack;

import javafx.util.Pair;
import sun.applet.resources.MsgAppletViewer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    435. Non-overlapping Intervals

    Merged interval problem. Using backtrack and top down DP
    Very similar to CourseSchedule3.

    Even with memoization it resulted in a TLE.
    This solution is however better and more intuitvie than the leetcode solution, which is full of errors
 */
public class NonOverLappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Map<Pair<Integer, Integer>, Integer>  memo = new HashMap<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        return eraseOverlapIntervals(intervals, 0, 1 , memo);
    }

    int eraseOverlapIntervals(int[][] intervals, int prev, int curr, Map<Pair<Integer, Integer>, Integer>  memo) {
        if (curr > intervals.length - 1) return 0;
        Pair key = new Pair(prev, curr);
        if(memo.getOrDefault(key, 0) > 0) return memo.get(key);

        if(intervals[prev][1] > intervals[curr][0]){
            memo.put(key, Math.min(1 + eraseOverlapIntervals(intervals, prev, curr+1, memo),
                                    1 + eraseOverlapIntervals(intervals, curr, curr+1, memo)));

        }
        else  memo.put(key, eraseOverlapIntervals(intervals, curr, curr+1, memo ));

        return memo.get(key);

    }



    public static void main(String[] args) {
        NonOverLappingIntervals noi = new NonOverLappingIntervals();
        System.out.println(noi.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }

}
