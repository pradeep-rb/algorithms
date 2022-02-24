package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubSequence {

    public int longestPalindromeSubseq(String s) {

        Map<String, Integer> lookUp = new HashMap<>();

        if( s == null || s.isEmpty()) {
            return 0;
        }

        return longestPalindromeSubseq(s, 0 , s.length()-1, lookUp);
    }

    public int longestPalindromeSubseq(String s, int i, int j, Map<String, Integer> lookup) {

        if(i == j) {
            return  1;
        }
        if(i > j) return 0;

        String key = i + ":" + j;

        if(!lookup.containsKey(key)) {

            if (s.charAt(i) == s.charAt(j)) {
                lookup.put(key, 2 + longestPalindromeSubseq(s, i + 1, j - 1, lookup));
            }
            else {
                lookup.put(key, Math.max(longestPalindromeSubseq(s, i + 1, j, lookup), longestPalindromeSubseq(s, i, j - 1, lookup)));
            }

        }
        return lookup.get(key);
    }


    public static void main(String[] args) {

        LongestPalindromicSubSequence lps = new LongestPalindromicSubSequence();

        System.out.println(lps.longestPalindromeSubseq("abcdefghdb"));

    }
}
