package dynamicp;

public class LongestPalindromicSubString {

    //not a DP solution

    //length
    static int LPS (String s, int i, int j) {
        if(i > j) return 0 ;

        if(i == j) return 1 ;
        int maxAdjacent =  Math.max(LPS(s, i+1, j ),  LPS(s, i, j-1 ));

        if( isPalindrome(s.substring(i, j+1))) {
            return Math.max( j-i+1,     maxAdjacent);
        }
        return   maxAdjacent;

    }

    static int LPS_fix (String s, int i, int j) {
        if(i > j) return 0 ;

        if(i == j) return 1 ;
        if( isPalindrome(s.substring(i, j+1))) {
            return s.length();
        }
        return Math.max(LPS(s, i+1, j ),  LPS(s, i, j-1 ));

    }


    //actual substring
    static String LPString(String s, int i, int j) {
        if(i > j) return  "";

        if(i == j) return Character.toString(s.charAt(i));

        if(isPalindrome(s.substring(i, j+1))) {
                return s.substring(i, j+1);
        }

        String r = LPString(s, i+1, j );
        String l =  LPString(s, i, j-1 );
        return r.length() > l.length() ? r : l;

    }


    public static void main(String[] args) {

        String X = "ABABBABCBABB";
        //String X = "BB";
        //String X = "babaddtattarrattatddetartrateedredividerb";
        int n = X.length();

        System.out.println("The length of Longest Palindromic substring is "
                + LPS_fix(X, 0, n - 1));

        System.out.println(" Longest Palindromic substring is "
                + LPString(X, 0, n - 1));
    }

    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }
}
