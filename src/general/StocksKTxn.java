package general;

import java.util.Arrays;

public class StocksKTxn {

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 ||prices.length == 1 ) return 0;
        int[][] dp = new int[k+1][prices.length];


        for (int t = 1; t <= k; t++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[t-1][i]);
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] - min);
            }
        }

        return  dp[k][prices.length-1];
    }


    public static void main(String[] args) {

        StocksKTxn scd = new StocksKTxn();

        System.out.println(scd.maxProfit(2, new int[] {3,3,5,0,0,3,1,4}));
        System.out.println(scd.maxProfit(2, new int[] {2,4,1}));


    }
}
