package asep20.divconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//241
public class WaysAddParantheses {

    List<Integer> ans = new ArrayList<>();


    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*' || input.charAt(i) == '-' || input.charAt(i) == '+') {
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (Integer l : leftList) {
                    for (Integer r : rightList) {

                        switch (input.charAt(i)) {
                            case '*':
                                ans.add(l * r);
                                break;
                            case '-':
                                ans.add(l - r);
                                break;
                            case '+':
                                ans.add(l + r);
                                break;
                        }

                    }
                }

            }
        }

        if(ans.size() == 0 ){
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }




    public static void main(String[] args) {
        WaysAddParantheses wap = new WaysAddParantheses();
        wap.diffWaysToCompute("2*3-4*5");
    }


}
