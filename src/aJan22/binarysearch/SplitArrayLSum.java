package aJan22.binarysearch;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//410

public class SplitArrayLSum {

    private int findNumSplitsNeeded(int[] nums, int mid) {
        int splitsNeeded = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum  +  nums[i] > mid) {
                splitsNeeded++;
                sum = nums[i];
            }
            else {
                sum += nums[i];
            }
        }
        return splitsNeeded ;
    }



    public int splitArray(int[] nums, int m) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int splits = m - 1 ;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }


        int l = max, h = sum;

        while(l <= h) {
            int mid =  (l+h)/2  ;
            int splitsNeeded = findNumSplitsNeeded(nums, mid);
//            System.out.println("m " + mid + " l " + l +  " h " + h + " sn " + splitsNeeded);

            if(splitsNeeded <= splits ) h = mid - 1;
            else l = mid + 1;
//            System.out.println(" l " + l +  " h " + h );
        }

        return l;
    }



    public static void main(String[] args) {
        SplitArrayLSum splitArrayLSum = new SplitArrayLSum();

        System.out.println(splitArrayLSum.splitArray(new int[] {7,2,5,10,8}, 2) );
//        System.out.println(splitArrayLSum.splitArray(new int[] {7,2,5,10,8}, 2) );
        //System.out.println(splitArrayLSum.splitArray(new int[] {1, 4, 4}, 4) );
    }
}
