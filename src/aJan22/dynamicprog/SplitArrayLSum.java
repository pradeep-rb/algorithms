package aJan22.dynamicprog;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//410
/*
    Two ways to solve this
    1) using original array (no prefix) doesn't lend itself very well to memoization
    2) using prefix sum array. Can be memoized more efficiently

 */
public class SplitArrayLSum {

    //int ans = Int

    public int backtrack1(int[] nums, int splitsLeft,  int start, int maxSum, int sumSoFar ) {

        //if(start == nums.length && splitsLeft == 0)
            //System.out.println("start " + start + " splitsLeft " + splitsLeft + " maxSum " + maxSum +  " sumSoFar " + sumSoFar );

        if(splitsLeft == 0 && start > nums.length -  1 ) return  maxSum;
        else if( (splitsLeft > 0 && start > nums.length -  1) || splitsLeft < 0) return  Integer.MAX_VALUE;

        int notSplit = backtrack1(nums, splitsLeft , start + 1, Math.max(maxSum, sumSoFar + nums[start]  ), sumSoFar + nums[start]);
        int split = backtrack1(nums, splitsLeft - 1 , start + 1, Math.max(maxSum, sumSoFar ), nums[start]);


        return Math.min( notSplit , split);

    }


    public int splitArray1(int[] nums, int m) {
        return backtrack1(nums, m-1, 0, 0, 0);
    }


    /*
        revise :  complexity =  n * (n * m states) = o(n^2m)
     */
    public int backtrack( int start, int spitsLeft, int[] prefixSum, Integer[][]  memo) {
        //String key =  start + ":" + spitsLeft;
        if(memo[start][spitsLeft] != null) return memo[start][spitsLeft];  //  n * m states

        if (spitsLeft == 0) return prefixSum[prefixSum.length - 1] - prefixSum[start];

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < prefixSum.length; i++) {

            int leftSum  =  prefixSum[i] - prefixSum[start];
            int rightSum =    backtrack( i, spitsLeft-1,  prefixSum, memo);
            //System.out.println("l " + leftSum + " r " + rightSum + " s " + start );
            min = Math.min(min, Math.max(leftSum, rightSum));
        }

       return memo[start][spitsLeft] = min;

    }


    public int splitArray(int[] nums, int m) {

        int[] prefixSum =  new int[nums.length + 1];
        Integer[][] memo = new Integer[1001][51];

        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] +  nums[i-1];
        }
        //System.out.println(Arrays.toString(prefixSum));
        return backtrack(0, m-1, prefixSum, memo);

    }




    public static void main(String[] args) {
        SplitArrayLSum splitArrayLSum = new SplitArrayLSum();

        //System.out.println(splitArrayLSum.splitArray1(new int[] {7,2,5,10,8}, 2) );
        System.out.println(splitArrayLSum.splitArray(new int[] {7,2,5,10,8}, 2) );
       // System.out.println(splitArrayLSum.splitArray(new int[] {1, 4, 4}, 4) );
    }
}
