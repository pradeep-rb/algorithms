package aJan22.misc;

import java.util.LinkedList;

//1823
// pick the trick of modulo  operation from Robot bound in circle.
// another way to do it have a for loop on k, remove every element and add at end of list. then remove kth element.
public class WinnerCircularGame {

    public int findTheWinner(int n, int k) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        int toRemove = 0;
        while (list.size() > 1) {
            toRemove = ( toRemove + k - 1 ) % list.size();
            list.remove(toRemove);
        }
        return list.poll();
    }

}
