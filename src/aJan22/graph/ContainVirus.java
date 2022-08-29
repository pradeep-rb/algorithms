package aJan22.graph;


import java.awt.*;
import java.util.*;

//749
/*

        revise:  following are some of the cool things about this solution
        * using a custom data structure called Region on to store infected and un-infected neighbor nodes
        * re-using the dfs in subsequent expansions of the graph using a phase variable
        * copying over the state of the grid to region  and then back to the grid later on the next expansion
        (This was done to keep the dfs search unaffected. Otherwise the count of walls was turning out to be inaccurate )

 */
public class ContainVirus {

    class Region {
        int wallCt;
        Set<Point> uninfectedNeighbors = new HashSet<>();
        Set<Point> infectedCells = new HashSet<>();
    }


    int nR, nC;

    public int containVirus(int[][] isInfected) {
        int wallCnt = 0;

        if(isInfected == null || isInfected.length == 0 || isInfected[0].length == 0) return 0;

        nR =  isInfected.length;
        nC = isInfected[0].length;

        PriorityQueue<Region> regionQueue = new PriorityQueue<>( (e1, e2) -> e2.uninfectedNeighbors.size() - e1.uninfectedNeighbors.size() );
        infect(isInfected, 1,  regionQueue);

        int phase = 1;
        while ( !regionQueue.isEmpty()) {
            Region mostInfectious = regionQueue.poll();
            wallCnt += mostInfectious.wallCt;
            for (Point point: mostInfectious.infectedCells) isInfected[point.x][point.y] = -1;
            phase++;
            while ( !regionQueue.isEmpty()) {
                Region otherRegion = regionQueue.poll();
                for (Point point: otherRegion.uninfectedNeighbors) isInfected[point.x][point.y] = phase;
            }
            infect(isInfected, phase , regionQueue);
        }
        return wallCnt;
    }

    private void infect(int[][] isInfected, int phase,  PriorityQueue<Region> regionQueue) {
        for (int i = 0; i < nR; i++) {
            for (int j = 0; j < nC; j++) {
                if(isInfected[i][j] == phase) {
                    Region region = new Region();
                    dfsRegions(isInfected, phase, i, j,  region);
                    if (!region.uninfectedNeighbors.isEmpty()) regionQueue.add(region);
                }
            }
        }
    }

    private void dfsRegions(int[][] isInfected,  int phase,   int i, int j, Region region) {

        int[][] dirs = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        if( i < 0 || i >= nR || j < 0 || j >= nC || isInfected[i][j] == -1 || isInfected[i][j] > phase) return;

        if(isInfected[i][j] == 0) {
            region.uninfectedNeighbors.add(new Point(i, j));
            region.wallCt++;
            return ;
        }
        region.infectedCells.add(new Point(i, j));
        //visited
        isInfected[i][j]++;
        for (int[] dir: dirs) dfsRegions(isInfected,  phase,i + dir[0], j + dir[1], region);

    }

    public static void main(String[] args) {
        System.out.println(new ContainVirus().containVirus(new int[][] {{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0 }}));
        System.out.println(new ContainVirus().containVirus(new int[][] {{1,1,1,0,0,0,0,0,0},{1,0,1,0,1,1,1,1,1},{1,1,1,0,0,0,0,0,0}}));
        //[[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]
    }

}
