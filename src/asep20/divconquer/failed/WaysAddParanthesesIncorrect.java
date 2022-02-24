package asep20.divconquer.failed;

import java.util.*;

//241
public class WaysAddParanthesesIncorrect {

    List<Integer> ans = new ArrayList<>();


    //the approach produces duplicate path.  not exactly divide and conquer
     public  void compute(List<String> ip) {
         if(ip.size() == 1) {
             ans.add(Integer.parseInt(ip.get(0)));
             return;
         }
         for (int i = 1; i < ip.size() - 1; i+= 2) {

             int op1 = Integer.parseInt( ip.get(i-1));
             int op2 = Integer.parseInt( ip.get(i+1));
             char operand =  ip.get(i).charAt(0);
             int res;
             if(operand == '*')  res = op1 * op2;
             else if(operand == '-') res = op1 - op2;
             else res = op1 + op2;

             List<String> newInput = new LinkedList<>(ip);

             newInput.remove(i-1);
             newInput.remove(i-1);
             newInput.remove(i-1);
             newInput.add(i-1, Integer.toString(res));


             compute(newInput);

         }

         ip.size();
     }


    public List<Integer> diffWaysToCompute(String input) {
        compute( new LinkedList<>(Arrays.asList(input.split("(?<=[-+*])|(?=[-+*])"))));
        return  ans;
    }


    public static void main(String[] args) {
        WaysAddParanthesesIncorrect wap = new WaysAddParanthesesIncorrect();
        wap.diffWaysToCompute("2*3-4*5");
    }


}
