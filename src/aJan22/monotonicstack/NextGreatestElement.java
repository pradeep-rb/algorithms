package aJan22.monotonicstack;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//not a leetcode pblm
public class NextGreatestElement {

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            while( !stack.isEmpty() &&  nums[i] >= stack.peek() )  stack.pop();
            ans[i]  = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }


        return ans;
    }


    public static void main(String[] args) {
        NextGreatestElement nge = new NextGreatestElement();
        Arrays.stream(nge.nextGreaterElements(new int[]{2, 1, 2, 4, 3})).forEach(System.out::println);
    }

}
