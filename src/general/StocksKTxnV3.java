package general;

public class StocksKTxnV3 {

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 ||prices.length == 1 ) return 0;
        int[][] dp = new int[2][prices.length];

        if (k >=  prices.length /2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length ; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        for (int t = 1; t <= k; t++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[0][i]);
                dp[1][i] = Math.max(dp[1][i - 1], prices[i] - min);
                dp[0][i] =  dp[1][i];
            }
        }

        return  dp[1][prices.length-1];
    }


    public static void main(String[] args) {

        StocksKTxnV3 scd = new StocksKTxnV3();

        System.out.println(scd.maxProfit(2, new int[] {3,3,5,0,0,3,1,4}));
        System.out.println(scd.maxProfit(2, new int[] {2,4,1}));


    }
}
