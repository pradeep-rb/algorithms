package aJan22.dynamicprog;

// 122
public class Stock2 {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                dp[i] = dp[i - 1] +  prices[i] - min;
                min = prices[i];
            }
            else {
                dp[i] = dp[i - 1];
                min = Math.min( min, prices[i]);
            }
        }

        return dp[prices.length - 1];
    }

    public int maxProfit2(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                dp[i] = dp[i - 1] +  prices[i] - min;
            }
            else {
                dp[i] = dp[i - 1];
            }
            min = prices[i];
        }

        return dp[prices.length - 1];
    }

    public int maxProfit3(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] +  prices[i] - min);
            min = prices[i];
        }

        return dp[prices.length - 1];
    }


    public int maxProfit4(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] +  prices[i] - prices[i-1]);
        }

        return dp[prices.length - 1];
    }

    public int maxProfit5(int[] prices) {
        int curMax = 0;
        int prevMax = 0;
        for (int i = 1; i < prices.length; i++) {
            curMax = Math.max(prevMax, prevMax +  prices[i] - prices[i-1]);
            prevMax = curMax;
        }
        return curMax;
    }


    public int maxProfit6(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1])
                max = max +  prices[i] - prices[i-1];
        }
        return max;
    }



    public static void main(String[] args) {
        Stock2 s1 =  new Stock2();
        System.out.println(s1.maxProfit(new int[] {7,1,5,3,6,4} ));
        System.out.println(s1.maxProfit2(new int[] {7,1,5,3,6,4} ));
        System.out.println(s1.maxProfit3(new int[] {7,1,5,3,6,4} ));
        System.out.println(s1.maxProfit4(new int[] {7,1,5,3,6,4} ));
        System.out.println(s1.maxProfit5(new int[] {7,1,5,3,6,4} ));
        System.out.println(s1.maxProfit6(new int[] {7,1,5,3,6,4} ));
    }
}
