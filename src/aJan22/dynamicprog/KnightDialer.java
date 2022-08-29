package aJan22.dynamicprog;


import java.util.HashMap;
import java.util.Map;

//935
// Check alternate Solution
public class KnightDialer {

    int[][] dirs;
    int[][] pad;

    public static final int max = 1000000007;
    Map<String,Long> pathCount = new HashMap<>();


    public long dial(int n,  int x, int y) {
        long moves = 0;
        String key = x+":"+y+":"+n;
        if(pathCount.containsKey(key)) return pathCount.get(key);

        if (n == 1)  return 1;
        //System.out.println(x + ":" + y);
        for (int[] dir: dirs) {
            int nx =  dir[0] + x,  ny =  dir[1] + y;
            if(nx < 0 || nx > 3 || ny < 0 || ny > 2 || pad[nx][ny] == -1) continue;
            moves  =  (moves + dial(n-1, nx, ny)) % max;
        }

        pathCount.put(key, moves);
        return moves;
    }

    public int knightDialer(int n) {
      dirs = new int[][]{{-1 , -2},  {1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}, {-1, 2}, {1, 2},};
      pad =  new int[][] { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {-1, 0, -1} };

      long moves = 0;
        for (int i = 0; i < pad.length; i++) { // r
            for (int j = 0; j < pad[0].length; j++) { // c
               if(pad[i][j] != -1) moves =  (moves + dial(n, i, j)) % max;
            }
        }

      return (int) moves;
    }


    public static void main(String[] args) {

        KnightDialer kd = new KnightDialer();
        System.out.println(kd.knightDialer(50));
        //267287516

    }
}
