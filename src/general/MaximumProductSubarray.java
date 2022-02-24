package general;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int max  = nums[0] ;
        int currMax = nums[0];
        int currMin = nums[0];

        int prevMin = 0;
        for(int i=1; i< nums.length; i++) {
            prevMin = currMin;
            currMin = Math.min(nums[i],  Math.min( currMin* nums[i],  currMax * nums[i]));
            currMax = Math.max(nums[i],  Math.max(currMax * nums[i], prevMin * nums[i]));

            max = Math.max(max,  currMax);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mp = new MaximumProductSubarray();
        System.out.println(mp.maxProduct(new int[] {2,3,-2,4, 1}));
        System.out.println(mp.maxProduct(new int[] {2,3,-2,4, -1}));

    }
}
