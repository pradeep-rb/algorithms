package general;

public class StocksCoolDownV1 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0 ||prices.length == 1 ) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;

        for (int i=1; i < prices.length; i ++) {
            int min = prices[0];
            for (int j = 1; j < i ; j++) {
                min = Math.min(min, (prices[j] - (j < 2 ? 0 : dp[j-2])));
            }
            dp[i] = Math.max( dp[i-1], prices[i] - min );
        }

        return  dp[prices.length-1];
    }


    public static void main(String[] args) {

        StocksCoolDownV1 scd = new StocksCoolDownV1();

        System.out.println(scd.maxProfit(new int[] {1,2,3,0,2}));
//        System.out.println(scd.maxProfit(new int[] {1,2,4}));
        //System.out.println(scd.maxProfit(new int[] {1,3,2,4,7}));

    }
}
