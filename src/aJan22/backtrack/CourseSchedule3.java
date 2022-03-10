package aJan22.backtrack;

import java.util.Arrays;

public class CourseSchedule3 {

    /*
            backtracking without memoization (top down dp ?)  with a greedy element to it
     */

    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses,  (a, b) -> a[1] - b[1] );
        return   scheduleCourse(courses, 0, 0);
    }

    private int scheduleCourse(int[][] courses, int i,  int duration) {

        if(i == courses.length) return 0;
        int taken = 0;
        if(duration + courses[i][0] <= courses[i][1] ) taken = 1 + scheduleCourse(courses, i+1, duration + courses[i][0]);
        int notTaken = scheduleCourse(courses, i+1,  duration);

        return Math.max(taken, notTaken);
    }


    public static void main(String[] args) {
        CourseSchedule3 cs3 = new CourseSchedule3();

        System.out.println(cs3.scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200 }}));

    }
}
