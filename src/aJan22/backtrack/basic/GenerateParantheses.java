package aJan22.backtrack.basic;

import java.util.ArrayList;
import java.util.List;


/*
    22. Generate Parentheses
      This might not seem like a backtracking problem but it actually is.  The back tracking is actually quite subtle
      At every point in the decision tree, you got to decide if you need a  open ( |*OR*| close ) parentheses
      The  choice making / OR -> is where the backtracking comes in to picture.
        During the recursion, If you have  already made a choice (and ready to explore that path), you need to undo that choice
        and explore some other choices, essentially backtracking.

      So the backtracking in this problem can be done in the following way:
       String newPath = path + ("("); and pass the new path to the recursion call

 */
public class GenerateParantheses {

    List<String> ans = new ArrayList<>();

    public List<String> backtrack(String path, int open, int close, int n) {
        //System.out.println("open: " + open + " close: " + close  + " path: " + path );
        if(open == n && close == n) ans.add(path);

        if (open < n ) {
           // String newPath = path + ("(");
            backtrack( path + "(", open + 1 , close, n );

        }
        if(close < open ) {
          //  path = path + (")");
            backtrack( path + ")", open, close + 1, n);
        }

        return ans;
    }


    public List<String> generateParenthesis(int n) {
        return  backtrack("", 0 , 0, n);
    }

    public static void main(String[] args) {
        GenerateParantheses gp = new GenerateParantheses();
        System.out.println( gp.generateParenthesis(3));
    }

}
