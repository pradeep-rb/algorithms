package aJan22.dynamicprog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1235. Maximum Profit in Job Scheduling
// Memoized solution that still gave a TLE.  Trick is to use BS to find the next on overlapping interval to speed up things.

public class MaxProfitScheduling {

    Map<String, Integer> memo = new HashMap();

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int[][] schedule = new int[startTime.length + 1][3];

        schedule[0] = new int[] {0, 0, 0};
        for (int i = 1; i <= startTime.length; i++) {
            schedule[i][0] = startTime[i-1];
            schedule[i][1] = endTime[i-1];
            schedule[i][2] = profit[i-1];
        }

        Arrays.sort( schedule, (a, b) -> a[0] - b[0] );


        return doSchedule(0, 0,  schedule);
    }

    private int doSchedule(int currJob, int prevJob, int[][] schedule) {
        if(currJob == schedule.length  ) return 0;

        String key =   currJob + ":"  + prevJob ;
        //System.out.println( "c: " + currJob + " p: " + prevJob + " profit: " + profit );

        if (!memo.containsKey(key)) {
            int skip =  doSchedule(currJob + 1, prevJob, schedule);
            int notSkip = 0;
            if(schedule[currJob][0] >= schedule[prevJob][1]) {
                notSkip  = schedule[currJob][2] + doSchedule(currJob + 1, currJob, schedule);
            }
            int result = Math.max(skip, notSkip);

            memo.put(key, result);
         }
        return memo.get(key);
    }



    public static void main(String[] args) {

        MaxProfitScheduling mps = new MaxProfitScheduling();
        //System.out.println(mps.jobScheduling(new int[]{1,2,3,3}, new int[] {3,4,5,6}, new int[] {50,10,40,70}));
        int ans = mps.jobScheduling(new int[]{1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60});
        System.out.println(ans);
        //System.out.println(mps.jobScheduling(new int[]{1,1,1}, new int[] {2,3,4}, new int[] {5,6,4}));
    }

}
