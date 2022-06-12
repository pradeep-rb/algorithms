package aJan22.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

//394
public class DecodeString {

    public String decodeString(String s) {
        String ans = "";
        int i = 0;
        Deque<Character> stack = new LinkedList<>();
        while (i < s.length()) {
                if(s.charAt(i) == ']') {
                    List<Character> temp = new LinkedList<>();

                    while (stack.peek() != '[') temp.add(stack.pop());
                    stack.pop();

                    String num = "";
                    while( !stack.isEmpty() && Character.isDigit(stack.peek()) ) {
                        num = num + stack.pop();
                    }
                    int times =  Integer.parseInt(new StringBuilder(num).reverse().toString());

                    while (times > 0) {
                        for (int j = temp.size() - 1; j >= 0; j--) {
                            stack.push(temp.get(j));
                        }
                        times--;
                    }
                }
                else {
                    stack.push(s.charAt(i));
                }
            i++;
        }

        while(!stack.isEmpty()) ans = ans + stack.pop();
        return  new StringBuilder(ans).reverse().toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        //System.out.println(ds.decodeString("3[a2[c]]"));
        System.out.println(ds.decodeString("2[abc]3[cd]ef"));
        //System.out.println(ds.decodeString("3[a]2[bc]"));;
        //System.out.println(ds.decodeString("10[leetcode]"));
    }

}
