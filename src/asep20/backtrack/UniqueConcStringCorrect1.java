package asep20.backtrack;

import java.util.*;

//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/submissions/
public class UniqueConcStringCorrect1 {

    public  boolean isUnique(String str) {
        char[] cArr = str.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (Character character: cArr) {
           if(charSet.contains(character)){
               return false;
           }
           charSet.add(character);
        }

        return  true;
    }

    public int maxLength(List<String> arr, String path, int idx) {

        int max = Integer.MIN_VALUE;

        if(idx == arr.size()) {
            return  path.length();
        }

        for (int i = idx; i < arr.size() ; i++) {
            String combined = path + arr.get(i);
            if(isUnique(combined)) {
                max = Math.max(maxLength(arr, combined, i + 1), max);
            }
            else {
                max = Math.max(max, path.length());
            }
        }

        return max;
    }


    public int maxLength(List<String> arr) {
      if(arr == null || arr.size() == 0) return  0;

      return  maxLength(arr, "", 0);
    }


    public static void main(String[] args) {
//["un","iq","ue"]

        UniqueConcStringCorrect1 unq = new UniqueConcStringCorrect1();
        //System.out.println(unq.maxLength(Arrays.asList("un","iq","ue")));
        //System.out.println(unq.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(unq.maxLength(Arrays.asList("e","tpgynpylqbyqjaf","svkgfmpgftxjjrcxxsog","bxypbbrlckiolfwpqgsoc","kwnelumrnnsryjdeppanuqbsu")));
//        System.out.println(unq.maxLength(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
        //System.out.println(unq.maxLength(Arrays.asList("cha","r","act","ers")));

    }
}
