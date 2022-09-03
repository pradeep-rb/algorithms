package aJan22.dynamicprog;

import java.util.HashMap;
import java.util.Map;

// 91 Decode wats
/*
    Bottom up :   Dp[i] = dp[i-1](just pick, not combine. it doesn't lead to extra number of ways)
                            + dp[i-2] (combine with previous. No of ways is same as 2 places down.  It doesn't lead to extra number of ways))

 */
//Top down
public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return  decodeWays(0, s);
    }

    private int decodeWays(int i, String s) {
        if(memo.containsKey(i)) return memo.get(i);

        if(i == s.length())  return 1;
        if(s.charAt(i) == '0') return 0;
        if(i == s.length() -1)  return 1;

        int ans = 0;
        ans += decodeWays(i+1, s);
        if(Integer.parseInt(s.substring(i, i+2)) <= 26 )   ans +=  decodeWays(i+2, s);

        memo.put(i, ans);
        return ans;
    }
}
