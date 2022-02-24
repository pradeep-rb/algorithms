package asep20.backtrack;

import java.util.*;

public class UniqueConcStringTLE {

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

    public int maxLength(List<String> arr) {
        System.out.println(Arrays.toString(arr.toArray()));

        if(arr.size() == 1 ){
            return  arr.get(0).length();
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i <  arr.size() - 1 ; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                List<String> combine = new ArrayList<>(arr);

                String combinedStr =  arr.get(i) + arr.get(j);
                if(isUnique(combinedStr)) {
                    combine.remove(arr.get(i));
                    combine.remove(arr.get(j));
                    combine.add(combinedStr);
                    maxLen =  Math.max(maxLength(combine), combinedStr.length());
                }
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
//["un","iq","ue"]

        UniqueConcStringTLE unq = new UniqueConcStringTLE();
        //System.out.println(unq.maxLength(Arrays.asList("un","iq","ue")));
        //System.out.println(unq.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(unq.maxLength(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
        //System.out.println(unq.maxLength(Arrays.asList("cha","r","act","ers")));

    }
}
