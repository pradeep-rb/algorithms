package aJan22.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.DoubleStream;

//295
//log(n)
/*
    intuition for the second solution.
    minHeap is meant to have = or 1 more than maxheap elements.
    instead of caring about whats at the top of the min/max heap,
    can you always add to one of the heaps and try to re-balance later ?

 */
class MedianFinder {

    //large ones
    PriorityQueue<Integer> minHeap;

    //small ones
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>( (a, b) -> b - a);
    }
    
    public void addNum(int num) {
        //solution 1
        //this works too but he one below is very concise
        /*if(!maxHeap.isEmpty() && num <= maxHeap.peek()) {
            if(minHeap.size() == maxHeap.size()){
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
            else maxHeap.add(num);
        }
        else {
            if(minHeap.size() > maxHeap.size()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
            else minHeap.add(num);
        }*/

        //solution 2
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if(minHeap.size() < maxHeap.size()) minHeap.add(maxHeap.poll());


    }
    
    public double findMedian() {
        return  minHeap.size() == maxHeap.size()  ?   new Double( maxHeap.peek() + minHeap.peek()) * 0.5 : new Double(minHeap.peek());
        /*if(minHeap.size() == maxHeap.size()) return  new Double( maxHeap.peek() + minHeap.peek()) / 2.0;
        else return new Double(minHeap.peek());*/
    }
}