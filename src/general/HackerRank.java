package general;

import java.util.*;

public class HackerRank {

    static boolean  isSubSequence(String str1,
                                 String str2) {
        int j = 0;
        int m = str1.length();
        int n = str2.length();

        for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;

        return (j >0 );
    }


    public static List<Integer> autocomplete(List<String> command) {
        // Write your code here

        List<Integer> ansList = new ArrayList<>();
        List<String> input = new ArrayList<>();

        for (int k = 0; k < command.size(); k++) {
            input.add(command.get(k));
            for (int i = 0; i < input.size(); i++) {
                boolean ans = false;
                for (int j = 0; j < input.size(); j++) {
                    if(i == j) continue;

                     ans = isSubSequence(input.get(j), input.get(i));
                    if(ans) {
                        ansList.add(i);
                        break;
                    }

                }
                if(!ans) {
                    ansList.add(i);
                }
            }
        }

        return ansList;
    }

    public static void main(String[] args) {

        HackerRank hr =  new HackerRank();

        System.out.println(hr.autocomplete(Arrays.asList(new String[]{"100110",
                        "1001",
                        "1001111"})
                ));

    }
}
