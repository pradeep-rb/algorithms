package aJan22.divconq;


public class MaxSubArraySum {

    public int maxSubArray(int[] nums) {
        return  maxSubArray(nums, 0, nums.length -1);
    }

    public int maxSubArray(int[] nums, int start, int end) {

        if(start == end) return nums[start];

        int mid =  (end + start) / 2;
        // this is the part where we start from the mid and go left or right to find the max sum from
        // mid to right and from mid to left

        int curSum = 0;
        int maxLSum =  Integer.MIN_VALUE;;
        for (int i = mid; i >= start; i-- ) {
            maxLSum = Math.max(maxLSum, curSum + nums[i]);
            curSum += nums[i];
        }

        curSum = 0;
        int maxRSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= end; i++ ) {
            maxRSum = Math.max(maxRSum, curSum + nums[i]);
            curSum += nums[i];
        }

        return Math.max( maxLSum + maxRSum,
                Math.max(  maxSubArray(nums, start, mid), maxSubArray(nums, mid + 1, end) )  );
    }


    public static void main(String[] args) {
        MaxSubArraySum mss = new MaxSubArraySum();
        System.out.println(mss.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(mss.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
