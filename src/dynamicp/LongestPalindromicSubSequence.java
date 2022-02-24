package dynamicp;

public class LongestPalindromicSubSequence {


    // LS(i,j)  =  1 + 1 + LS(i+1, j-1)                   if i == j
    // LS(i,j)  = max ( LS(i, j-1)   ,  LS(i+1, j) )     if i != j

    //this is not DP as the sub-problem computation is not optimized and needs to be memorized//
    //https://www.techiedelight.com/longest-palindromic-subsequence-using-dynamic-programming/

    static int LPS (String s, int i, int j) {
        System.out.println(i+", "+j);
        if(i > j) return 0 ;

        if(i == j) return 1 ;

        if(s.charAt(i) == s.charAt(j)) {
            return 2 + LPS(s, i+1,  j-1);
        }
        else {
            return Math.max( LPS(s, i, j-1) ,   LPS(s, i+1,  j));
        }


    }


    public static void main(String[] args) {

        String X = "ABBDCACB";
        int n = X.length();

        System.out.print("The length of Longest Palindromic sub-sequence is "
                + LPS(X, 0, n - 1));
    }
}
