package aJan22.dynamicprog;
////1395

/*
    Bottom up dp O(n ^ 2)
    Refer to LIS (300)
    Refer to Top Down Solution as well
 */
//1395

public class CountTeamsDP {

    public int numTeams(int[] rating) {
        if(rating == null || rating.length == 0){
            return 0;
        }

        int len = rating.length;
        int[] dp = new int[len];
        int count = 0;

        // first <r[i] <r[j] <r[k] order
        for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] > rating[j]){
                    //AT every index maintain a count of elements less than the element at curr index
                    dp[i]++;
                    // we know rating[i] > rating[j]
                    // dp[j] gives the number (1,2, x ... n) of elements less than ratings[j].  ( ratings(x) < ratings(j) < ratings(i)  )
                    //the n elements  can each form a triplet with elements at i and j. So just count the no. of elements at j for every iteration of i.
                    // another way to look at it: How many combos can you make with j as the middle element  and i as the element oN the right ?
                    count = count + dp[j];
                }
            }
        }

        //System.out.println(count);
        dp = new int[len];

        for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] < rating[j]){
                    dp[i]++;
                    count = count + dp[j];
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        CountTeamsDP ct = new CountTeamsDP();
        System.out.println(ct.numTeams( new int[] {1, 2, 3, 4})); //dp = {0, 1, 2, 3}   ans = 1 + 2 + 1
    }


}
