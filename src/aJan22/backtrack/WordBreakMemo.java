package aJan22.backtrack;

import java.util.*;

//140 word break 2
public class WordBreakMemo {

    Map<String, List<String>> memo = new HashMap<>();

    public   List<String> wordBreak(String s, List<String>dict) {
        return wordBreak(s, new HashSet<>(dict));
    }

    private    List<String> wordBreak(String s, Set<String>dict) {
        if(memo.containsKey(s)) return memo.get(s);
        if(s.isEmpty()) return  new ArrayList<>();
        List<String> ans = new ArrayList<>();

        if(dict.contains(s)) {
            ans.add(s);
        }
        for (int i = 1; i <= s.length() ; i++) {
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)) {
                List<String> sentenceList = wordBreak(s.substring(i), dict);
                for (String sentence: sentenceList) {
                    ans.add(prefix + " " + sentence);
                }
            }
        }
        memo.put(s, ans);
        return ans;
    }



    public static void main(String[] args) {
        WordBreakMemo wb = new WordBreakMemo();
        wb.wordBreak("pineapplepenapple", Arrays.asList(new String[] {"apple","pen","applepen","pine","pineapple"})).stream().forEach(System.out::println);
        wb.wordBreak("catsanddog", Arrays.asList(new String[] {"cats","dog","sand","and","cat"})).stream().forEach(System.out::println);

    }
}
