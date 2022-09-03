package aJan22.dynamicprog;

import java.util.*;


//740
/*

    revise : this involved the decomposition of the  original input array in to something that would lend itself to the
    DP model of iterating over the input set and interleaving partial results

    * Its easy to figure out that a map is needed to keep track of  total score for a given number
    * In a bottom up dp, one  usually  iterates over an input array or the dp array and fills the
    dp array using a recurrance relation.
    * recurrance relation is not super obvious as nums is not sorted and values are pretty random / non contiguous.
    * we need to pay attention to that fact that choosing nums[i] affects what happens to nums[i] + 1 and nums[i] - 1
    * its clear that we need to iterate not over, the nums array itself but from 0 to max-val in the nums array
        - some values between 0 and max-val might be missing but thats ok
    *   recurrance relation is dp[i]  =  max( gain(i) + dp[i-2] ,  dp[i-1])

 */
public class DeleteAndEarn {

    // This is a bottom up solution
    /*
        Fits the patter of dp[i]  =  max( gain(i) + dp[i-2] ,  dp[i-1])

     */
    public int deleteAndEarn(int[] nums) {

        // nums is not necessarily sorted
        // how ever,  we seem to care about nums[i] - 1 and nums[i] + 1 ( nums next to each other)
        // therefore we iterate over 0 to maxnum towards the end.

        Map<Integer, Integer> points = new HashMap<>();

        int maxNum = 0;
        for (int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num  );
            maxNum = Math.max(num, maxNum);
        }

        int dp[] = new int[maxNum + 1];
        dp[1] = points.getOrDefault(1, 0 );

        for (int i = 2; i <= maxNum; i++) {
            dp[i] =   Math.max( points.getOrDefault(i, 0) + dp[i-2], dp[i-1]);
        }

        return dp[maxNum];
    }


    public static void main(String[] args) {
        DeleteAndEarn de = new DeleteAndEarn();
        System.out.println(de.deleteAndEarn(new int[]{3,4,2}));
        System.out.println(de.deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println(de.deleteAndEarn(new int[]{3, 1}));
        System.out.println(de.deleteAndEarn(new int[]{5, 3, 7}));
        System.out.println(de.deleteAndEarn(new int[]{5, 4, 7}));
    }



}
