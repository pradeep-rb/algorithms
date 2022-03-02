package aJan22.dynamicprog;

import java.nio.charset.CharsetDecoder;
import java.util.Arrays;

public class JobSchedule {



//doesnt work
    public int minDifficulty0(int[] jobDifficulty, int d) {

        int[] jD = new int[jobDifficulty.length +1];
        int n = jD.length;
        int[][] dp = new int[n][d+1];
        jD[0] = 0;

        for (int i = 0; i < jobDifficulty.length ; i++) {
            jD[i+1]  = jobDifficulty[i];
        }

        for (int i = 1; i <= d ; i++) {
            for (int j = i; j < n; j++) {
                int hardest = Integer.MIN_VALUE;
                dp[j][i] =  Integer.MAX_VALUE;
               // System.out.println("------");
                for (int k = i; k <= j ; k++) {
                    System.out.println("k : " + k);
                    hardest = Math.max(hardest, jD[k]);
                    dp[j][i]= Math.min(  dp[j][i], dp[k-1][i-1] + hardest);
                }
                //dp[i][j] = hardest + min;

            }
        }

        return 0;
    }


    public int minDifficulty(int[] jobDifficulty, int d) {

        int[] jD = new int[jobDifficulty.length +1];
        int n = jD.length;
        int[][] dp = new int[n][d+1];
        jD[0] = 0;

        for (int i = 0; i < jobDifficulty.length ; i++) {
            jD[i+1]  = jobDifficulty[i];
        }

        for (int i = 1; i <= d ; i++) {
            for (int j = i; j < n; j++) {
                int hardest =  jD[j];
                dp[j][i] =  Integer.MAX_VALUE;

                for (int k = j; k >= i ; k--) {

                    hardest = Math.max(hardest, jD[k]);
                    dp[j][i] = Math.min(  dp[j][i], dp[k-1][i-1] + hardest);
                }



            }
        }

        return dp[jobDifficulty.length ][d];
    }


    public int minDifficulty2(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;
        int[][] dp = new int[D][N];

        dp[0][0] = jobDifficulty[0];
        for(int j = 1; j < N; ++j){
            dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);
        }

        for(int d = 1; d < D; ++d){
            for(int len = d; len < N; ++len){
                int localMax = jobDifficulty[len];
                dp[d][len] = Integer.MAX_VALUE;

                for(int schedule = len; schedule >= d; --schedule){

                    localMax = Math.max(localMax, jobDifficulty[schedule]);
                    dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
                }
            }
        }

        return dp[D - 1][N - 1];
    }


    public static void main(String[] args) {
        JobSchedule js  =  new JobSchedule();
        System.out.println(js.minDifficulty( new int[] {1,3,8,2}, 3 ));
        System.out.println(js.minDifficulty2( new int[] {1,3,8,2}, 3 ));
        //System.out.println(js.minDifficulty0( new int[] {1,3,8,2}, 3 ));

    }

}
