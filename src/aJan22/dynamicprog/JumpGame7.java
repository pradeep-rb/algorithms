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
