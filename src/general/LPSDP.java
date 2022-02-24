package general;

import java.util.Arrays;

public class LPSDP {

    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int max = Integer.MIN_VALUE;
        int[] longest = new int[2];

        for (int i = s.length() - 1 ; i >= 0 ; i--) {
            for (int j =  i; j <= s.length() - 1; j++) {
                if(i == j) {
                    dp[i][j] = true;
                }
                else if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1)  dp[i][j] = true;
                    else   {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if( dp[i][j] &&  j-i > max)  {
                   max =  j-i;
                   longest[0]=i; longest[1]=j;
                }

            }
        }
        return s.substring(longest[0], longest[1] + 1);
    }


    public static void main(String[] args) {
        LPSDP lps = new LPSDP();

        System.out.println(lps.longestPalindrome("tesetextmmtxet"));
        System.out.println(lps.longestPalindrome("aba"));
        System.out.println(lps.longestPalindrome("xabbad"));
        System.out.println(lps.longestPalindrome("cbbd"));
        System.out.println(lps.longestPalindrome("abcd"));
        System.out.println(lps.longestPalindrome("abcda"));

    }
}
