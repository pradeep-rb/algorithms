package general;

import java.util.Arrays;

public class Rotate {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] rot = new int[nums.length];

        int i=0; int j = k;

        while(j < nums.length) {
            rot[j++] = nums[i++];
        }

        j=0;
        while(i < nums.length) {
            rot[j++] = nums[i++];
        }
        nums = rot;

        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        Rotate.rotate(nums, 3);
    }
}
