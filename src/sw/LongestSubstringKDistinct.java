package sw;

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {

    int j =0;
    Map<Character, Integer> charFreq = new HashMap<>();
    int max=0;

    for(int i=0; i < str.length() ; i++) {

      while(charFreq.size() <= k && j < str.length()) {
        charFreq.put(str.charAt(j), charFreq.getOrDefault(str.charAt(j), 0) + 1);
        j++;
      }
      max = Math.max(max, j -i -1);
      if(charFreq.get(str.charAt(i)) <= 1) {
        charFreq.remove(str.charAt(i));
      }
      else {
        charFreq.put(str.charAt(i), charFreq.get(str.charAt(i)) - 1 );
      }

    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}
