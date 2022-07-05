package aJan22.binarysearch;

import java.util.*;


//1642

public class FurthestBuildingReach {

    boolean canBeReached(int building, int[] heights, int bricks, int ladders) {

        LinkedList<Integer> climbs = new LinkedList<>();
        for (int i = 0; i < building; i++) {
            if(heights[i+1] - heights[i] > 0) climbs.add(heights[i+1] - heights[i]);
        }
        Collections.sort(climbs, (a, b) -> b - a);

        while( ladders > 0 && climbs.size() > 0) {
            climbs.removeFirst();
            ladders--;
        }
        for (int climb : climbs) bricks -= climb;

        return bricks >= 0;
    }


    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        int low = 0;
        int high = heights.length - 1 ;

        while ( low <  high) {
            int mid = (low + high) / 2 + 1;
            if(canBeReached(mid, heights, bricks, ladders)) low = mid;
            else high = mid - 1;
        }
        return  low;
    }

    public static void main(String[] args) {
        FurthestBuildingReach fbr = new FurthestBuildingReach();
        System.out.println(fbr.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        System.out.println(fbr.furthestBuilding(new int[]{14,3,19,3}, 17, 0));
        System.out.println(fbr.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
        System.out.println(fbr.furthestBuilding(new int[]{1,2,4,7}, 3, 1));
        System.out.println(fbr.furthestBuilding(new int[]{1,2}, 0, 0));
        System.out.println(fbr.furthestBuilding(new int[]{7, 5 , 13}, 0, 0));
    }
}
