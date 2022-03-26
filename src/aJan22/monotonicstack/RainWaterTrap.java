package aJan22.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
//42. Trapping Rain Water
// decreasing monotonic stack
public class RainWaterTrap {

    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < height.length ; i++) {
            //pop only if current element is greater than top of stack
            while( !stack.isEmpty() &&  height[i] > height[stack.peek()]) {

                int bottomHeight = height[stack.pop()];
                if(stack.isEmpty()) break;
                int minHeight = Math.min(height[i], height[stack.peek()]);
                ans +=   ( minHeight - bottomHeight) *  (i - stack.peek() - 1);
            }

            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        RainWaterTrap rwt = new RainWaterTrap();
        System.out.println(rwt.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(rwt.trap(new int[]{4,2,0,3,2,5}));
        //System.out.println(rwt.trap(new int[]{1,0,2}));
    }
}
