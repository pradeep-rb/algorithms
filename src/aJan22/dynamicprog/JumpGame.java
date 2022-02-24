package aJan22.dynamicprog;

//55
public class JumpGame {

    public boolean canJump(int[] nums) {

        if(nums.length <= 1) return true;

        boolean[] dp = new boolean[nums.length];
        int n = nums.length;

        dp[0] = true;


        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[i]) break;
                dp[i] = dp[j] &&   j + nums[j] >= i ;
            }
        }

        return  dp[n-1];
    }



    public boolean canJumpBacktrack( int[] nums) {
        return canJumpBacktrack(0, nums);
    }



    public boolean canJumpBacktrack(int pos, int[] nums) {

        if(pos >= nums.length - 1) return  true;

        int farthestPos =  Math.min(pos + nums[pos], nums.length-1 );
        for (int i = pos; i < farthestPos; i++) {
            if(canJumpBacktrack(i + 1, nums)) return true;
        }

        return false;
    }




    public static void main(String[] args) {

        JumpGame jg = new JumpGame();
        //System.out.println(jg.canJump(new int[] {3,2,1,0,4} ));
        //System.out.println(jg.canJump(new int[] {2,3,1,1,4} ));
        //System.out.println(jg.canJump(new int[] {0, 2, 3} ));
        //System.out.println(jg.canJump(new int[] {2, 0, 0} ));
        System.out.println(jg.canJumpBacktrack(new int[] {3,2,1,0,4} ));
        System.out.println(jg.canJumpBacktrack(new int[] {2,3,1,1,4} ));
        System.out.println(jg.canJumpBacktrack(new int[] {0, 2, 3} ));
        System.out.println(jg.canJumpBacktrack(new int[] {2, 0, 0} ));
    }

}
