package aJan22.dynamicprog;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    435. Non-overlapping Intervals using bottom up DP
    calculate the maximum non-overlapping intervals (similar to maximum increasing subsequence)
    subtract that from the total number of intervals.
 */
public class NonOverLappingIntervalsDP {

    public int eraseOverlapIntervals(int[][] intervals) {

        Map<Pair<Integer, Integer>, Integer>  memo = new HashMap<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int dp[] = new int[intervals.length];

        Arrays.fill(dp, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                //non over-lapping
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max( 1 + dp[j],  dp[i]);
                }
            }
        }

        return intervals.length -  dp[intervals.length - 1];
    }




    public static void main(String[] args) {
        NonOverLappingIntervalsDP noi = new NonOverLappingIntervalsDP();
        System.out.println(noi.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }

}
