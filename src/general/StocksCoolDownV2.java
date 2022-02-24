package general;

public class StocksCoolDownV2 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0 ||prices.length == 1 ) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;

        int min = prices[0];
        for (int i=1; i < prices.length; i ++) {
            min = Math.min(min, (prices[i] - (i < 2 ? 0 : dp[i-2])));
            dp[i] = Math.max( dp[i-1], prices[i] - min );
        }

        return  dp[prices.length-1];
    }


    public static void main(String[] args) {

        StocksCoolDownV2 scd = new StocksCoolDownV2();

        System.out.println(scd.maxProfit(new int[] {1,2,3,0,2}));
//        System.out.println(scd.maxProfit(new int[] {1,2,4}));
        //System.out.println(scd.maxProfit(new int[] {1,3,2,4,7}));

    }
}
