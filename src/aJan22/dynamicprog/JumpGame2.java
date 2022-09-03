package aJan22.dynamicprog;

import java.util.Arrays;

//45
//refer the greedy solution tha has a better time complexity.
public class JumpGame2 {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(j + nums[j] >= i ) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
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
