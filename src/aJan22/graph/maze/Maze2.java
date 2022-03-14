package aJan22.graph.maze;


import java.util.*;
//505. The Maze II
// learning: enum, PQ comparators
/*
       Dijsktra + BFS
 */

public class Maze2 {


    class MazeState {
        int distance;
        int[] location;
        int[] direction;


        public MazeState(int distance, int[] location, int[] direction) {
            this.distance = distance;
            this.location = location;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MazeState mazeState = (MazeState) o;
            return Arrays.equals(location, mazeState.location) &&
                    Arrays.equals(direction, mazeState.direction);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(location);
            result = 31 * result + Arrays.hashCode(direction);
            return result;
        }

        public int[] getNextLocation() {
            return new int[]{location[0] + direction[0], location[1] + direction[1]};
        }

    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int r  = maze.length;
        int c = maze[0].length;

        int dirs[][] = {{0,-1},{0,1},{-1,0},{1,0}};
        int[][] newMaze = new int[r+2][c+2];
        Map<MazeState, Boolean> visited = new HashMap<>();

        // augment the maze with walls all around for easier code later
        Arrays.fill(newMaze[0], 1);
        Arrays.fill(newMaze[r+1], 1);
        for (int i = 1; i <= r; i++) {
            System.arraycopy(maze[i-1], 0, newMaze[i],  1, c);
            newMaze[i][0] = 1; newMaze[i][c+1] = 1;
        }

        int[] newDestination =  new int[]{destination[0]+1, destination[1]+1};

        Queue<MazeState> graph = new PriorityQueue<>((e1, e2) -> e1.distance - e2.distance );

        // expand in all possible directions initially
        for (int[] dir: dirs) graph.add( new MazeState(0, new int[]{start[0]+1, start[1]+1}, dir) );



        while(! graph.isEmpty()) {
            MazeState currState = graph.poll();
            if (visited.getOrDefault(currState, false)) continue;

            int[] currLoc = currState.location;
            int[] currDir = currState.direction;
            int currDist = currState.distance;
            int[] nextLoc = currState.getNextLocation();

            //if the next step leads to a wall/barrier
            if (newMaze[nextLoc[0]][nextLoc[1]] == 1) {
                if (Arrays.equals(currLoc, newDestination)) return currDist;

                // explore new directions, but not the current one and also not the one that has a walls for a neighbor
                for (int newDir[] : dirs) {
                    int[] neighbor  = new int[]{currLoc[0] + newDir[0], currLoc[1] + newDir[1]};
                    if (!Arrays.equals(currDir, newDir) && newMaze[neighbor[0]][neighbor[1]] != 1)
                        graph.add(new MazeState(currDist + 1, neighbor, newDir));

                }
            }// proceed in the same direction
            else graph.add(new MazeState(currDist + 1, nextLoc, currDir));

            visited.put(currState, true);
        }
        return -1;
    }


    public static void main(String[] args) {
        Maze2 m2 = new Maze2();
        System.out.println(m2.shortestDistance(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4},new int[]{4,4}));
        System.out.println(m2.shortestDistance(new int[][]{{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}}, new int[]{4,3},new int[]{0,1}));
    }

}
