package aJan22.slidingwindow;

//1004
public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0;

        int zerosToFlip = 0;
        int max = 0;

        // Iterate over elements in our input
        while (right < nums.length) {
            //Expand the window
            if(nums[right] == 0 ) zerosToFlip++;

            //Meet the condition to stop expansion
            if(zerosToFlip > k) {
                if(nums[left] == 0)    zerosToFlip--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes3 mco = new MaxConsecutiveOnes3();
        System.out.println(mco.longestOnes( new int[]{0,0,1,1,0,0,0,1,0,0,0}, 2));
    }

}
