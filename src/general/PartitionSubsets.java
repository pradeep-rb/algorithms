package general;

import java.util.Arrays;
import java.util.Collections;

public class PartitionSubsets {


    boolean search(int[] nums, int target) {
        if(target ==0) return  true;
        if(target < 0) return false;

        for (int i = 0, j = nums.length-1;  i < nums.length; i++, j--) {
            search(Arrays.copyOfRange(nums, i+1, j-1), target - nums[i] - nums[j]);

        }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) return false;
        int target= sum/k;

        Arrays.sort(nums);



        return false;
    }


    public static void main(String[] args) {
        PartitionSubsets ps = new PartitionSubsets();

        System.out.println(ps.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));

    }
}
