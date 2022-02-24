package asep20.graphsearch;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;

        Deque<int[]> q =  new LinkedList();
        boolean foundRot = false;
        for (int i = 0; i <  r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 2 ){
                    q.offer(new int[]{i, j});
                    foundRot = true;
                }
            }
        }

        int dirs[][] = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};



        int step = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] rLoc = q.pop();
                for(int[] dir: dirs) {
                    int x = dir[0] + rLoc[0];
                    int y = dir[1] + rLoc[1];
                    if( x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == 1) {
                        q.offer(new int[] {x, y});
                        grid[x][y] =  2;
                    }
                }
            }

        }


        for (int i = 0; i <  r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1 ){
                    return  -1;
                }
            }
        }

        return foundRot? step-1 : 0;
    }

    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();

        ro.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}});
        //ro.orangesRotting(new int[][] {{1,2}});
        //ro.orangesRotting(new int[][] {{1},{2},{2}});
        //ro.orangesRotting(new int[][] {{0}});
    }

}
