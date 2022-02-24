package general;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        Map<String, List<String>> wordDict = new HashMap<>();

        for (String word: wordList) {

            for (int i = 0; i < word.length(); i++) {
                String maskedKey =  word.substring(0, i) + "*" + word.substring(i+1);
                List<String> matches =  wordDict.getOrDefault(maskedKey, new ArrayList<>());
                matches.add(word);
                wordDict.put(maskedKey, matches );
            }
        }

        Map<String, Boolean> visited = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();
        visited.put(beginWord, true);
        queue.add(beginWord);
        int level = 1;



        while( !queue.isEmpty()) {

            int qSize = queue.size();
            while(qSize > 0) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    return level;
                }
                for (int i = 0; i < word.length() ; i++) {
                    String maskedWord =  word.substring(0, i) + "*" + word.substring(i+1);
                    List<String> matches =  wordDict.getOrDefault(maskedWord, new ArrayList<>());
                    for(String matchWord : matches) {

                        if( ! visited.containsKey(matchWord)){
                            queue.add(matchWord);
                            visited.put(matchWord, true);
                        }
                    }
                }
                qSize--;
            }
            level++;
        }


        return 0;
    }


    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        int answer = 0;

         answer = wl.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(answer);


         answer = wl.ladderLength("a", "c", Arrays.asList(new String[]{"a","b","c"}));
        System.out.println(answer);

    }
}
