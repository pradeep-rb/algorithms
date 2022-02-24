package aug21.misc;

import java.util.ArrayList;
import java.util.List;

public class PrintNumbers {

    void printNum(int num) {

        List<Integer> ans = new ArrayList<>();
        while (num > 0) {
            ans.add( num % 10 );
            num  = num / 10;
        }



        ans.stream()
//                .peek(System.out::println)
                .sorted()
                .forEach(System.out::println);


    }

    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();

        pn.printNum(1234);
    }

}
