package aJan22.dynamicprog.burstballloon;

public class BurstBalloonTD {


    private int maxCoins(int[] nums, int left, int right, int[][] memo) {

        if (right - left < 0) return 0;
        if(memo[left][right] > 0 ) return memo[left][right];

        int result = Integer.MIN_VALUE;

        for (int i = left; i <= right ; i++) {

            int product =  nums[left-1] * nums[i] * nums[right+1];
            int remaining = maxCoins(nums,  left,i -1, memo)    +   maxCoins(nums, i+1, right, memo);
            result = Math.max(remaining + product, result);
            memo[left][right] = result;
        }

        return result;
    }

    public int maxCoins(int[] nums) {

      int n = nums.length;
      int[] newnums = new int[n+2];
      System.arraycopy(nums, 0, newnums, 1, n );
      newnums[0] = 1; newnums[n+1] =  1;
      int[][] memo = new int[n+1][n+1];

      return  maxCoins(newnums, 1,  n, memo);

    }



    public static void main(String[] args) {
        BurstBalloonTD bb = new BurstBalloonTD();
        System.out.println(bb.maxCoins(new int[] {3,1,5,8}));
    }
}
