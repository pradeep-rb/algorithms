package aJan22.graph;

import java.util.Arrays;
/*
 not a leetcode problem
 */
public class MazeHasPath {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination);
    }

    boolean dfs(int[][] maze, int start[], int[] dest) {

        int dirs[][] = new int[][]{ {1,0},{0,1},{-1,0},{0,-1} };
        int r = maze.length;
        int c = maze[0].length;

        boolean hasPath = false;

        if(Arrays.equals(start, dest)) return true;
        if(maze[start[0]][start[1]] == 1) return  false;

        for (int dir[]: dirs) {
            int[] next = new int[2];
            next[0] = start[0] + dir[0];
            next[1] = start[1] + dir[1];

            if(next[0] >= 0 && next[0] < r && next[1] >= 0 && next[1] < c  ) {
                //visited
                maze[start[0]][start[1]] = 1;
                hasPath |= dfs(maze, next, dest);
            }
        }
        return  hasPath;
    }


    public static void main(String[] args) {
        MazeHasPath mhp  = new MazeHasPath();
        System.out.println(mhp.hasPath(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(mhp.hasPath(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(mhp.hasPath(new int[][] { {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(mhp.hasPath(new int[][] { {0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[] {4,4} ));
        System.out.println(mhp.hasPath(new int[][] { {0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,0},{0,1,1,1,1},{0,0,0,0,0}}, new int[]{0,0}, new int[] {4,4} ));
    }
}
