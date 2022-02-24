package asep20.hacker;

import java.util.*;

public class ThrottleGateWay {

    public static int droppedRequests(List<Integer> requestTime) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack10 = new Stack<>();
        Stack<Integer> stack60 = new Stack<>();

        Queue<Integer> queue = new LinkedList<>();
        for(int rTime : requestTime) {
            queue.offer(rTime);
        }

        int last1 =1;
        int last10 = 1;
        int last60 = 1;

        int dropped =0;


        while (!queue.isEmpty()) {
            int rTime = queue.poll();
            stack1.push(rTime);
            stack10.push(rTime);
            stack60.push(rTime);


            if(stack1.size() == 3 ) {
                 if(stack1.peek() ==  queue.peek()) {
                     dropped++;
                     int val = queue.poll();
                     stack10.push(val);
                     stack60.push(val);
                 }
                 stack1.clear();
            }
            if(stack10.size() >= 20 && rTime - last10  < 10 ) {
                if(stack10.peek() == rTime) {
                    dropped++;
                    queue.poll();
                    int val = queue.poll();
                    stack60.push(val);
                }
                else {
                    stack10.clear();
                    last10 = rTime;
                }
            }
            if(stack60.size() >= 60 && rTime - last60 < 60 ) {
                if(stack60.peek() == rTime ) {
                    dropped++;
                    queue.poll();
                }
                else {
                    stack60.clear();
                    last60 = rTime;
                }
            }


        }

        return dropped;
    }


    public static void main(String[] args) {


        ThrottleGateWay.droppedRequests(Arrays.asList(1 ,1 ,1 ,1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7));
                //11 ,11, 11 ,11 ));
    }
}
