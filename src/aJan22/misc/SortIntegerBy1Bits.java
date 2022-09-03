package aJan22.misc;

import java.util.Arrays;
import java.util.Comparator;

//1356
public class SortIntegerBy1Bits {
    public int[] sortByBits(int[] arr) {
        int[][] pairs =  new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) pairs[i][0] = arr[i];
        countBits(pairs);
        //secondary sort
        Arrays.sort(pairs, (a, b) ->  a[1] == b[1] ? a[0] - b[0] :  a[1] - b[1]);
        return Arrays.stream(pairs).mapToInt( x -> x[0]).toArray();
    }

    private void countBits(int[][] pairs) {
        for (int[]  pair : pairs) {
            int n = pair[0];
            int cnt = 0;
            while ( n > 0) {
                cnt++;
                //this removes the least significant bit that is 1
                n = n & (n - 1);
            }
            pair[1] = cnt;
        }
    }
}
