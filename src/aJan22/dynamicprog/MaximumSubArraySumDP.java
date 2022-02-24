package aJan22.dynamicprog;

public class MaximumSubArraySumDP {

    public int maxSubArray(int[] nums) {
        int max =  nums[0];

        //dp[k] is max sum of all possible subarray's whose index end at k.
        int dp[] = new int[nums.length];
        dp[0]  = nums[0];
        for(int i=1; i < nums.length ; i++) {
           dp[i]  =  Math.max( dp[i-1] + nums[i] , nums[i] );
           max  = Math.max(max, dp[i]);
        }

        return max;
    }
}
