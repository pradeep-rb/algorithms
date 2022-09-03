package aJan22.tpslidingwindow;

import java.util.HashMap;
import java.util.Map;

//3
// a good problem to show speed vs memory trade-offs
public class LongsSubstNoRepeatChar {

    //solution 1.  Clearing the map is a better solution if memory is an isusue and you cant store the entire map in memory.
    public int lengthOfLongestSubstringAttempt1(String s) {
        int max =  0;
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if( windowMap.containsKey(s.charAt(i))){
                int foundIdx =  windowMap.get(s.charAt(i));
                // remove all chars between left and charATi
                for (int j = left; j <= foundIdx; j++)  windowMap.remove(s.charAt(j));
                left = foundIdx + 1;
            }
            max = Math.max(max, i + 1 - left);
            windowMap.put(s.charAt(i), i);
        }
        return max;
    }


    //more optimized solution

    public int lengthOfLongestSubstring(String s) {
        int max =  0;
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // No need to remove all the characters between left and the new sport what it was found, just prevent
            //left from going backwards to the previous occurance
            if( windowMap.containsKey(s.charAt(i))) left =   Math.max(windowMap.get(s.charAt(i)) + 1, left );
            max = Math.max(max, i + 1 - left);
            windowMap.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        LongsSubstNoRepeatChar ls = new LongsSubstNoRepeatChar();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ls.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ls.lengthOfLongestSubstring("a"));
        System.out.println(ls.lengthOfLongestSubstring(""));
        System.out.println(ls.lengthOfLongestSubstring("au"));
        System.out.println(ls.lengthOfLongestSubstring("dvdf"));

           // 3 3 1 1 0 2 3

    }

}
