package general;

public class StocksCoolDownV3 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0 ||prices.length == 1 ) return 0;
        //int[] dp = new int[prices.length];
        //dp[0] = 0;
        int prev = 0, ans = 0;

        int min = prices[0];
        for (int i=1; i < prices.length; i ++) {
            min = Math.min(min, (prices[i] - (i < 2 ? 0 : prev)));
            prev = ans;
            ans = Math.max( ans, prices[i] - min );
        }

        return  ans;
    }


    public static void main(String[] args) {

        StocksCoolDownV3 scd = new StocksCoolDownV3();

        System.out.println(scd.maxProfit(new int[] {1,2,3,0,2}));
//        System.out.println(scd.maxProfit(new int[] {1,2,4}));
        //System.out.println(scd.maxProfit(new int[] {1,3,2,4,7}));

    }
}
