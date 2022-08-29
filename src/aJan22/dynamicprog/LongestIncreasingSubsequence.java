package aJan22.dynamicprog;

import java.util.Arrays;

/*
    300. Longest Increasing Subsequence
    refer to count teams  (1395)
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i <  n; i++) {
            for (int j = 0; j < i; j++) {
              if(nums[i] > nums[j]) dp[i] =   Math.max(1 + dp[j], dp[i]);

            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lis.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lis.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lis.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }


}
