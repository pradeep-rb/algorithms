package general;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElement {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue();

        //queue.addAll(Arrays.asList(nums));

        for(int i: nums) {
            queue.add(i);
            if(queue.size() > k) {
                queue.poll();
            }

        }


        return queue.poll();
    }


    public static void main(String[] args) {
        KLargestElement klarge = new KLargestElement();

        System.out.println(klarge.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

}
