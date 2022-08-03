package aJan22.dynamicprog;

import java.util.*;
import java.util.stream.Collectors;

//140
/*
   complexity 0(n^2)  which is the number of subsets in a set
 */
public class WordBreak {
    Set<String> wordDict;
    Map<Integer, List<String>> memo = new HashMap<>();

    public List<String> getSuffixes(int start, String s) {
        if (start == s.length()) return Arrays.asList("");
        if(memo.containsKey(start)) return memo.get(start);

        List<String> ansList = new ArrayList<>();
        for (int i = start; i <= s.length(); i++) {
            String prefix = s.substring(start, i);
            if(wordDict.contains(prefix)) {
                List<String> suffixList = getSuffixes(i, s);
                for (String suffix : suffixList) {
                    StringBuilder ans = new StringBuilder(prefix);
                    if (suffix.length() > 0) {
                        ans.append(" ");
                        ans.append(suffix);
                    }
                    ansList.add(ans.toString());
                }
            }
        }
        memo.put(start, ansList);
        return ansList;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        return getSuffixes(0, s);
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        //pineapplepenapple
        wb.wordBreak("pineapplepenapple", Arrays.asList(new String[] {"apple","pen","applepen","pine","pineapple"})).stream().forEach(System.out::println);
    }

}
