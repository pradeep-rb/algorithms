package aJan22.design;

import java.util.*;

//716. Max Stack
// we need a custom doubly linked list so that the tree map can store the dll node for removal.
// this is similar to LRU cache
class MaxStack {
    TreeMap<Integer, List<DoublyLinkedNode>> maxMap =  new TreeMap<>();
    DoublyLinkedList dll = new DoublyLinkedList();


    public MaxStack() {
        
    }
    
    public void push(int x) {
        DoublyLinkedNode top = dll.head.next;
        DoublyLinkedNode newTop = new DoublyLinkedNode(x);
        dll.head.next = newTop;
        top.prev = newTop;
        newTop.next = top;
        newTop.prev =  dll.head;
        maxMap.computeIfAbsent(x, k -> new ArrayList<>()).add(newTop);
        
    }
    
    public int pop() {
        if(dll.head.next == dll.tail) return -1;
        DoublyLinkedNode top = dll.head.next;
        DoublyLinkedNode newTop = top.next;
        dll.head.next = newTop;
        newTop.prev = dll.head;

        List<DoublyLinkedNode> listToRemove = maxMap.getOrDefault(top.val, new LinkedList<>());
        listToRemove.remove(top);
        if(listToRemove.isEmpty()) maxMap.remove(top.val);

        return top.val;

    }

    public MaxStack(DoublyLinkedList dll) {
        this.dll = dll;
    }

    public int top() {
        return  dll.head.next.val;
    }
    
    public int peekMax() {
        return maxMap.lastKey();
    }
    
    public int popMax() {

        int key =  maxMap.lastKey();
        List<DoublyLinkedNode> listToRemove = maxMap.getOrDefault(key, new LinkedList<>());
        DoublyLinkedNode toRemove = listToRemove.remove( listToRemove.size() - 1 );
        if(toRemove != null) {
            DoublyLinkedNode prev = toRemove.prev;
            DoublyLinkedNode next = toRemove.next;
            prev.next = next;
            next.prev = prev;
        }
        if(listToRemove.isEmpty()) maxMap.remove(key);

        return key;
        
    }


    class DoublyLinkedList {
        DoublyLinkedNode head = new DoublyLinkedNode(-1);
        DoublyLinkedNode tail = new DoublyLinkedNode(-1);

        public DoublyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

    }


    class DoublyLinkedNode {
        int val;
        DoublyLinkedNode prev, next;

        public DoublyLinkedNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] the top of the stack and the maximum number is 5.
        stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        stk.top();     // return 5, [5, 1, 5] the stack did not change.
        stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        stk.top();     // return 1, [5, 1] the stack did not change.
        stk.peekMax(); // return 5, [5, 1] the stack did not change.
        stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
        stk.top();     // return 5, [5
    }
}