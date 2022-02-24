package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneCombo {

    List<String> output = new ArrayList<String>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {

        backtrack("", digits);

        return output;

    }

    public void backtrack(String combination, String nextDigits) {

        //base case
        if(nextDigits.length() == 0) {
            output.add(combination);
        }
        else {

            String letters = phone.get(nextDigits.substring(0,1));
            for(int i=0; i < letters.length(); i++) {
                backtrack(combination + letters.substring(i, i+1), nextDigits.substring(1));
            }


        }


    }

    public static void main(String[] args) {
        PhoneCombo pc = new PhoneCombo();;
        System.out.println(pc.letterCombinations("234"));
    }
}
