package aJan22.heap;

import java.util.Arrays;
import java.util.PriorityQueue;


//253
/*
    second solution is more intuitive.
    A PQ is to count the overlaps implicitly
    If a new interval can be swapped for an old one, the pq size stays the same (old removed and new added)
    else add a new entry there by increasing the PQ size(which holds the count for the number of rooms needed)
 */
// similar : 52 merge intervals, 1094, 452, 2251
public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {

        //min heap;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (e1, e2) -> e1[1] - e2[1]);
        Arrays.sort(intervals, (e1, e2) -> e1[0] -e2[0]);
        //Arrays.stream(intervals).forEach(x -> System.out.println(" " + x[0] + "," + x[1] ));

        int cnt = 1;
        int max = 1;

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]) {
                pq.add(intervals[i-1]);
                cnt++;
            }

            while(!pq.isEmpty() &&  pq.peek()[1]  <= intervals[i][0]) {
                pq.poll(); cnt--;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }

    public int minMeetingRooms2(int[][] intervals) {

        //min heap;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (e1, e2) -> e1[1] - e2[1]);
        Arrays.sort(intervals, (e1, e2) -> e1[0] -e2[0]);

        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if(!pq.isEmpty() &&  pq.peek()[1]  <= intervals[i][0]) {
                pq.poll();
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }



    public static void main(String[] args) {
        MeetingRooms2 mr2 = new MeetingRooms2();
        System.out.println(mr2.minMeetingRooms2(new int[][] {{0,30},{5,10},{15,20}} ));
        //System.out.println(mr2.minMeetingRooms(new int[][] {{2,11},{6,16},{11,16}} ));
        //System.out.println(mr2.minMeetingRooms(new int[][] {{4,9},{4,17},{9,10}} ));
        System.out.println(mr2.minMeetingRooms2(new int[][] {{11,20},{4,19},{13,17}, {6,13}} ));
    }
}
