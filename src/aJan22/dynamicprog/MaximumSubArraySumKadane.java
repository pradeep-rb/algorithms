package aJan22.dynamicprog;
/*

Here is the intuition behind the Kadane's algorithm
Scanning from left to right,
at every number k between 0 and n, let us make an attempt to maximize the sum of the subarray that began at an earlier point in time. we have 2 choices to maximize the sum:

a) the max subarray can begin at this number at index k (because the subarray we have seen so far unfortunately has a cumulative sum that is -ve and therefore will have to be discarded forcing us to a
begin a new subarray)

b)or the value at index k is part of the max subarray that began at an earlier point in time and the running count of this subarray is still +ve and we dont have to discard it.

The choice we make has to be the better of a and b (maximize the result ) = Max(a, b)
= Max ( num[k], currentSubArraySum + num[k] )
But as we scan through the numbers from left to right, we could encounter many such subarrays that have come and gone, whose sums are +ve but we are interested in the one whose sum is the greatest. We need a variable, lets say 'maxSum' to keep track of the maximum sum from among all the subarrays we have seen so far.
After we have made one of the 2 choices mentioned earlier to maximize the value of the current subarray's sum, we need to check if 'maxSum' (the maximum sum among all the subarray's we have seen so far) is still greater than the sum of the current subarray at index k.
maxSum = Max (maxSum, currentSubArraySum)

Thus we have the following pseudo code:

At every element k between 0 and n:
currentSubArraySum = Max ( num[k], currentSubArraySum + num[k] )
maxSum = Max (maxSum, currentSubArraySum)

This is also the intuition behind all dynamic programming problems.

 */
public class MaximumSubArraySumKadane {

    public int maxSubArray(int[] nums) {
        int max =  nums[0];
        int currSum  = nums[0];
        for(int i=1; i < nums.length ; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(max, currSum);
        }

        return max;
    }



}
