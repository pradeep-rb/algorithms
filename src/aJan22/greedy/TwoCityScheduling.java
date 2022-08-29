package aJan22.greedy;


import java.util.Arrays;

//1029
// requirement: half candidates in first city and half candidates in other city

public class TwoCityScheduling {


    public int twoCitySchedCost(int[][] costs) {

        int ans = 0;

        // optimize for the  opportunity cost of picking one city over the other
        Arrays.sort( costs, (e1, e2) ->  (e1[0] - e1[1]) - (e2[0] - e2[1])  );
        Arrays.stream(costs).forEach(x -> System.out.println(" " + x[0] + "," + x[1] ));

        int n = costs.length;

        for (int i = 0; i < n; i++) {
            if(i < (costs.length / 2) ) ans+= costs[i][0];
            else  ans+= costs[i][1];
        }

        return  ans;
    }

    public static void main(String[] args) {
        TwoCityScheduling tcs = new TwoCityScheduling();
        System.out.println(tcs.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
    }

}
