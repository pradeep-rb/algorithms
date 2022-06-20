package aJan22.graph;

import java.util.*;
//1345
/*
     revise:  * clearing this map was the key to better performance. This map keeps the index of all duplicates for a number
                once you've gone to all these duplicate indices and added their neighbors to the search path,
                there is no need to repeat the process of exploring their neighbors if you see them again.
              * for the queue remember to use the poll and add instead of push and pop

     numDuplicateMap.get(arr[currIdx]).clear();
 */
public class JumpGame4 {

    public int minJumps(int[] arr) {

        Map<Integer, List<Integer>> numDuplicateMap = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < arr.length; i++) numDuplicateMap.computeIfAbsent(arr[i] , k -> new ArrayList<>()).add(i);
        //System.out.println(numDuplicateMap);
        int idx = 0;
        queue.push(idx);
        int steps = 0;

        while ( !queue.isEmpty())  {

            int size = queue.size();
            while (size > 0) {
                int currIdx = queue.poll(); size--;

                if(visited.contains(currIdx)) continue;
                visited.add(currIdx);
                if (currIdx == arr.length - 1) return steps;

                // get all neighbors of curr index
                int prev = currIdx - 1;
                int next = currIdx + 1;
                if(prev > 0 && !visited.contains(prev)) queue.add(prev);
                if(next > 0 && !visited.contains(next) ) queue.add(next);
                for (int dIdx : numDuplicateMap.get(arr[currIdx])) {
                    if(!visited.contains(dIdx) )   queue.add(dIdx);
                }
                //  THIS LINE MADE A BIG IMPROVEMENT IN PERFOMRAMNCE
                numDuplicateMap.get(arr[currIdx]).clear();

            }
            steps++;
        }

        return -1;
    }


    public static void main(String[] args) {
        JumpGame4 jg =  new JumpGame4();
        System.out.println(jg.minJumps(new int[] {100,-23,-23,404,100,23,23,23,3,404}));
        System.out.println(jg.minJumps(new int[] {7}));
        System.out.println(jg.minJumps(new int[] {-12,-86,27,-61,-4}));
        System.out.println(jg.minJumps(new int[] {7,7,2,1,7,7,7,3,4,1}));
    }

}
