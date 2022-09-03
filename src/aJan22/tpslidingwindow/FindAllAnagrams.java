package aJan22.tpslidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//438. Find All Anagrams in a String
public class FindAllAnagrams {


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;

        while (right < s.length()) {
            sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0) + 1);
            if (right - left + 1 == p.length()) {
                if(sCount.equals(pCount)) ans.add(left);
                int charCount = sCount.getOrDefault(s.charAt(left), 0 );
                if( charCount > 1) sCount.put(s.charAt(left),charCount - 1);
                else sCount.remove(s.charAt(left));
                left++;
            }
            right++;
        }
        return ans;
    }





    public static void main(String[] args) {
        FindAllAnagrams fa = new FindAllAnagrams();
        System.out.println(fa.findAnagrams("cbaebabacd",  "abc"));
    }
}
