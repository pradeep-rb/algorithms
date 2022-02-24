package asep20.graphsearch.dijkstra;

import java.util.*;

public class NetworkDelayTimeWrongV {
//https://leetcode.com/problems/network-delay-time/submissions/
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();

        Map<Integer, Integer> dist = new HashMap();

        Queue<Integer[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);

        for(int[] edge   : times) {
            graph.computeIfAbsent( edge[0], k -> new ArrayList<>()).add(new Integer[] {edge[1], edge[2]});
        }

        dist.put(K, 0);
        pq.offer(new Integer[]{dist.get(K), K});

        while (!pq.isEmpty()) {
            Integer[] node = pq.poll();
            Integer grapheNode = node[1];
            if(graph.containsKey(grapheNode)) {
                List<Integer[]> neighbors = graph.get(grapheNode);
                for (Integer[] neighbor : neighbors) {
                    Integer nodeWeight = node[0];
                    Integer neiNode = neighbor[0];
                    Integer neiWeight = neighbor[1];
                    if (!dist.containsKey(neiNode) ) {
                        dist.put(neiNode, nodeWeight + neiWeight);
                         pq.offer(new Integer[]{nodeWeight + neiWeight, neiNode});
                    }
                    else if (dist.get(neiNode) > nodeWeight + neiWeight){
                           dist.put(neiNode, nodeWeight + neiWeight);
                    }

                }
            }
        }

        if (dist.size() != N) return -1;

        return dist.values().stream().mapToInt(i -> i).max().getAsInt();
    }


    public static void main(String[] args) {
        NetworkDelayTimeWrongV ndt  = new NetworkDelayTimeWrongV();

        ndt.networkDelayTime( new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
        //ndt.networkDelayTime( new int[][]{{1,2,1},{2,1,3}}, 2, 2);
        //ndt.networkDelayTime( new int[][]{{1,2,1},{2,3,2}, {1,3,4}}, 3, 1);
       // ndt.networkDelayTime( new int[][]{{1,2,1}}, 2, 2);
    }


}
