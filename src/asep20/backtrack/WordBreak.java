package asep20.backtrack;

import general.WordLadder;

import java.util.*;
import java.util.stream.Collectors;

//140
/*
  initiallly divided recursion on both left and right halves, because simply followed the div & conq pattern.
  however, expanding the left and merging with right produces duplicates
  Another key insight is, you only do the right, if the left is in the dictionary
 */
public class WordBreak {

     Map<String, List<String>> memo = new HashMap<>();

      int cnt=0;

     public  List<String>  search(String s,  Set<String> wordDict) {
         cnt++;
        if(memo.containsKey(s)) return memo.get(s);
        if(s.length() == 0) return Collections.emptyList();

        List<String> res = new ArrayList<>();

        if (wordDict.contains(s)) {
            res.add(s);
        }

        for (int i = 0; i < s.length() ; i++) {

            List<String> rightList;
//            Set<String> leftList = new HashSet<>();

            String leftStr = s.substring(0, i );
            if(wordDict.contains(leftStr) ) {
                //leftList = search(s.substring(0, i), wordDict);
                rightList = search(s.substring(i ), wordDict);
                //for (String left : leftList) {
                    for (String right : rightList) {
                        res.add(leftStr + " " + right);
                    }
                //}
            }


        }
         memo.put(s, res);
        return  res;
    }

    public  List<String>  wordBreak(String s,  List<String> wordDict) {
         List<String> ans =  search(s,wordDict.stream().collect(Collectors.toSet()));
         return ans;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        //wb.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        wb.wordBreak("aaaaaaaaaa", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));

        System.out.print(wb.cnt);
       // wb.wordBreak("ab", Arrays.asList("a", "b"));
    }


//    public List<String> wordBreak(String s, List<String> wordDict) {
//       this.wordDict = wordDict;
//       search(s);
//       return  ans;
//    }



}
