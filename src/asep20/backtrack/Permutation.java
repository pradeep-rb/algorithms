package asep20.backtrack;
//https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/detailsaboutbacktracking
//classic backtracking.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
    This is a permutation backtracking problem
    For combination, refer unique string concatenation

 */
public class Permutation {

    List<List<Character>> result = new ArrayList<>();

    public  void backtrack(char arr[], LinkedList<Character> path) {
       //if end condition met
        //add path to result
        if(path.size() == arr.length) {
            result.add( new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(path.contains(arr[i]))  continue;

            path.add(arr[i]);
            backtrack(arr, path);
            path.removeLast();
        }
    }


    public List<List<Character>>  permutations(char arr[]) {
        backtrack(arr, new LinkedList<>());
        return  result;
    }


    public static void main(String[] args) {

        Permutation perm = new Permutation();
        System.out.println(perm.permutations(new char[]{'a', 'b','c', 'd'}));
    }



}
