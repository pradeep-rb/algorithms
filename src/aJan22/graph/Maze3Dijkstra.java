package aJan22.graph;

import java.util.*;


/*
    failing for a couple of test cases
    The reason is that the already visited check is implicity done be distances[][] array.
    In case, several paths have the same distance, both need to be considered. This solution doesn't consider both
    Refer Maze 3 for the correct solution.
    The right way to  implement this would be having Memoize the nodes and use a combination of distance and path
 */
public class Maze3Dijkstra {

    class Node {
        int[] loc;
        int distance;
        String path = "";

        public Node(int[] loc, int distance, String path) {
            this.loc = loc;
            this.distance = distance;
            this.path = path;
        }
        public int getDistance() { return distance; }
        public String getPath() { return path; }
    }

      public String findShortestWay(int[][] maze, int[] start, int[] destination) {

        int r = maze.length,c = maze[0].length ;
        int dirs[][] = new int[][]{ {1,0,0},{0,1,1},{-1,0,2},{0,-1,3} };
        String sDir[] =   new String[] {"d","r","u","l"};
        Node[][] memo = new Node[r][c];
        for (Node[] row : memo) Arrays.fill(row,  new Node(new int[]{},  Integer.MAX_VALUE, ""));
        memo[start[0]][start[1] ] = new Node(new int[]{start[0], start[1]},  0, "");
        r = maze.length;
        c = maze[0].length;

        Node sNode = new Node(start, 0, "");
        Queue<Node> queue  = new LinkedList<>();
        Queue<Node> ans  = new PriorityQueue<>( Comparator.comparing( Node::getDistance  ).thenComparing(Node::getPath));
        queue.add(sNode);

        while (!queue.isEmpty()){
            Node top = queue.poll();
            if( memo[top.loc[0]][top.loc[1] ].distance < top.distance ) continue;

            for (int dir[]: dirs) {
                int nextDist = 0;
                int[] next = new int[] {top.loc[0] + dir[0],top.loc[1] + dir[1]};
                String path = top.path + sDir[dir[2]];

                while(next[0] >= 0 && next[0] < r && next[1] >= 0 && next[1] < c && maze[next[0]][next[1]] == 0 ) {
                    nextDist++;
                    if(Arrays.equals(next, destination)) {
                        ans.add( new Node(next, top.distance + nextDist, path)) ;
                        System.out.println("hole:" + top.path + sDir[dir[2]]);
                        break;
                    }
                    next[0] += dir[0];next[1] += dir[1];

                }
                int[] nextNode = new int[] { next[0] - dir[0], next[1] - dir[1]} ;

                if(top.distance + nextDist < memo[nextNode[0]][nextNode[1]].distance &&
                        memo[nextNode[0]][nextNode[1]].path != top.path + sDir[dir[2]]) {
                    System.out.println("path:" + top.path + sDir[dir[2]]);
                    memo[nextNode[0]][nextNode[1]] = new Node(nextNode,top.distance + nextDist,  top.path + sDir[dir[2]]);
                    queue.offer(memo[nextNode[0]][nextNode[1]]);
                }
            }
        }

        return  ans.size() > 0 ? ans.poll().path : "impossible";
    }

    public static void main(String[] args) {
        Maze3Dijkstra md = new Maze3Dijkstra();
        //System.out.println(md.findShortestWay(new int[][] { {0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}}, new int[]{4,3}, new int[] {0,1} ));
        System.out.println(md.findShortestWay(new int[][] { {0,1,0,0,1,0,0,1,0,0},{0,0,1,0,0,1,0,0,1,0},{0,0,0,0,0,0,1,0,0,1},{0,0,0,0,0,0,1,0,0,1},{0,1,0,0,1,0,0,1,0,0},{0,0,1,0,0,1,0,0,0,0},{0,0,0,0,0,0,1,0,0,0},{1,0,0,1,0,0,0,0,0,1},{0,1,0,0,1,0,0,1,0,0},{0,0,0,0,0,1,0,0,1,0}}, new int[]{2,4}, new int[] {7,6} ));


    }
}
