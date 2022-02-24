package general;

import java.sql.SQLException;

public class SquareNumberDP {
    public int numSquares(int n) {

        int[] sqNum = new int[(int)Math.sqrt(n)];
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 0; i < sqNum.length; i++) {
            sqNum[i] = (i+1) * (i+1);
        }

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < sqNum.length ; j++) {
                if(i < sqNum[j]) break;
                int temp = dp[i - sqNum[j] ] + 1;
                min = Math.min(min, temp);
            }
            dp[i] = min;
        }

        return dp[n];
    }


    public static void main(String[] args) {

        SquareNumberDP sq = new SquareNumberDP();
        sq.numSquares(12);
    }
}
