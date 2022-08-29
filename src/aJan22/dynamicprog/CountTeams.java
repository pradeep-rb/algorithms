package aJan22.dynamicprog;
import java.util.Arrays;


//1395
/*
    Refer to LIS (300)
    Refer to Bottom Up Solution as well


    TLE because this is a o(n^3) solution

    Learning:

    The recurrence relation did not really need a loop.

 */
public class CountTeams {

    int ans  = 0;
    int rating[];

    int memoInc[][][] ;
    int memoDec[][][] ;

     int countInc(int prev,  int curr, int cntLeft) {
        int cnt = 0;

        if(cntLeft == 0) return  1;
        if(curr == rating.length ) return 0;
        if( memoInc[prev][curr][cntLeft] != -1) return memoInc[prev][curr][cntLeft];

        if (rating[prev] < rating[curr]  ) {
          cnt +=   countInc(curr, curr + 1,  cntLeft - 1);
        }
        cnt +=   countInc(prev, curr + 1,  cntLeft );
        return memoInc[prev][curr][cntLeft] = cnt;
    }

    int countDec( int prev,  int curr, int cntLeft) {

        int cnt = 0;

        if(cntLeft == 0) return  1;
        if(curr == rating.length ) return 0;

        if( memoDec[prev][curr][cntLeft] != -1) return memoDec[prev][curr][cntLeft];

        if (rating[prev] > rating[curr]  ) {
            cnt +=   countDec(curr, curr + 1,  cntLeft - 1);
        }
        cnt +=   countDec(prev, curr + 1,  cntLeft );
        return memoDec[prev][curr][cntLeft] = cnt;

    }


    public int numTeams(int[] rating) {
        this.rating = rating;
        int n = rating.length;
         memoDec = new int[n][n][3];
         memoInc = new int[n][n][3];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memoInc[i][j], -1);
                Arrays.fill(memoDec[i][j], -1);
            }
        }


        for (int i = 0; i < rating.length - 2; i++) {
            ans += countInc(i, i+1,  2);
            ans += countDec(i, i+1,  2);
        }

        return ans;
    }


    public static void main(String[] args) {
        //System.out.println( new CountTeams().numTeams( new int[]{2,5,3,4,1 }) );
//        System.out.println( new CountTeams().numTeams( new int[]{3,7,5,6 }) );
        System.out.println( new CountTeams().numTeams( new int[]{1,2,3,4 }) );
    }
}
