package aJan22.graph;

import java.util.Arrays;


//505 Maze 2;
/*

    Time complexity for DFS:   O(m*n*max(m,n))
    Explanation: We'll need to traverse the entire maze in the worst case. Due to backtracking, at every node, we'll need to traverse a depth of max(m,n)
 */
public class Maze2DFS {

    int r,c ;
    int dirs[][] = new int[][]{ {1,0},{0,1},{-1,0},{0,-1} };
    int[][] distances;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
         r = maze.length;
         c = maze[0].length;
         distances = new int[r][c];
         for (int[] row : distances) Arrays.fill(row, Integer.MAX_VALUE);
         distances[start[0]][start[1] ] = 0;
         dfs(maze, start);

         return  distances[destination[0]][destination[1]] == Integer.MAX_VALUE ?  -1  : distances[destination[0]][destination[1]];
    }

    void  dfs(int[][] maze, int start[]) {

        for (int dir[]: dirs) {
            int nextDist = 0;
            int[] next = new int[] {start[0] + dir[0], start[1] + dir[1]};
            while(next[0] >= 0 && next[0] < r && next[1] >= 0 && next[1] < c && maze[next[0]][next[1]] == 0 ) {
                nextDist++;

                next[0] += dir[0];
                next[1] += dir[1];
            }
            int[] nextNode = new int[] { next[0] - dir[0], next[1] - dir[1]} ;

            // This line eliminates the need to maintain a visited array.
            if(distances[start[0]][start[1]]  + nextDist <  distances[nextNode[0]][nextNode[1]]) {
                distances[nextNode[0]][nextNode[1]] = distances[start[0]][start[1]]  + nextDist;
                dfs(maze, nextNode );
            }

        }

    }


    public static void main(String[] args) {
        Maze2DFS m2  = new Maze2DFS();
        System.out.println(m2.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(m2.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(m2.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(m2.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(m2.shortestDistance(new int[][] { {0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,0}, new int[] {4,4} ));
    }
}
