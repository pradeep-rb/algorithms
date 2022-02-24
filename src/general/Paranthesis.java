package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paranthesis {

    List<String> output = new ArrayList();

    public List<String> generateParenthesis(int n) {
        generateParenthesis("",0, 0,  n);

        return output;
    }

    public void generateParenthesis(String partial, int open, int close,   int n) {
        if(partial.length() == 2 * n) {
            output.add(partial);
            return;
        }

        if(open < n) {
            generateParenthesis( partial + "(" , open+1, close, n );
        }
        if(close < open) {
            generateParenthesis( partial + ")" , open, close+1, n );
        }
    }

    public static void main(String[] args) {
        Paranthesis pc = new Paranthesis();;
        System.out.println(pc.generateParenthesis(4));
    }
}
