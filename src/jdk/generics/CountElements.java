package jdk.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Write a generic method to count the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes)
public class CountElements {


    public static <T extends  Number> int count(Collection<T> c, UnaryPredicate<T> p) {

        int count = 0;
        for(T elem: c) {
            if(p.test(elem)) count++;
        }

        return count++;
    }


    public static void main(String[] args) {

        Collection<Double> dList = Arrays.asList(50.0, 102.0, 500.0, 4.0);
        Collection<String> sList = Arrays.asList("a", "b");

        System.out.println(count(dList, new GreaterThan100Predicate()));
        //System.out.println(count(sList, new GreaterThan100Predicate()));
    }


}
