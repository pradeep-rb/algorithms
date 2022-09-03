package aJan22.dynamicprog;

//647
/*
       0  1  2  3
       a  b  b  a
 0   a  1       1
 1   b    1  1
 2   b      1
 3   a          1

    ans = 6

    key is to fill the dp array in the following order

    33
    22 23
    11 12 13
    00 01 02 03
 */

// similar: 5. Longest Palindromic Substring

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();

        int ans = 0;
        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; i++)  dp[i][i] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || dp[i + 1][j - 1] ) dp[i][j] = true;
                    ans +=  dp[i][j] ? 1 : 0;
                }
            }
        }
        return ans;
    }

}
