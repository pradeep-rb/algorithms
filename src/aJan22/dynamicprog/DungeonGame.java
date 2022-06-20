package aJan22.dynamicprog;

import java.lang.reflect.Array;
import java.util.Arrays;
/*
174
revise :  some dp problems involving tracing back from the end to the start

Answer to  what's the intuition behind populating the DP array backwards ?
At every index position dp[i][j] the  matrix we ask ourselves, what is the minimum health I need to have  right here so that I don't die in the future.
 The answer to this depends on what lies ahead i.e in the future,  not what you have encountered so far.
 When you reach dp[0][0], you exactly know what you need so that you don't die in the future.

If the question was, whats the maximum value of the orbs you can collect ?, then it makes sense to calculate the DP array forwards.

The direction you take literally depends on the question being asked.
revise:
*** min health that you need cannot be -ve, otherwise you will die wink wink ;)
*** fill the dp matrix from bottom right to top left.
** pad the dp matrix with an extra row and extra column
** use array fill to populate the matrix with INF since we are doing a minimization


 */
public class DungeonGame {


/*
 The approach starts from the last cell towards the first

-2       -3       3                 -2(7)     -3(5)   3(*)
                                    (8)      (14)    (2)

                                     (16)     (15)
-5      -10       1                 -5       -10     1(*)
                 (5)              (6)       (11)     (5)


10       30(1)   -5                10(1)    30(1)    -5 (6)
                                  (*)       (*)       (6)
 */

//final solution
    public int calculateMinimumHP(int[][] dungeon) {

        int r = dungeon.length;
        int c = dungeon[0].length;

        int[][] dp = new int[r+1][c+1];

        //fill the whole matrix with inf
        for (int i = 0; i <= r; i++)  Arrays.fill( dp[i], Integer.MAX_VALUE );
        // in the cell where the princess is, if I have an orb, all it takes is a health of 1 right before I get there
        // else I need 1 more than how much my health will be depleted by (-ve health )
        dp[r-1][c-1] = dungeon[r-1][c-1] > 0 ? 1 : 1 - dungeon[r-1][c-1];

        for (int i = r-1; i >= 0 ; i--) {
            for (int j = c-1; j >= 0; j--) {
                if(i == r-1 && j == c-1) continue;
                // How much health do I need, considering the right or the bottom cell (places I gotta go)
                int need =  Math.min(dp[i + 1][j],  dp[i][j + 1]  )  - dungeon[i][j];
                //but  if my needs are more than satisfied by an orb in the current cell, then all I need is a health of 1
                //  else I need what  I need
                dp[i][j] = dungeon[i][j] >= dp[i + 1][j]  || dungeon[i][j] >= dp[i ][j+1]   ? 1 : need;
            }
        }

        return dp[0][0];
    }

        public static void main(String[] args) {
        DungeonGame dg = new DungeonGame();

        System.out.println(dg.calculateMinimumHP(new int[][] {{  -2,-3,3},{-5,-10,1},{10,30,-5}}));
//        System.out.println(dg.calculateMinimumHP(new int[][] {{ 100}}));
//         System.out.println(dg.calculateMinimumHP(new int[][] {{ -3, 5}}));
        //System.out.println(dg.calculateMinimumHP(new int[][] {{ 0, 5}, { -2, -3}}));
        System.out.println(dg.calculateMinimumHP(new int[][] {{ 0, 0, 0}, { 1, 1, -1}}));
    }

}
