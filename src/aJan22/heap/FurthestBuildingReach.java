package aJan22.heap;

import java.util.PriorityQueue;


//1642
/*
    Greedy solution:  use a PQ to exhaust ladders. If ladder queue exceeds the limit, pop the entry with the min value
    and subtract from the bricks

    It is important to add one more than the queue size and pop the min value out. Otherwise the logic gets complicated

 */
public class FurthestBuildingReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> ladderAllocation = new PriorityQueue<>( (a,b) ->  a - b);

        for (int i = 0; i <  heights.length - 1; i++) {

            int climb = heights[i+1] - heights[i];
            if(climb <= 0 ) continue;

            ladderAllocation.add(climb);
            if(ladderAllocation.size() > ladders) {
                bricks -= ladderAllocation.remove();
            }

            if( bricks < 0) return i;
        }

        return heights.length - 1;
    }

    public static void main(String[] args) {
        FurthestBuildingReach fbr = new FurthestBuildingReach();
        System.out.println(fbr.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        System.out.println(fbr.furthestBuilding(new int[]{14,3,19,3}, 17, 0));
        System.out.println(fbr.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
        System.out.println(fbr.furthestBuilding(new int[]{1,2,4,7}, 3, 1));
        System.out.println(fbr.furthestBuilding(new int[]{1,2}, 0, 0));
    }
}
