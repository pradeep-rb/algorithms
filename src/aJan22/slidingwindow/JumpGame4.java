package aJan22.slidingwindow;

//1871
//sliding window + dp.
public class JumpGame4 {



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

        JumpGame4 jg = new JumpGame4();

        System.out.println(jg.canReach( "011010", 2, 3 ));
        System.out.println(jg.canReach( "01101110", 2, 3 ));
        System.out.println(jg.canReach( "01111111011110", 1, 9 ));

    }
}
