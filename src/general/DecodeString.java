package general;

import java.util.*;

public class DecodeString {

    public String decodeString(String s) {
        if(s.isEmpty()) return "";
        Deque<Character> stack = new LinkedList<>();
        String decoded = "";

        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == ']') {
                List<Character> temp = new ArrayList<>();
                while(stack.peek() != '[') {
                    temp.add(stack.pop());
                }
                stack.pop();
                //int cnt = Character.getNumericValue(stack.pop());
                String num = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num += stack.pop();
                }

                int cnt = Integer.parseInt(new StringBuilder(num).reverse().toString());

                while (cnt > 0) {
                    int tempCnt = temp.size();
                    while(tempCnt > 0) {
                        stack.push(temp.get(tempCnt -1));
                        tempCnt--;
                    }
                    cnt--;
                }
            }
            else {
                stack.push(s.charAt(i));
            }

        }

        while(!stack.isEmpty()){
            decoded += stack.removeLast();
        }

        return  decoded;
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();

        System.out.println(ds.decodeString("3[a]2[bc]"));
        System.out.println(ds.decodeString("3[a2[c]]"));
        System.out.println(ds.decodeString("100[leetcode]"));
    }

}
