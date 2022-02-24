package asep20.graphsearch;

import java.util.*;
//787
public class CheapestFlightsOpt {

    Map<Integer, List<Integer[]>>  graph = new HashMap<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        for(int[] flight: flights) {
            graph.computeIfAbsent(flight[0], k ->  new ArrayList<>()).add(new Integer[]{flight[2], flight[1]});
        }

        //optional to prune the branches. In reality, runs faster without memo
        Map<Integer, Integer[]> memo = new HashMap<>();

        Queue<Integer[]> q = new PriorityQueue<>(Comparator.comparing(e -> e[0]));
        q.add(new Integer[]{0, src, 0});
        memo.put(src, new Integer[]{0, 0});

        while(!q.isEmpty()) {
            Integer[] node = q.poll();
            if(node[2] > K + 1) continue;
            if(node[1] == dst) return node[0];

            if(graph.containsKey(node[1])) {
                for(Integer[] nei:  graph.get(node[1])) {
                    if(memo.containsKey(nei[1])) {
                        Integer[] cache = memo.get(nei[1]);
                        if (node[0] + nei[0] < cache[0]) {
                            q.offer(new Integer[]{node[0] + nei[0], nei[1], node[2] + 1});
                            memo.put(nei[1], new Integer[]{node[0] + nei[0], cache[1]});
                        } else if (node[2] + 1 < cache[1]) {
                            q.offer(new Integer[]{node[0] + nei[0], nei[1], node[2] + 1});
                            memo.put(nei[1], new Integer[]{cache[0], node[2] + 1});
                        }
                    }
                    else {
                        q.offer(new Integer[]{node[0] + nei[0], nei[1], node[2] + 1});
                    }
                }

            }
        }
        return  -1;
    }


    public static void main(String[] args) {
        CheapestFlightsOpt ch = new CheapestFlightsOpt();

        System.out.println( ch.findCheapestPrice(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0 ,2, 0));
       // System.out.println( ch.findCheapestPrice(5, new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}}, 2 ,1, 1));
    }



}
