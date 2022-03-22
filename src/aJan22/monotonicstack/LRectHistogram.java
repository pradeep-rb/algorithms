package aJan22.monotonicstack;

import java.util.Deque;
import java.util.LinkedList;

//84
// [find the next smallest element to the left: scan from left to right]
public class LRectHistogram {


    public int largestRectangleArea(int[] heights) {

        //used to keep track of the indices of bars in the histogram
        //why indices instead of heights ? - indices can be used to derive heights as well as width
        Deque<Integer> stack = new LinkedList<>();
        int length = heights.length;

        //serves two purposes 1) to mark the beginning of the histogram
        //as a proxy index to mark the left end of the rectangle formed by short bars.
        stack.push(-1);

        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            //start the area calculation and pop;
            while ( stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int height =  heights[stack.pop()];
                int width  = i - 1 - stack.peek();
                maxArea = Math.max( maxArea, height * width);
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height =  heights[stack.pop()];
            int width  = length - 1 - stack.peek();
            maxArea = Math.max( maxArea, height * width);
        }

        return maxArea;
    }


    public static void main(String[] args) {
        LRectHistogram lrh = new LRectHistogram();
        System.out.println(lrh.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
