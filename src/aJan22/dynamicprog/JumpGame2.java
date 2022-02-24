package aJan22.dynamicprog;

//45
public class JumpGame2 {

    public int jump(int[] nums) {

        if(nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        int n = nums.length;

        dp[0] = 0;

        for (int i = 1; i < n ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], j + nums[j] >= i ? dp[j] + 1 : Integer.MAX_VALUE);
            }
        }
        return  dp[n-1];
    }





    public static void main(String[] args) {

        JumpGame2 jg = new JumpGame2();
        //System.out.println(jg.canJump(new int[] {3,2,1,0,4} ));
        //System.out.println(jg.jump(new int[] {2,3,1,1,4} ));
        //System.out.println(jg.canJump(new int[] {0, 2, 3} ));
        //System.out.println(jg.canJump(new int[] {2, 0, 0} ));

//        System.out.println(jg.jumpGreedy(new int[] {2,3,1,1,4} ));
//        System.out.println(jg.jumpGreedy(new int[] {1,2} ));
//        System.out.println(jg.jumpGreedy(new int[] {2,1} ));


    }

}
