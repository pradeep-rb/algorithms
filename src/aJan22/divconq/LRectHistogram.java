package aJan22.divconq;

import java.util.regex.Matcher;

public class LRectHistogram {


    public int largestRectangleArea(int[] heights, int start, int end) {

        //find the min height in the range start to end
        if(start > end) return 0;


        int minIdx = start;
        for (int i = start; i <= end; i++) {
            if(heights[i] < heights[minIdx] )  {
                minIdx = i;
            }
        }


        return Math.max( heights[minIdx] * (end - start + 1), Math.max( largestRectangleArea(heights, start, minIdx-1),
                largestRectangleArea(heights, minIdx+1, end))  );
    }

    public int largestRectangleArea(int[] heights) {
        return  largestRectangleArea(heights, 0, heights.length -1);
    }


    public static void main(String[] args) {
        LRectHistogram lrh = new LRectHistogram();
        System.out.println(lrh.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
