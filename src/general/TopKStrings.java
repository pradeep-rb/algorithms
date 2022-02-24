package general;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class TopKStrings {

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> topMap  = new HashMap<String, Integer> ();

        for(String word: words) {
            topMap.put(word, topMap.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> sortedMap = topMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                //.collect(Collectors.toMap( e1 -> e1.getKey(), e2 -> e2.getValue() ));

        Queue topNQ = new PriorityQueue<Map.Entry<String, Integer>>((e1, e2) -> e1.getValue().equals(e2.getValue())?  e1.getKey().compareTo(e2.getKey())
        :   e1.getValue() - e2.getValue() );

        for(Map.Entry<String, Integer> entry: topMap.entrySet()) {
            topNQ.offer(entry);
            if(topNQ.size() > k) {
                topNQ.poll();
            }
        }

        PriorityQueue<String> heap = new PriorityQueue<String>(
                    (w1, w2) -> topMap.get(w1).equals(topMap.get(w2)) ?
                        w1.compareTo(w2) : topMap.get(w1) - topMap.get(w2) );

        for (String word: topMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        System.out.println(sortedMap);
        System.out.println(topNQ);
        System.out.println(heap);


        return null;
    }




    public static void main(String[] args) {

        String[] inputs = new String[] {"abc","rst" ,"abc" ,"rst" ,"abc" , "xyz", "bbc", "acc"};

        TopKStrings.topKFrequent(inputs, 3);

    }
}
