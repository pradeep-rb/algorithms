package aJan22.binarysearch;


import java.sql.SQLOutput;

//33
/*
    goal:  log(n)
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        int start  = 0;
        int end = nums.length - 1;

        while (start <= end )  {
            //System.out.println("start: " + start + " end: " + end);
            int mid =  (start + end)  / 2;

            if(target == nums[mid]) return mid;
            if( nums[mid] >= nums[start])  {
                if( target >= nums[start] && target < nums[mid])  end = mid - 1;
                else start = mid + 1;
            }
            else {
                if( target > nums[mid] && target <= nums[end])  start = mid  + 1;
                else  end = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray bs = new SearchRotatedSortedArray();
        System.out.println(bs.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(bs.search(new int[]{3, 1}, 1));
    }


}
