package dynamicp;

public class MaximumSubArraySum {

    public int maxSubArray(int[] nums) {

        int dp[] = new int[nums.length];

        dp[0] =  nums[0];
        int sum =  0;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i-1] > 0 ) {
                dp[i] = Math.max(dp[i-1] + nums[i], Math.max(dp[i-1], nums[i] ));
            }
            else {
                dp[i] = Math.max(dp[i-1] + nums[i-1] + nums[i],  nums[i] );

            }

        }

        return dp[nums.length-1];
    }


    public static void main(String[] args) {

        MaximumSubArraySum mp = new MaximumSubArraySum();

        System.out.println(mp.maxSubArray(new int[] {-2,1,-3,4,-1,2,1, -5, 4}));
        //System.out.println(mp.maxSubArray(new int[] {8,-19,5,-4,20}));
    }
}
