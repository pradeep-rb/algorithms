package aJan22.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//131

public class PalindromePartitioning {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> backtrack(String s, LinkedList<String> path, int start) {

        //System.out.println(path);
        if(start == s.length() ) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = start; i <= s.length(); i++) {
            String sChunk = s.substring(start, i);
            if(isPalindrome(sChunk)) {
                path.add(sChunk);
                backtrack(s, path, i);
                path.removeLast();
            }

        }
        return ans;
    }

    boolean isPalindrome(String text) {
        if(text.isEmpty()) return false;

        int s = 0;
        int e = text.length() - 1;
        while( text.charAt(s) == text.charAt(e) ) {
            if(s == e ||  e - s == 1) return true;
            s++; e--;
        }

        return false;
    }

    public List<List<String>> partition(String s) {
        return backtrack(s, new LinkedList<>(), 0);
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        //System.out.println(pp.partition("ablba" ));
        System.out.println(pp.partition("aab" ));
        System.out.println(pp.partition("axabb" ));
    }
}
