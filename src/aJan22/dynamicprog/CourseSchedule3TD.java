package aJan22.dynamicprog;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//630
public class CourseSchedule3TD {

    Map<Pair<Integer, Integer>, Integer> memo = new HashMap();

    public int backtrack(int[][] courses, int i, int totDuration ) {

        System.out.println("i: " + i + " totDuration: " + totDuration  + " "  + memo);
        if(i > courses.length - 1)  return 0;

        int[] curr = courses[i];

        Pair<Integer, Integer> key = new Pair<>(i, totDuration);
        if(!memo.containsKey(key)) {
            memo.put(key, curr[0] + totDuration <= curr[1] ?
                    Math.max(1 + backtrack(courses, i + 1, curr[0] + totDuration),
                            backtrack(courses, i + 1, totDuration)) :
                    backtrack(courses, i + 1, totDuration)
            );
        }

        return  memo.get(key);
    }


    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        return backtrack(courses, 0 , 0);
    }


    public static void main(String[] args) {
        CourseSchedule3TD cs3 = new CourseSchedule3TD();
        //System.out.println(cs3.scheduleCourse(new int[][] {{100,200},{200,1300},{1000,1250},{2000,3200}}));
        System.out.println(cs3.scheduleCourse(new int[][] {{5,5},{4,6},{2,6}}));
    }
}
