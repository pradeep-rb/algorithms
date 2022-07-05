package aJan22.backtrack;

import java.util.Arrays;

//630. Course Schedule III
public class CourseSchedule3Memo {

    /*
            backtracking with memoization (top down dp ?)
     */



    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses,  (a, b) -> a[1] - b[1] );
        //size of the memo is course length * the max last day of all the courses
        Integer[][] memo = new Integer[courses.length][courses[courses.length - 1][1] + 1];

        return   scheduleCourse(courses, 0, 0, memo);
    }

    private int scheduleCourse(int[][] courses, int i,  int duration, Integer[][] memo) {

        if(i == courses.length) return 0;
        if (memo[i][duration] != null) return memo[i][duration];
        int taken = 0;
        if(duration + courses[i][0] <= courses[i][1] ) taken = 1 + scheduleCourse(courses, i+1, duration + courses[i][0], memo);
        int notTaken = scheduleCourse(courses, i+1,  duration, memo);
        memo[i][duration] = Math.max(taken, notTaken);
        return  memo[i][duration];
    }


    public static void main(String[] args) {
        CourseSchedule3Memo cs3 = new CourseSchedule3Memo();

        System.out.println(cs3.scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200 }}));

    }
}
