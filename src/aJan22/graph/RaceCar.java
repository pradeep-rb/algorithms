package aJan22.graph;

import javafx.util.Pair;

import java.util.*;

//818
//complexity : O (speed * pos)   O(logT * T ) where T is target.
/*
    revise :  stated with dp approach. DP is more like a depth first approach that tries to find all possible
    solutions and get the min from it.

    Learning :   Knowing when to stop ->
    pos >=0  Any state change in the -ve dir will not result in a min solution as that involves undoing previous work and reversion.
    Its pbly only as good if not worse
    pos < 2 * target: No need to go beyond 2T.   when speed = 8, tgt = 8, pos = 31, no

    The  problem can be re-constituted in to a graph search problem with the graph node being a pair of speed and distance
    The BFS search on the graph can lead to the min instructions in reaching the target.

    The following DP attempt results in stack overflow as some we are not memoized and some state transitions keep happening in a loop
    and can only be solved by a visited set. Even then, it doesn't result in an answer.

    public int race(int pos, int speed, int target) {

        if(pos == target) return 0;

        if (pos >= 0  && pos < 2 * target ) {
            return  1 + Math.min(race( pos + speed, speed * 2 , target),
                    race( pos , speed > 0 ? -1 : 1 , target));
        }

        return 0;
    }

    public int racecar(int target) {
        return race(0, 1, target);
    }

 */

public class RaceCar {

    public int racecar(int target) {

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue  = new ArrayDeque<>();

        queue.add( new Pair<>(0,1));
        visited.add(queue.peek());
        int size = 1;
        int steps = 0;

        while (!queue.isEmpty())  {

            Pair<Integer, Integer> pair = queue.poll();
            int pos = pair.getKey();
            int speed = pair.getValue();

            if(pos == target) return steps;

            //A
            offer(queue, pos + speed, speed * 2, target, visited);
            //R
            offer(queue, pos , speed > 0 ? -1 : 1, target,  visited);

            if(--size == 0) {
                size = queue.size();
                steps++;
            }

        }

        return 0;
    }

    private void offer(Queue<Pair<Integer, Integer>> queue, int pos, int speed, int target,  Set<Pair<Integer, Integer>> visited) {

            Pair<Integer, Integer> pair = new Pair<>(pos, speed);
            if (pos >= 0  && pos < 2 * target && !visited.contains(pair)) {
                queue.offer(pair);
                visited.add(pair);
            }
    }

}
