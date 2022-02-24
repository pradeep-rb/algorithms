package aJan22.dynamicprog;

// 123

/*
     questions :   how do you calculate the dp in the first level  (k = 0)?
     ans: k = 1 to 2(inclusive)


      dp[k][i] =    dp[k][i - 1];   or
                   dp[k-1][j-1]  + prices[i] - prices[j];
                   where j ranges from 0 to i-1


    Notice the evolution

 */

public class Stock3 {

    public int maxProfit(int[] prices) {
        return  maxProfit(2, prices);
    }

    public int maxProfit(int txns, int[] prices) {
        int[][] dp = new int[txns + 1][prices.length];
        for (int k = 1; k <= txns; k++) {
            for (int i = 1; i < prices.length; i++) {
                int maxProfitAtPrevTxn = prices[i]  - prices[0];
                for (int j = 1; j <= i; j++) {
                    maxProfitAtPrevTxn = Math.max(maxProfitAtPrevTxn, dp[k - 1][j - 1]  + prices[i]  - prices[j]);
                }
                dp[k][i] = Math.max(dp[k][i - 1], maxProfitAtPrevTxn);
            }
        }

        return dp[txns][prices.length - 1];
    }



    public int maxProfit2(int steps, int[] prices) {
        int[][] dp = new int[steps + 1][prices.length];


        for (int k = 1; k <= steps; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++) {
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1] );
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i]  - min);
            }
        }

        return dp[steps][prices.length - 1];
    }

    /*
        the elimination of the forj loop:
        This is because min calculation is only dependent on values of j, as k remains constant thru the loop
        min will be repeatedly calculated between the i and j loops, instead of just once.
        instead of running the loop from  j = 1 to i-1, we just do it once when j = i;

     */
    public int maxProfit3(int txns, int[] prices) {
        int[][] dp = new int[txns + 1][prices.length];

        for (int k = 1; k <= txns; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1] );
                dp[k][i] = Math.max(dp[k][i - 1], prices[i]  - min);
            }
        }

        return dp[txns][prices.length - 1];
    }


    public static void main(String[] args) {
        Stock3 s3 =  new Stock3();
        System.out.println(s3.maxProfit(2, new int[] {3,3,5,0,0,3,1,4} ));
        System.out.println(s3.maxProfit2(2, new int[] {3,3,5,0,0,3,1,4} ));
        System.out.println(s3.maxProfit3(2, new int[] {3,3,5,0,0,3,1,4} ));
    }
}
