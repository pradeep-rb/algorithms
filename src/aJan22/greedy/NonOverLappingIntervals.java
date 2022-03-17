package aJan22.greedy;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    435. Non-overlapping Intervals

    Merged interval problem. Using backtrack and top down DP
    Very similar to CourseSchedule3.

    This is a full on greedy solution
 */
public class NonOverLappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int count = 0;
        int prev = 0;
        for (int curr = 1; curr < intervals.length ; curr++) {
            //overlap
            if(intervals[prev][1] > intervals[curr][0])  {
                if(intervals[prev][1] > intervals[curr][1]) prev = curr;
                 count++;
            }
            else prev = curr;
        }

        return count;
    }




    public static void main(String[] args) {
        NonOverLappingIntervals noi = new NonOverLappingIntervals();
        System.out.println(noi.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }

}
