package asep20.backtrack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/submissions/
public class UniqueConcStringCorrect2 {

    int result = Integer.MIN_VALUE;

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

    public void maxLength(List<String> arr, String path, int idx) {

        if(isUnique(path)) {
            result = Math.max(result, path.length());
        }
        else  return;
        if (idx == arr.size()) return;

        for (int i = idx; i < arr.size() ; i++) {
          maxLength(arr, path + arr.get(i), i + 1);
        }

    }


    public int maxLength(List<String> arr) {
      if(arr == null || arr.size() == 0) return  0;
      maxLength(arr, "", 0);

      return result;
    }


    public static void main(String[] args) {
//["un","iq","ue"]

        UniqueConcStringCorrect2 unq = new UniqueConcStringCorrect2();
        //System.out.println(unq.maxLength(Arrays.asList("un","iq","ue")));
        //System.out.println(unq.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(unq.maxLength(Arrays.asList("e","tpgynpylqbyqjaf","svkgfmpgftxjjrcxxsog","bxypbbrlckiolfwpqgsoc","kwnelumrnnsryjdeppanuqbsu")));
//        System.out.println(unq.maxLength(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
        //System.out.println(unq.maxLength(Arrays.asList("cha","r","act","ers")));

    }
}
