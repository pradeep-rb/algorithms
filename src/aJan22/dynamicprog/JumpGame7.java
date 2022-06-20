package aJan22.dynamicprog;

//1871
public class JumpGame7 {


    public boolean canReach0(String s, int minJump, int maxJump) {
        boolean dp[] = new boolean[s.length()];

        dp[0]  = true;
        for (int i = 1; i <  s.length(); i++) {
            if(s.charAt(i) == '1') continue;
            for (int j = Math.max(i - maxJump, 0 ) ; j <=  Math.max(i- minJump, 0); j++) {
                dp[i] =  dp[i] || dp[j];
            }
        }

        return  dp[s.length()-1];
    }

    /*

          revise:
            1) dint quite catch that the sliding window started at the left of 0 and therefore grew from size 0 to max - min.
                therefore no pre-processing necessary
            2) wasted time figuring out where the iteration should start and end.
                    it was just easier to put guarrds in place to prevent Array out of bounds errors. Code is simpler and less error prone
             3) Missed to check DP[left] and DP[right] for this is the true reach-ability check. Not sufficient to just
                                                                                 check of charAt(left) or charAt(right) == '0'

     */

    public boolean canReachSW(String s, int minJump, int maxJump) {

        int lastIndex = s.length() - 1;
        boolean dp[] = new boolean[lastIndex + 1];
        dp[0] = true;

        int left = minJump - maxJump;
        int nz = 0;
        for (int i = 0; i <= lastIndex - minJump ; i++) {
            if(dp[i]) nz++;
            if(nz > 0 ) dp[ i + minJump] = s.charAt(i + minJump) == '0';
            if(left >= 0 && dp[left])  nz--;
            left++;

        }
        return dp[lastIndex ];
    }

     //see prev attempt
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean dp[] = new boolean[s.length()];

        dp[0]  = true;
        int nZ = 0;
        for (int i = 1; i <  s.length(); i++) {
            if (i - minJump >= 0  && dp[i - minJump]) nZ++;
            dp[i] = nZ > 0  && s.charAt(i) == '0';
            if (i - maxJump >= 0  && dp[i - maxJump]) nZ--;
        }

        return  dp[s.length()-1];
    }


    public static void main(String[] args) {

        JumpGame7 jg = new JumpGame7();

        System.out.println(jg.canReach( "011010", 2, 3 ));
        System.out.println(jg.canReach( "01101110", 2, 3 ));
        System.out.println(jg.canReach( "01111111011110", 1, 9 ));

    }
}
