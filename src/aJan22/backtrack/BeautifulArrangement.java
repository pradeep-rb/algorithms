package aJan22.backtrack;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.IntStream;

//526
/*

    lessons learnt:
    * keeping a visited state to track selections
    * avoid copying arrays / creating additional memory
    * during backtracking, try to prune paths ahead of time
    * remember the deselect step in the following pseudo code:
        for seletion in Seletion List:
            select
            backtrack(Path, Seletion List)
            deselect

   Complexity:  o(k) k is the number of  beautiful arrangements
 */
public class BeautifulArrangement {

    int count = 0;
    int n;

    public int countArrangement(int n) {
        this.n = n;
        boolean used[] = new boolean[n+1];
        calculate(used,  1);
        return count;
    }

    private void calculate(boolean[] used, int currIdx) {

        if(currIdx > n)  count++;

        for (int i = 1; i <= n ; i++) {
            if (used[i]) continue;
            if (i % currIdx != 0 && currIdx % i != 0) continue;
            used[i] = true;
            calculate(used, currIdx+1);
            used[i] = false;
        }
    }



    public static void main(String[] args) {
        BeautifulArrangement ba = new BeautifulArrangement();
        System.out.println(ba.countArrangement(5));
    }
}
