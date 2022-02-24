package asep20.heap;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> fMap  = new HashMap<>();

        for (String word: words) {
           fMap.put(word,  fMap.getOrDefault(word, 0) + 1);
        }

        Queue<Map.Entry<String, Integer>> pQ =  new PriorityQueue<>(
                (e1, e2) -> (e1.getValue().equals( e2.getValue()) ? e1.getKey().compareTo(e2.getKey()) :
                        e2.getValue() -  e1.getValue())
        );


        for(Map.Entry entry: fMap.entrySet()) pQ.add(entry);

        List<String> res = new ArrayList<>();
        while (res.size() < k) res.add(pQ.poll().getKey());  //add top k
        return res;
    }


    public static void main(String[] args) {
        TopKFrequent tf = new TopKFrequent();
        tf.topKFrequent(new String[]  {"i", "love", "leetcode", "i", "love", "coding"}, 1);
        //tf.topKFrequent(new String[]  {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
    }

}
