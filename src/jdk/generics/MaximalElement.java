package jdk.generics;

import java.util.Arrays;
import java.util.List;

//Write a generic method to find the maximal element in the range [begin, end) of a list
public class MaximalElement {


    public  static <T extends  Comparable<T>> T  max (List<T> list, int begin, int end) {
        T max = list.get(begin);
        for (int i = begin + 1; i < end; i++) {
            max =    list.get(i).compareTo(max) == 1 ? list.get(i): max;
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(max(Arrays.asList(1, 3, 4, 5, 84, 23, 52 ), 2, 5));
        System.out.println(max(Arrays.asList("ewr", "hq", "ykg", "hq", "sdg", "gws" ), 2, 5));
    }

}
