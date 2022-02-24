package general;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

public class CoinChange {

//

    public int coinChange(int[] coins, int amount) {
        int memo[]  =  new int[amount];
        Arrays.fill(memo, Integer.MAX_VALUE);


          coinChange(coins,  amount, memo);
        System.out.println(Arrays.toString(memo));
          return  0;
    }

    public int coinChange(int[] coins,  int amount,int[] memo) {
        if(amount == 0) return 0;
        //if(memo[amount-1] != -1) return  amount[]
        else if (amount > 0){
            int res = 0;
            int min =0 ;
            for (int i = 0; i < coins.length ; i++) {

                res  = coinChange(coins,   amount - coins[i], memo);
                //memo[amount -1] = res != -1  ? Math.min(res +1,   memo[amount -1])  : Integer.MAX_VALUE;
                if(res >=0 ) {
                    memo[amount -1] = Math.min(1+ res, memo[amount -1]);
                }
            }

            return memo[amount -1];


        }

        return  -1;
    }


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        coinChange.coinChange(new int[] {1, 2, 5}, 11);
    }
}
