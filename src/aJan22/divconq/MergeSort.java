package aJan22.divconq;

import java.util.Arrays;

public class MergeSort {


    /*
      divide to sub problems
      combine the result
     */

    void mergeSort(int[] nums) {
        mergeSortSub(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
    }

    private void mergeSortSub(int[] nums, int l, int r) {
        if (l >= r) return;

        int m =  (r + l) / 2;

        mergeSortSub(nums, l, m);
        mergeSortSub(nums, m+1, r);

        int i=l; int j = m+1; int k = 0;
        int[] merged = new int[r-l+1];

        while(i <= m) {
            while (j <= r && nums[i] >= nums[j])  merged[k++] = nums[j++];
            merged[k++] = nums[i++];
        }

        while(j <= r)  merged[k++] = nums[j++];

        System.arraycopy(merged, 0, nums, l, merged.length);

    }


    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.mergeSort(new int[] {2,4,3,5,1});

    }

}
