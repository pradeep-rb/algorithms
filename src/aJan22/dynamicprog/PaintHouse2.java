package aJan22.dynamicprog;

import java.util.PriorityQueue;

//265
public class PaintHouse2 {


    //version1
    public int minCost(int[][] costs) {

        int nColor = costs[0].length;
        int nHouse = costs.length;

        long[][] dp = new long[nHouse][nColor];
        for (int j = 0; j < nColor; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < nHouse ; i++) {
            for (int j = 0; j < nColor; j++) {
                Long minVal = Long.MAX_VALUE;
                for (int k = 0; k < nColor; k++) {
                    if(j == k) continue;
                    minVal = Math.min(minVal,  dp[i-1][k] );
                }
                dp[i][j] = minVal + costs[i][j];
            }

        }

        Long minVal = dp[nHouse-1][0];
        for (int j = 1; j < nColor; j++) {
            minVal = Math.min(minVal, dp[nHouse-1][j]);
        }

        return minVal.intValue();
    }



    public int minCost2(int[][] costs) {

        int nColor = costs[0].length;
        int nHouse = costs.length;

        int[][] dp = new int[nHouse][nColor];
        for (int j = 0; j < nColor; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < nHouse ; i++) {

            // 0 position has the value and 1 position has the index
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]-a[0]);

            for (int j = 0; j < nColor; j++) {
                maxHeap.add( new int[]{dp[i-1][j], j});
                if(maxHeap.size() > 2) maxHeap.poll();
            }

            int[] secondMin = maxHeap.poll();
            int[] firstMin = maxHeap.poll();
            int min = 0;
            for (int j = 0; j < nColor; j++) {
                if(j ==  firstMin[1] ) min = secondMin[0];
                else min = firstMin[0];

                dp[i][j] = min + costs[i][j];
            }

        }

        int minVal = dp[nHouse-1][0];
        for (int j = 1; j < nColor; j++) {
            minVal = Math.min(minVal, dp[nHouse-1][j]);
        }

        return minVal;
    }



    public int minCost3(int[][] costs) {

        int nColor = costs[0].length;
        int nHouse = costs.length;

        int[] dp = costs[0];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for (int i = 1; i < nHouse ; i++) {

            for (int j = 0; j < nColor; j++) {
                maxHeap.add( new int[]{dp[j], j});
                if(maxHeap.size() > 2) maxHeap.poll();
            }

            int[] secondMin = maxHeap.poll();
            int[] firstMin = maxHeap.poll();
            int min = 0;
            for (int j = 0; j < nColor; j++) {
                if(j ==  firstMin[1] ) min = secondMin[0];
                else min = firstMin[0];

                dp[j] = min + costs[i][j];
            }
        }

        int minVal = dp[0];
        for (int j = 1; j < nColor; j++) {
            minVal = Math.min(minVal, dp[j]);
        }

        return minVal;
    }




    public static void main(String[] args) {

        PaintHouse2 ph = new PaintHouse2();
        //System.out.println(ph.minCost( new int[][]{{17,2,17},{16,16,5},{14,3,19}}  ));
        //System.out.println(ph.minCost( new int[][]{{17, 2, 17}, {8, 4, 10}, {6, 3, 19}, {4, 8, 12}}  ));
//        System.out.println(ph.minCost( new int[][]{{3,5,3}, {6,17,6}, {7,13,18}, {9,10,18}}  ));
        //System.out.println(ph.minCost2( new int[][]{{3,5,3}, {6,17,6}, {7,13,18}, {9,10,18}}  ));
        System.out.println(ph.minCost3( new int[][]{{3,5,3}, {6,17,6}, {7,13,18}, {9,10,18}}  ));
    }
}
