package aJan22.design;

import java.util.ArrayList;
import java.util.List;

//1472
// better than leetcode solution
class BrowserHistory {

    ArrayList<String>  history = new ArrayList<>();
    int curr = -1;
    int limit = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
        curr++; limit = curr;
    }

    public void visit(String url) {
        history.add(++curr, url);
        limit = curr;
    }

    public String back(int steps) {
        if( steps > curr ) curr  = 0;
        else curr -= steps;

        return history.get(curr);
    }

    public String forward(int steps) {
        if( curr + steps >= limit) curr  = limit ;
        else curr += steps;
        return history.get(curr);
    }
}
