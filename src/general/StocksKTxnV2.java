package general;

import java.util.Arrays;

public class StocksKTxnV2 {

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 ||prices.length == 1 ) return 0;
        int[][] dp = new int[k+1][2];

        int min[] = new int[k+1];
        Arrays.fill(min, prices[0]);


        for (int i = 1; i < prices.length; i++) {
            for (int t = 1; t <= k; t++) {
                min[t] = Math.min(min[t], prices[i] - dp[t-1][0]);
                dp[t][1] = Math.max(dp[t][0], prices[i] - min[t]);
                dp[t][0] = dp[t][1];

            }
        }
        return  dp[k][1];

    }


    public static void main(String[] args) {

        StocksKTxnV2 scd = new StocksKTxnV2();

        System.out.println(scd.maxProfit(2, new int[] {3,3,5,0,0,3,1,4}));
        System.out.println(scd.maxProfit(2, new int[] {2,4,1}));


    }
}
