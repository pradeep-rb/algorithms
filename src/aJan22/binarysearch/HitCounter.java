package aJan22.binarysearch;

import javafx.util.Pair;
import jdk.nashorn.internal.IntDeque;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.jar.JarOutputStream;


//362. Design Hit Counter
// Solution is better than the official answer
public class HitCounter {

    LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

    public HitCounter() {
        queue.add(new Pair<>(0, 0));
    }

    public void hit(int timestamp) {

        if(queue.getLast().getKey() == timestamp ) {
            Pair<Integer, Integer> top = queue.removeLast();
            queue.add(new Pair (top.getKey(), top.getValue() + 1));
        }
        // every entry is a pair of timestamp and a prefix sum of the counts
        else queue.add( new Pair<>(timestamp,  queue.getLast().getValue() + 1 ));
        if(queue.size() > 300) queue.remove();

    }

    public int getHits(int timestamp) {
        int start = timestamp > 300 ?  timestamp - 300 : 0;
        // uses the property of prefix sum that gives the sum of all values within the range.\
        return queue.getLast().getValue() - queue.get( binarySearch(start)).getValue();
    }

    int binarySearch(int ts) {

        int low = 0;
        int high = queue.size() - 1;

        while (low < high) {
            int mid =  (low + high) / 2  + 1;
            int val = queue.get(mid).getKey();
            if(val <= ts ) low = mid;
            else high = mid - 1;
        }

        return  low;
    }


    public static void main(String[] args) {

        HitCounter hc = new HitCounter();
        hc.hit(1);
        hc.hit(2);
        //hc.hit(2);
        hc.hit(3);
        hc.hit(300);

        System.out.println(hc.getHits(300));
        System.out.println(hc.getHits(303));


    }


}
