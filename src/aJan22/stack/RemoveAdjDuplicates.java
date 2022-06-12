package aJan22.stack;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

//1209
public class RemoveAdjDuplicates {

    public String removeDuplicates(String s, int k) {

        Deque<Pair<Character, Integer>> stack = new LinkedList<>();
        int i = 0;
        while ( i < s.length()) {

            if(!stack.isEmpty()) {
                Pair<Character, Integer> top = stack.peek();
                if( top.getValue() < k) {
                    if (top.getKey() == s.charAt(i)) stack.push(new Pair<>(s.charAt(i), top.getValue() + 1));
                    else stack.push(new Pair<>(s.charAt(i), 1));
                    i++;
                }
                top = stack.peek();
                if(top.getValue() == k) for (int cnt = 0; cnt < k; cnt++) stack.pop();

            }
            else {
                stack.push(new Pair<>(s.charAt(i), 1));
                i++;
            }

        }
        String ans = stack.stream().map( p -> p.getKey().toString()).collect(Collectors.joining(""));

        return new StringBuilder(ans).reverse().toString();
    }


    public static void main(String[] args) {
        RemoveAdjDuplicates rad = new RemoveAdjDuplicates();
        System.out.println(rad.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(rad.removeDuplicates("abcd", 2));
        System.out.println(rad.removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(rad.removeDuplicates("abcdyyyy", 4));
    }

}
