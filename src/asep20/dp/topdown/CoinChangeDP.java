package asep20.dp.topdown;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeDP {

     Map<Integer, Integer> mem = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if(mem.containsKey(amount)) return mem.get(amount);
        int min = Integer.MAX_VALUE;
        if(amount == 0)  return 0;
        if(amount < 0) return  -1;

        for (int i = 0; i < coins.length; i++) {
            int ans = coinChange(coins, amount - coins[i]);
            if(ans >= 0 && ans < min) {
                min = Math.min( 1 + ans, min);
            }
        }
        mem.put(amount, min);
        return min ==  Integer.MAX_VALUE ? -1 : min;
    }



    public static void main(String[] args) {
        CoinChangeDP cc = new CoinChangeDP();
        System.out.println(cc.coinChange(new int[]{  1, 3, 5}, 11));
        cc.mem = cc.mem;
    }

}
