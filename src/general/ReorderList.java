package general;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReorderList {



   public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }


    public void reorderList(ListNode head) {

        Deque<ListNode> nodeStack =  new LinkedList<>();

       ListNode tail = head;
       while(tail != null) {
           nodeStack.push(tail);
           tail = tail.next;
       }
       int mid = nodeStack.size() / 2;
        ListNode node = head;
       while(mid > 0) {
           ListNode newNode = node.next;
           ListNode topNode = nodeStack.pop();
           node.next = topNode;
           topNode.next = newNode;
           node=newNode;
           mid--;
       }
        node.next = null;

        return;
    }

    public static void main(String[] args) {
       ReorderList rl = new ReorderList();

       ListNode head = null;

        ListNode prev = new ListNode(-1);
        for (int i = 1; i <= 7 ; i++) {
            ListNode node = new ListNode(i);
            if(i==1) head = node;
            prev.next = node;
            prev = node;

        }

        rl.reorderList(head);
    }
}
