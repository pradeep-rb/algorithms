package aJan22.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//505 Maze 2
/*
    Time complexity of Dijstra :   ( V + E) Log V
    total number of vertices in the worst case = m * n
    therefore  TC =  O( mn * log (mn) )


 */
public class Maze2Dijkstra {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs =  {{1,0}, {0,1}, {-1,0}, {0, -1}};
        int r = maze.length;
        int c = maze[0].length;
        int[][] distance = new int[r][c];


        for (int i = 0; i < r; i++)  Arrays.fill( distance[i], Integer.MAX_VALUE);
        //indices 0,1: location, 2: distance from start
        PriorityQueue<int[]>  pq = new PriorityQueue<>(  (e1, e2) ->  e1[2] - e2[2]);

        pq.add(new int[] {start[0], start[1], 0} );
        distance[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {

            int[] loc = pq.poll();

            if(  loc[0] == destination[0] && loc[1] == destination[1]) return loc[2];
            //this line seems to speed up the execution
            if(distance[loc[0]][loc[1]]  < loc[2]) continue;


            for (int[] dir: dirs) {
                int[] newLoc =  loc;
                int dist = 0;
                while(newLoc[0] >= 0 &&  newLoc[0] < r &&  newLoc[1] >= 0 && newLoc[1] < c &&  maze[newLoc[0]][newLoc[1]] == 0 ) {
                    newLoc = new int[]{ newLoc[0] + dir[0], newLoc[1] + dir[1]}; dist++;
                }
                newLoc = new int[]{ newLoc[0] - dir[0], newLoc[1] - dir[1]}; dist--;

                // the below line also prevents loops in addition to updating optimal distance
                if( dist + distance[loc[0]][loc[1]] <   distance[newLoc[0]][newLoc[1]]) {
                    System.out.println(Arrays.toString(newLoc));
                    distance[newLoc[0]][newLoc[1]] = dist + distance[loc[0]][loc[1]];
                    pq.add( new int[] {newLoc[0], newLoc[1], dist + distance[loc[0]][loc[1]]});
                }
            }

        }

        return  -1;
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
