package aJan22.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

//630
/*
    if you can't add a new course, see if a course with a longer duration from earlier selections can be swapped out
    to accommodate the new course
    This follows the Greedy Pick and Undo approach
 */
public class CourseSchedule3Greedy {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a) ;
        int totalDuration = 0;

        for (int i = 0; i < courses.length ; i++) {

            if( courses[i][0] + totalDuration <= courses[i][1]){
                totalDuration += courses[i][0];
                maxHeap.add(courses[i][0]);
            }
            else if(!maxHeap.isEmpty() && maxHeap.peek() >  courses[i][0]) {
                totalDuration -= maxHeap.poll();
                totalDuration += courses[i][0];
                maxHeap.add(courses[i][0]);
            }
        }

        return maxHeap.size();
    }


    public static void main(String[] args) {
        CourseSchedule3Greedy cs3 = new CourseSchedule3Greedy();
        System.out.println(cs3.scheduleCourse(new int[][] {{100,200},{200,1300},{1000,1250},{2000,3200}}));
        System.out.println(cs3.scheduleCourse(new int[][] {{5,5},{4,6},{2,6}}));
    }
}
