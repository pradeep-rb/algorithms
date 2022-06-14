package aJan22.design;

import java.util.*;

//1244
/*
    just use a map.
    then in top function, copy the map entries to a pq and offer top k
 */
public class Leaderboard {

    //pq not needed.
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1]-a[1]);
    Map<Integer, int[]> scoreMap = new HashMap<>();

    public Leaderboard() {

    }

    public void addScore(int playerId, int score) {

        int[] oldEntry = scoreMap.getOrDefault(playerId, new int[]{playerId, 0});
        int[] newEntry = new int[]{playerId, oldEntry[1] + score};
        scoreMap.put(playerId, newEntry);
        maxHeap.remove(oldEntry);
        maxHeap.add(newEntry);
    }

    public int top(int K) {
        int total = 0;

        PriorityQueue<int[]> clone = new PriorityQueue<>(maxHeap);
        while( K > 0){
            total += clone.poll()[1];
            K--;
        }

        return total;
    }

    public void reset(int playerId) {
        int[] oldEntry = scoreMap.getOrDefault(playerId, new int[]{playerId, 0});
        int[] newEntry = new int[]{playerId, 0};
        scoreMap.put(playerId,  newEntry);
        maxHeap.remove(oldEntry);
        maxHeap.add(newEntry);
        //maxHeap.stream().map(x -> x[1]).forEach(System.out::println);
    }

}
