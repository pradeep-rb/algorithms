package aJan22.heap;

import java.util.Comparator;
import java.util.TreeSet;
//480. Sliding Window Median
// solution is from the discussion section
/*
    revise:  learnt a new technique of storing index on the tree set. But the ordering on the treeset is determined
    by the value at the treeset indices. Check the comparator.
    Also better to do integer compare when big numbers are invloved, to prevent overflow
    this solution expands on the median finder problem

    Treeset is being used inseted of PQ because, the remove in treeset is O(n)
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        Comparator<Integer> comp = (a, b)  ->  nums[a] != nums[b] ?  Integer.compare(nums[a], nums[b]) : a - b;
        //  desc with smaller values
        TreeSet<Integer> maxset =  new TreeSet<>(comp.reversed());
        //  asc with large values
        TreeSet<Integer> minset =  new TreeSet<>(comp);

        for (int i = 0; i < k; i++) addIndex(i, maxset, minset);
        result[0] = getMedian(nums, maxset, minset);

        int r = 1;
        for (int i = k; i < nums.length  ; i++) {
            if( ! maxset.remove(i-k)) minset.remove(i-k);
            addIndex(i, maxset, minset);
            result[r++] = getMedian(nums, maxset, minset);
        }
        return result;
    }

    private double getMedian(int[] nums, TreeSet<Integer> maxset, TreeSet<Integer> minset) {
        return maxset.size() == minset.size() ?    ((double) nums[maxset.first()] + (double)nums[minset.first()]) * 0.5 : nums[minset.first()];
    }


    private void addIndex(int idx, TreeSet<Integer> maxset, TreeSet<Integer> minset) {
        minset.add(idx);
        maxset.add(minset.pollFirst());
        if(maxset.size() > minset.size())  minset.add(maxset.pollFirst());
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        //swm.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        swm.medianSlidingWindow(new int[] {-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 6);

    }

}
