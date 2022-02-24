package aJan22.dynamicprog;

// 121
public class Stock1 {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min( min, prices[i]);
            dp[i] = Math.max( dp[i-1],  prices[i] - min );
        }

        return dp[prices.length - 1];
    }


    public static void main(String[] args) {
        Stock1 s1 =  new Stock1();
        System.out.println(s1.maxProfit(new int[] {1,2} ));
    }
}
