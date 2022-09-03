package aJan22.misc;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;

// 31 next permutation
/*
    Try a big number and  notice the pattern :  .
158476531 Next perm is : 158513467

1) 1584765341  to 158 5 16 4 37   swap 5 and 4 because 5 is the next greatest number after 4.
2) reverse the rest of the characters after 5
158 5 76 4 31   ->  1585 13467


 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n - 1;

        while ( i > 0 && nums[i] <= nums[i-1] ) i--;
        int pivot = i;

        if(pivot > 0) {
            //System.out.println(nums[pivot] + ":" + nums[i - 1]);
            //find the next bigger number.
            while (i <= n - 1  && nums[pivot - 1] < nums[i]) i++;
            //System.out.println((pivot-1) + ":" + (i - 1));
            swap(pivot - 1, i - 1, nums);
        }
        reverse(pivot, n-1, nums);

        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("");
    }

    private static void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private static void reverse(int start, int end, int nums[]) {
        while ( start < end) {
            swap(start, end, nums);
            start++; end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation.nextPermutation(new int[] {4 , 3, 2, 1});
        NextPermutation.nextPermutation(new int[] {2 , 3, 1, 4});
        NextPermutation.nextPermutation(new int[] {3 , 4, 2, 1});
        NextPermutation.nextPermutation(new int[] {1,5,8,4,7,6,5,3,1});
        NextPermutation.nextPermutation(new int[] {1,5,1});
        /*
            1234
            2341
            4123
            158513467
         */
    }


}
