package aJan22.dynamicprog;

import java.lang.reflect.Array;
import java.util.Arrays;
/*
174
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


    //                dp[i][j] = Math.min(dungeon[i][j] >= dp[i + 1][j] ? 1 : dp[i+1][j] ==  Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i + 1][j] - dungeon[i][j],
//                            dungeon[i][j] >= dp[i][j + 1] ? 1 : dp[i][j + 1] ==  Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j + 1] -  dungeon[i][j]);


        public static void main(String[] args) {
        DungeonGame dg = new DungeonGame();

        System.out.println(dg.calculateMinimumHP(new int[][] {{  -2,-3,3},{-5,-10,1},{10,30,-5}}));
//        System.out.println(dg.calculateMinimumHP(new int[][] {{ 100}}));
//         System.out.println(dg.calculateMinimumHP(new int[][] {{ -3, 5}}));
        //System.out.println(dg.calculateMinimumHP(new int[][] {{ 0, 5}, { -2, -3}}));
        System.out.println(dg.calculateMinimumHP(new int[][] {{ 0, 0, 0}, { 1, 1, -1}}));
    }








    class Dungeon {
        public int health;
        public int orb;

        public Dungeon(int health, int orb) {
            this.health = health;
            this.orb = orb;
        }
    }


    /*
        The approach started from the first cell towards the last
         worked only for half the test cases. Failed for the case were there were
         no -ve health but only ORBS
     */
    public int calculateMinimumHP1(int[][] dungeon) {

        int r = dungeon.length;
        int c = dungeon[0].length;

        Dungeon[][] dp = new Dungeon[r+1][c+1];

        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = new Dungeon(Integer.MIN_VALUE, 0) ;
            }
        }

        dp[1][1] = new Dungeon(dungeon[0][0], 0);

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(i == 1 && j ==1 ) continue;

                int downPath = Math.min(dp[i - 1][j].health, dp[i - 1][j].health + dungeon[i - 1][j - 1]);
                int leftPath = Math.min(dp[i][j - 1].health, dp[i][j - 1].health + dungeon[i - 1][j - 1]);

                if(downPath > leftPath) {
                    dp[i][j].health = downPath;
                    dp[i][j].orb =  dungeon[i - 1][j - 1] < 0  || ( i == r && j == c)? dp[i - 1][j].orb : dp[i - 1][j].orb + dungeon[i - 1][j - 1];
                }
                else {
                    dp[i][j].health = leftPath;
                    dp[i][j].orb =  dungeon[i - 1][j - 1] < 0 || ( i == r && j == c) ? dp[i - 1][j].orb : dp[i][j-1].orb + dungeon[i - 1][j - 1];
                }

            }
        }

        return dp[r][c].health + dp[r][c].orb > 0 ? 1 :  1 - (dp[r][c].health + dp[r][c].orb)  ;
    }


}
