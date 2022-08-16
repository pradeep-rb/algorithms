package aJan22.graph;



import java.util.*;

//787. Cheapest Flights Within K Stops
// Time complexity is O(E.logV) or V^2logV
public class CheapestFlightWithKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int K) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();

        for (int[] flight: flights) graph.computeIfAbsent(flight[0], l -> new ArrayList<>()).add(new Integer[]{flight[1], flight[2]} );
        int[] hopsFromSrc = new int[101];
        Arrays.fill(hopsFromSrc, Integer.MAX_VALUE);


        // 0 : cost/dist from src, 1 : node,  2: stops
        PriorityQueue<Integer[]> queue = new PriorityQueue<>( (e1, e2) -> e1[0] - e2[0]);
        //seed the queue with 0 distance/price from src, src and 0 number of stops
        queue.add(new Integer[]{0, src, 0});

        while( !queue.isEmpty() ) {

            Integer[] curr = queue.poll();
            if(curr[1] == dest) return  curr[0];
            if(curr[2] > K) continue;


            //If I have visited this node already it means that it was the cheapest path.
            //now only allow this path to the same node if it offers better steps.
            //if not there is no reason to explore it.
            if(curr[2] >  hopsFromSrc[curr[1]]) continue;
            hopsFromSrc[curr[1]] =  curr[2];

            for (Integer[] neighbor :  graph.getOrDefault(curr[1], new ArrayList<>())) {
                queue.add(new Integer[]{curr[0] + neighbor[1], neighbor[0], curr[2] + 1});
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        CheapestFlightWithKStops cfks = new CheapestFlightWithKStops();
        //System.out.println(cfks.findCheapestPrice(3,new int[][] {{0,1,100},{1,2,100},{0,2,500}},0,2, 1));
        System.out.println(cfks.findCheapestPrice(13,new int[][] {{11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},{3,12,23},{11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},{9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},{0,5,43},{11,2,52},{11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},{12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},{9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}}, 10,1, 10));
    }
    

}

