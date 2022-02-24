package dynamicp;

public class MaximumProductDP {

    public int maxProduct(int[] nums) {

        int[] dp = new int[nums.length +1];

        dp[0] = nums[0];
        dp[nums.length] = nums[nums.length-1];

        int product = 1;
        for (int i = 1; i <= nums.length ; i++) {
            for (int j = 0; j < i; j++) {

                    for (int k = j; k < i ; k++) {
                        product *= nums[k];

                    }

                dp[i] = Math.max(Math.max(product, dp[i-1]), dp[i]);
            }
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        MaximumProductDP mp = new MaximumProductDP();
        System.out.println(mp.maxProduct(new int[] {-3,0,1,-2}));

    }
}
