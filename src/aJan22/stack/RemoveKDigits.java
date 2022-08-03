package aJan22.stack;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

//402. Remove K Digits
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            while (stack.size() > 0  &&  k > 0 && num.charAt(i)  <  stack.peek() ) {
                stack.pop(); k--;
            }
            stack.push( num.charAt(i) );
        }

        while (k > 0) {
            stack.removeFirst(); k--;
        }

        StringBuilder res = new StringBuilder( stack.stream().map(String::valueOf).collect(Collectors.joining(""))).reverse();

        int idx = 0;
        for (int i = 0; i < res.length() ; i++) {
            if(res.charAt(idx) == '0') idx++;
            else break;
        }
        String ans = res.substring( idx , res.length());

        return ans.isEmpty() ? "0" : ans  ;
    }


    public static void main(String[] args) {
        RemoveKDigits rk = new RemoveKDigits();
        //System.out.println(rk.removeKdigits("1432219", 3));
        //System.out.println(rk.removeKdigits("12345264", 4));
        //System.out.println(rk.removeKdigits("10200", 1));
        //System.out.println(rk.removeKdigits("10", 2));
    }

}
