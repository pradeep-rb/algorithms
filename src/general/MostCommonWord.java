package general;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph =  paragraph.toLowerCase().replaceAll("[^\\w\\s]", " ");

        String[] parts = paragraph.split("\\s+");
        Map<String, Integer> wordCntMap = new HashMap<>();
        List<String> bannedList =  Arrays.asList(banned);

        for(String part: parts) {
            if(!bannedList.contains(part))  {
                wordCntMap.put( part, wordCntMap.getOrDefault(part, 0) + 1 );
            }

        }

        return wordCntMap.entrySet().stream()
                .max( (e1, e2) -> e1.getValue() - e2.getValue())
                .get()
                .getKey();

    }

    public static void main(String[] args) {
        MostCommonWord commonWord = new MostCommonWord();

       // System.out.println(commonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(commonWord.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));

    }
}
