package aJan22.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Maze2Dijkstra {

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

      public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int r = maze.length,c = maze[0].length ;
        int dirs[][] = new int[][]{ {1,0,0},{0,1,1},{-1,0,2},{0,-1,3} };
        String sDir[] =   new String[] {"d","r","u","l"};
        int[][] distances = new int[r][c];
        for (int[] row : distances) Arrays.fill(row, Integer.MAX_VALUE);
        distances[start[0]][start[1] ] = 0;
        r = maze.length;
        c = maze[0].length;

        Node sNode = new Node(start, 0, "");
        Queue<Node> pq  = new PriorityQueue<>( Comparator.comparing( Node::getDistance  ));
        pq.add(sNode);

        while (!pq.isEmpty()){
            Node top = pq.poll();
            if( distances[top.loc[0]][top.loc[1] ] < top.distance ) continue;

            for (int dir[]: dirs) {
                int nextDist = 0;
                int[] next = new int[] {top.loc[0] + dir[0],top.loc[1] + dir[1]};
                while(next[0] >= 0 && next[0] < r && next[1] >= 0 && next[1] < c && maze[next[0]][next[1]] == 0 ) {
                    nextDist++;
                    next[0] += dir[0];next[1] += dir[1];

                }
                int[] nextNode = new int[] { next[0] - dir[0], next[1] - dir[1]} ;

                if(top.distance + nextDist < distances[nextNode[0]][nextNode[1]]) {
                    distances[nextNode[0]][nextNode[1]] = top.distance + nextDist;
                    pq.offer(new Node(nextNode, distances[nextNode[0]][nextNode[1]] , top.path + sDir[dir[2]]));
                }
            }
        }

        return  distances[destination[0]][destination[1]] == Integer.MAX_VALUE ?  -1  : distances[destination[0]][destination[1]];
    }

    public static void main(String[] args) {
        Maze2Dijkstra md = new Maze2Dijkstra();
        System.out.println(md.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(md.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(md.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(md.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(md.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,0}, new int[] {4,4} ));

    }
}
