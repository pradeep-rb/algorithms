package general;

public class LPSDPString {

    public String longestPalindrome(String s) {
        int dp[][] = new int[s.length()][s.length()];
        int[] longest = new int[2];
        int max = Integer.MIN_VALUE;

        for (int i = s.length() - 1 ; i >= 0 ; i--) {
            for (int j =  i; j <= s.length() - 1; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }
                else if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1)  dp[i][j] = 2;
                    else  dp[i][j] = 2 + dp[i+1][j-1];
                }
                else dp[i][j] = Math.max(dp[i][j], Math.max(dp[i+1][j] , dp[i][j-1]));

                if(dp[i][j] > max) {
                    max = dp[i][j];
                    longest[0] = i; longest[1] = j;
                }

            }
        }
        return s.substring(longest[0], longest[1]+1);
    }


    public static void main(String[] args) {
        LPSDPString lps = new LPSDPString();

        System.out.println(lps.longestPalindrome("tesetextmmtxet"));
        System.out.println(lps.longestPalindrome("xabbad"));
        System.out.println(lps.longestPalindrome("cbbd"));
        System.out.println(lps.longestPalindrome("abcd"));
        System.out.println(lps.longestPalindrome("abcda"));

    }
}
