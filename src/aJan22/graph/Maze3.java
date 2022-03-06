package aJan22.graph;


import java.util.*;

//499. The Maze III
public class Maze3 {

    public enum Direction {
        l(0, -1), r(0, 1), u(-1, 0), d(1, 0);

        private Direction(int row, int col) { this.row = row;this.col = col; }
        private int row;
        private int col;
        public int getRow() { return row; }
        public int getCol() { return col; }
    }

    class MazeState {
        int distance;
        int[] location;
        Direction direction;
        String path = "";
        public int getDistance() { return distance; }
        public String getPath() { return path; }

        public MazeState(int distance, int[] location, Direction direction, String dirStr) {
            this.distance = distance;this.location = location;this.direction = direction;path = path + dirStr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MazeState mazeState = (MazeState) o;
            return Arrays.equals(location, mazeState.location) &&
                    direction == mazeState.direction;
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(direction);
            result = 31 * result + Arrays.hashCode(location);
            return result;
        }

        public int[] getNextLocation() {
            return new int[]{location[0] + direction.getRow(), location[1] + direction.getCol()};
        }

    }

    boolean isBarrier(int[] location, int[][] maze) {
        return maze[location[0]][location[1]] == 1;
    }

    public String findShortestWay(int[][] maze, int[] start, int[] destination) {
        int r  = maze.length;
        int c = maze[0].length;

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
        Queue<MazeState> graph = new PriorityQueue<>(Comparator.comparing(MazeState::getDistance).thenComparing(MazeState::getPath) );

        // expand in all possible directions initially
        for (Direction dir: Arrays.asList(Direction.values())) {
            MazeState mS = new MazeState(0, new int[]{start[0]+1, start[1]+1}, dir, dir.name());
            if(!isBarrier(mS.getNextLocation(), newMaze)) graph.add(mS);
        }

        while(! graph.isEmpty()) {
            MazeState currState = graph.poll();
            if (visited.getOrDefault(currState, false)) continue;

            int[] currLoc = currState.location;
            Direction currDir = currState.direction;
            int currDist = currState.distance;
            int[] nextLoc = currState.getNextLocation();
            String currPath = currState.path;

            if (Arrays.equals(currLoc, newDestination)) return currPath;

            //if the next step leads to a wall/barrier
            if (newMaze[nextLoc[0]][nextLoc[1]] == 1) {
                // explore new directions, but not the current one and also not the one that has a walls for a neighbor
                for (Direction newDir: Arrays.asList(Direction.values())) {
                    int[] neighbor  = new int[]{currLoc[0] + newDir.getRow(), currLoc[1] + newDir.getCol()};
                    if (!Objects.equals(currDir, newDir) && !isBarrier(neighbor, newMaze))
                        graph.add(new MazeState(currDist + 1, neighbor, newDir, currPath + newDir.name()));

                }
            }// proceed in the same direction
            else graph.add(new MazeState(currDist + 1, nextLoc, currDir, currPath ));
            visited.put(currState, true);
        }
        return "impossible";
    }


    public static void main(String[] args) {
        Maze3 m3 = new Maze3();
        System.out.println(m3.findShortestWay(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4},new int[]{4,4}));
        System.out.println(m3.findShortestWay(new int[][]{{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}}, new int[]{4,3},new int[]{0,1}));
    }

}
