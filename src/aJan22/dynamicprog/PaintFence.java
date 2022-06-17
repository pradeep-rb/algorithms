package aJan22.dynamicprog;

//276
/*


    Determining the recurrance relation was not easy on this one.
       totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);

       * came close a second time. correctly determined the following
       1)  there needs to be a recurrence relation
       2)  total ways is a function of n and k
       3) drew the decision tree and tried to derive the recurrence relation from that mathematically
       -- this is flawed as it doesn't really consider WHAT DECISIONS DO I NEED TO BE MAKING WHEN I PERFORM TASK(I)

       issue :  I wasn't thinking about how im going to paint the i the fence.
       ith fence will be a function of (contingent on ) painting the i-1 and the i-2 th fence a certain way :  this is the key!!

        f(i)  ~  k  and f(i-1) and f(i-2)

        ith fence can be painted the same as i-1 or painted different from i-1  [this follows the same patter as the robber or the stock problem]
        f(i) ~  some factor of k on [ painting i different color as prev   + painting i same color as prev +  ]
        f(i)   =       (k-1) * f(i-1)  +   1 * f(i-1) IFF i-2th fence is a different color than f(i-1)
               =        (k-1) * f(i-1)  +    (k-1) * f(i-2)
                     = (k-1) * [f(i-1) + f(i-2)]


     This problem is same as the stock and robber problem in the following way:
        At avery point in the decision tree, there are more than 1 decision that can be made. The decision to be made is contingent
        on  previous decision(s)


     This problem is different from the stock and robber problem in the following way:
        At every point in the decision making process, we maximize or minimize the cost / reward by picking one of the many decisions available
        In the paint problem we are interested in the COUNT of all possible ways / decisions.
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
