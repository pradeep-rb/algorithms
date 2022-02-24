package asep20.graphsearch;


import java.util.*;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/solution/
public class FlattenMultilevelListStack {

    public Node flatten(Node head) {
        if (head == null)  return null;

        Node ans = head;
        Deque<Node> stack = new LinkedList<>();
        stack.push(head);
        Node curr = head;
        while(!stack.isEmpty()) {
            if(curr.next != null ) stack.push(curr.next);
            if(curr.child != null ) stack.push(curr.child);
            ans.next = curr;
            if(curr != head) curr.prev = ans;
            curr.child = null;
            ans = curr;
            curr = stack.pop();
        }

        return  head;
    }

    public static void main(String[] args) {
        FlattenMultilevelListStack flatten = new FlattenMultilevelListStack();

        Node one =  new Node(1,  null, null, null);
        Node two =  new Node(2,  null, null, null);
        Node three =  new Node(3,  null, null, null);
        Node four =  new Node(4,  null, null, null);
        Node five =  new Node(5,  null, null, null);

        one.next = two;two.prev = one;
        two.next = five; two.child = three;
        five.prev = two;
        three.next = four;
        four.prev=three;


        flatten.flatten(one);


    }


    //https://leetcode.com/problems/network-delay-time/submissions/
    //Correct version
    //Dijkstra
    public static class NetworkDelayTime2 {

        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, List<Integer[]>> graph = new HashMap<>();

            Map<Integer, Integer> dist = new HashMap();
            //boolean[] visited = new boolean[N+1];

            Queue<Integer[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);

            for(int[] edge   : times) {
                graph.computeIfAbsent( edge[0], k -> new ArrayList<>()).add(new Integer[] {edge[1], edge[2]});
            }

            //dist.put(K, 0);
            pq.offer(new Integer[]{0, K});

            while (!pq.isEmpty()) {
                Integer[] node = pq.poll();
                Integer grapheNode = node[1];
                Integer nodeWeight = node[0];
                if(dist.containsKey(grapheNode)) continue;
                dist.put(grapheNode, nodeWeight);

                if(graph.containsKey(grapheNode)) {
                    List<Integer[]> neighbors = graph.get(grapheNode);
                    for (Integer[] neighbor : neighbors) {

                        Integer neiNode = neighbor[0];
                        Integer neiWeight = neighbor[1];
                        if (!dist.containsKey(neiNode) ) {

                             pq.offer(new Integer[]{nodeWeight + neiWeight, neiNode});
                        }

                    }
                }
            }

            if (dist.size() != N) return -1;

            return dist.values().stream().mapToInt(i -> i).max().getAsInt();
        }


        public static void main(String[] args) {
            NetworkDelayTime2 ndt  = new NetworkDelayTime2();

            ndt.networkDelayTime( new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
            //ndt.networkDelayTime( new int[][]{{1,2,1},{2,1,3}}, 2, 2);
            //ndt.networkDelayTime( new int[][]{{1,2,1},{2,3,2}, {1,3,4}}, 3, 1);
           // ndt.networkDelayTime( new int[][]{{1,2,1}}, 2, 2);
        }


    }
}

