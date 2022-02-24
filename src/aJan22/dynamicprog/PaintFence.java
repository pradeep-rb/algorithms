package aJan22.dynamicprog;

//276
/*


    Determing the recurrance relation was not easy on this one.
       totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);

 */


public class PaintFence {
    public int numWays(int n, int k) {
        // Base cases for the problem to avoid index out of bound issues
        if (n == 1) return k;
        if (n == 2) return k * k;

        int totalWays[] = new int[n + 1];
        totalWays[1] = k;
        totalWays[2] = k * k;

        for (int i = 3; i <= n; i++) {
            totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);
        }

        return totalWays[n];
    }
}
