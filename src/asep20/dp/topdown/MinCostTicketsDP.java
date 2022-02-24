package asep20.dp.topdown;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/minimum-cost-for-tickets/
//retry this problems as a classic dp.
public class MinCostTicketsDP {

    int w[] = new int[]{1, 7, 30};
    Map<Integer, Integer> memo = new HashMap<>();

    public int mincostTickets(int[] days, int[] costs, int day) {
        int min = Integer.MAX_VALUE;
        if(day >  days[days.length - 1]) return  0;

        int sIdx = 0;
        for (int j = 0; j < days.length; j++) {
            if(days[j] >= day) {
                sIdx = j;
                break;
            }
        }
       /* sIdx = Arrays.binarySearch(days, day);
        sIdx = sIdx < 0 ? sIdx * -1  - 1: sIdx ;
        System.out.println(day + ":" + sIdx);*/

        if(memo.containsKey(days[sIdx])) return  memo.get(days[sIdx]);

        for (int i = 0; i < costs.length ; i++) {
          min = Math.min( costs[i] +  mincostTickets(days ,costs, days[sIdx] + w[i] ), min);
        }

        memo.put(days[sIdx], min);

        return min;
    }

    public int mincostTickets(int[] days, int[] costs) {
        return  mincostTickets(days, costs, 0);
    }

    public static void main(String[] args) {
        MinCostTicketsDP mct = new MinCostTicketsDP();

        mct.mincostTickets(new int[]{1, 4,6, 7, 8, 20}, new int[]{2 , 7, 15} );
    }

}
