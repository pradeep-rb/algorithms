package aJan22.greedy;

import java.util.Arrays;

//45
public class JumpGame2 {
   /*
        one pass solution :  This is a greedy solution.
        Greedily jump in the beginning and increment step count. But until you reach the index we jumped to,
        keep calculating the furthest you can reach.
        When you reach the current jump index, there may be new evidence that suggests  the jump might mot
        not have been the best move. Therefore jump to the new furthest location. We'll need to increment the step count
        as it would have taken us one jump anyways to get to this place.
        Repeat the above process until we reach the end of the array and return the steps.


    */

    public int jumpAlt(int[] nums) {

        int steps = 0;
        int currJump = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1 ; i++) {

            farthest = Math.max(farthest, i + nums[i] );

            if(i == currJump) {
                currJump = farthest;
                steps++;
            }
        }
        return  steps;
    }


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
        //
        //System.out.println(jg.jump(new int[] {2,3,1,1,4} ));
        //System.out.println(jg.canJump(new int[] {0, 2, 3} ));
        //System.out.println(jg.canJump(new int[] {2, 0, 0} ));

        System.out.println(jg.jump(new int[] {4,1,1,3,1,1,1} ));
//        System.out.println(jg.jump(new int[] {2,3,0,1,4} ));
//        System.out.println(jg.jump(new int[] {2,3,1,1,4} ));
//        System.out.println(jg.jump(new int[] {1,2} ));
//        System.out.println(jg.jump(new int[] {2,1} ));
        //2211

    }

}
