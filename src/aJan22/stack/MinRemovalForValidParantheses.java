package aJan22.stack;

import java.util.Deque;
import java.util.LinkedList;

//1249
/*
    revise: Storing characters in to the stack. But this would not have resulted in an O(n) solution as elements
    would have to be popped out and popped back in to the stack
    * Solution is to store the indices of unwanted parantheses in the stack instead, that can be deleted later
    * A string builder is used as string is mutable and would have not resulted in an O(n) solution.
 */
public class MinRemovalForValidParantheses {


    public String minRemoveToMakeValid(String s) {

        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb  = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '(')  stack.push(i);
            else if(curr == ')') {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
                else stack.push(i);
            }
        }
        while (!stack.isEmpty()) sb.deleteCharAt(stack.pop());

        return sb.toString();
    }


    public static void main(String[] args) {
        MinRemovalForValidParantheses mrp = new MinRemovalForValidParantheses();
        System.out.println(mrp.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(mrp.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(mrp.minRemoveToMakeValid("))(("));
    }

}
