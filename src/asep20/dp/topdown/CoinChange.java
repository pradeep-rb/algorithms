package asep20.dp.topdown;

import java.util.HashMap;

public class CoinChange {
    int result = Integer.MAX_VALUE;


    public void coinChange(int[] coins, int amount, int count) {

        if(amount == 0)  result = Math.min(result, count);
        else if(amount < 0) return;

        for (int i = 0; i < coins.length; i++) {
            coinChange( coins,  amount - coins[i], count+1);
        }

    }


    public int coinChange(int[] coins, int amount) {
        coinChange(coins, amount, 0);
        return result == Integer.MAX_VALUE ? -1: result;
    }


    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{1, 3, 5}, 11));
    }

}
