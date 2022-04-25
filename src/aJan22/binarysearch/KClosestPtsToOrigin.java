package aJan22.binarysearch;

import java.util.ArrayList;
import java.util.List;

/*
    note: all points are distinct
    The trick is to have a target distance (mid)and look through he search space to find points that are closer to the
    target distance.
    If target distance is low, increase it by a factor of half, if it is high reduce it  by a factor of half

    complexity : O(n)
    At every iteration of the binary search algorithm, the search space is reduced by 1/2


    questions
    1)   how to choose the first target distance ?
         mid = (low + high) / 2
    2) how to find the next target distance  ?
        either  high = mid  or  low = mid;
    3) when does the search (while loop ) end ?
        as you find some pts < k that are closer then k -= closer.size()
        so run the search until k > 0

 */
public class KClosestPtsToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        List<Integer> remaining = new ArrayList<>();
        double[] distances = new double[points.length];
        double high = 0;
        double low = 0;
        for (int i = 0; i < points.length ; i++) {
            distances[i] = euclideanDistance(points[i]);
            high = Math.max(distances[i], high);
            remaining.add(i);
        }

        List<Integer> closest = new ArrayList<>();

        while(K > 0) {

            double mid =  (low + high) / 2 ;

            List<List<Integer>> result =  splitDistances(remaining, distances,  mid);
            List<Integer> closer = result.get(0);
            List<Integer> farther = result.get(1);

            if(closer.size() > K){
                remaining = closer;
                high = mid;
            }
            else {
                K -= closer.size();
                remaining = farther;
                low = mid;
                closest.addAll(closer);
            }

        }

        K = closest.size();
        int[][] answer = new int[K][2];
        for (int i = 0; i < K; i++) {
            answer[i] = points[closest.get(i)];
        }
        return answer;

    }

    private List<List<Integer>> splitDistances(List<Integer> remaining, double[] distances, double mid) {
        List<Integer> closer = new ArrayList<>();
        List<Integer> farther = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int ptIdx: remaining) {
            if(distances[ptIdx] > mid) farther.add(ptIdx);
            else closer.add(ptIdx);
        }

        result.add(closer);
        result.add(farther);
        return result;
    }


    private double euclideanDistance(int[] point) {
        return point[0] * point[0]  + point[1] * point[1];
    }
}
