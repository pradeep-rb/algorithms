package aJan22.graph.bitmask;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//943
//https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem

public class ShortestPathSuperString {

    /*
        Algo:
        1) for every pair of words A[i], A[j] that are supposed to overlap, find the number of characters
        tha  needed to be appended to A[i] if A[j] came after it (non overlapping chars from A[j])
        Store this info in a graph / adjacency matrix

        2) We need to find the shortest permutation of elements in A
        This is a Traveling SalesMan problem of finding the shortest distance while visiting all nodes in a graph.
        Keep track of a state transition matrix of all states against the nodes to visit.
        Keep track of a path matrix that can give you the last node added for every state. This can be used for the reconstruction
        of the shortest path

     */
    public String shortestSuperstring(String[] A) {

        int n = A.length;
        //for every pair of words A[i], A[j] that are supposed to overlap, find the number of characters
        //that  needed to be appended to A[i] if A[j] came after it (non overlapping chars from A[j])
        int nonOverLapDist[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nonOverLapDist[i][j] = calculateNonOverLapLength(A[i], A[j]);
                nonOverLapDist[j][j] = calculateNonOverLapLength(A[j], A[i]);
            }
        }

        int endingMask =  (1 << n) - 1;
        //for a given state  and a node, stores the shortest distance to that node
        int[][] states = new int[endingMask + 1][n];
        //for a given state  and a node, stores the best prev node that lead to the shortest distance to this node
        int[][] path = new int[endingMask + 1][n];
        int minDist = Integer.MAX_VALUE;
        // last node that lead to the ending state with the shortest path
        // this will be the starting point for the reconstruction of the shortest path
        int lastNode = 0;

        // start at index 1 because state 0 is not interesting
        for (int i = 1; i <= endingMask ; i++) { // for every state
            Arrays.fill(states[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) { // for  every node
                // for the current state, is the node j part of the state. If so we are interested in a few thing about how we got to
                //this state from the previous state.  If not, there is nothing further to do in this iteration.
                if( (i  & ( 1 << j)) > 0) {
                    int prev = i - ( 1 << j);
                    if(prev == 0) { // no previous states.
                        states[i][j] =  A[j].length();
                        continue;
                    }

                    // for the prev state, go through all the nodes and get the shortest distance form prev to current, a
                    // also get the best previous node k, that lead to the shortest distance
                    for (int k = 0; k < n; k++) {
                        // for the prev state, go through all the nodes  to get the min distance to curr state and
                        // make note the last node that lead to this min distnace
                        if(  states[prev][k] <  Integer.MAX_VALUE &&  states[prev][k] + nonOverLapDist[k][j]   < states[i][j]) {
                            states[i][j] = states[prev][k] + nonOverLapDist[k][j];
                            path[i][j] = k;
                        }
                    }

                }
                //for the final state, keep track of the last node that lead to the min distance
                //this will be used later to reconstruct the min path
                if( i == endingMask  && states[i][j] < minDist) {
                    minDist = states[i][j];
                    lastNode = j;
                }
            }
        }

        // use the last node to go through the path array to reconstruct the answer
        Deque<Integer> stack = new LinkedList<>();
        int currState = endingMask;

        while (currState > 0) {
            stack.push(lastNode);
            int temp = currState;
            currState = currState - ( 1 << lastNode );
            lastNode = path[temp][lastNode];
        }

        // build the path
        StringBuilder sb = new StringBuilder();

        // the first element/word has no prev parents. So add the whole word
        int i = stack.pop();
        sb.append(A[i]);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            sb.append( A[j].substring(A[j].length() - nonOverLapDist[i][j]) );
            i = j;
        }

        return sb.toString();
    }

    private int calculateNonOverLapLength(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if( b.startsWith(a.substring(i)) ) return b.length() - a.length() + i;
        }
        return b.length();
    }
}
