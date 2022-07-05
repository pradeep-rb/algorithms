package aJan22.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//1235. Maximum Profit in Job Scheduling
//revise:  check the difference between the working and nonworking version,
// especially around memoization to understand the difference

public class MaxProfitSchedulingWithBS {

    Map<Integer, Integer> memo = new HashMap();

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int[][] schedule = makeSchedule(startTime, endTime, profit);
        //Arrays.stream(schedule).forEach( x -> System.out.println("" + x[0] ));

        return doSchedule(0,   schedule);
    }

    private int[][] makeSchedule(int[] startTime, int[] endTime, int[] profit) {
        int[][] schedule = new int[startTime.length ][3];

        for (int i = 0; i < startTime.length; i++) {
            schedule[i][0] = startTime[i];
            schedule[i][1] = endTime[i];
            schedule[i][2] = profit[i];
        }

        Arrays.sort( schedule, (a, b) -> a[0] - b[0] );
        return schedule;
    }

    private int doSchedule(int currJob, int[][] schedule) {
        if (currJob == schedule.length) return 0;

        //System.out.println("c: " + currJob + " profit: " + profit);

        if (!memo.containsKey(currJob)) {
            int skip = doSchedule(currJob + 1, schedule);
            int nextIndex = findNextNonIntersectingJob(currJob, schedule);
            int notSkip = schedule[currJob][2] + doSchedule(nextIndex, schedule);
            memo.put(currJob, Math.max(skip, notSkip));
        }

        return memo.get(currJob);

    }

    private  int findNextNonIntersectingJob(int curr, int[][] schedule) {
        int lastEndTime = schedule[curr][1];
        int low = 0 , high = schedule.length - 1;
        int nextIdx = schedule.length;

        while (low <= high) {
            int mid  =  (low + high) / 2  ;
            if(schedule[mid][0] >= lastEndTime) {
                high = mid - 1;
                nextIdx= mid;
            }
            else  low = mid + 1;

        }
        return nextIdx;
    }



    public static void main(String[] args) {

        MaxProfitSchedulingWithBS mps = new MaxProfitSchedulingWithBS();
        //System.out.println(mps.jobScheduling(new int[]{1,2,3,4}, new int[] {3,4,5,6}, new int[] {50,10,40,70}));
        System.out.println(mps.jobScheduling(new int[]{1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60}));
        //System.out.println(mps.jobScheduling(new int[]{1,1,1}, new int[] {2,3,4}, new int[] {5,6,4}));
        //System.out.println(mps.findNextNonIntersectingJob(0, mps.makeSchedule(new int[]{1,2,3,3}, new int[] {3,4,5,6}, new int[] {50,10,40,70})));
        //System.out.println(mps.findNextNonIntersectingJob(0, mps.makeSchedule(new int[]{1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60})));
    }

}
