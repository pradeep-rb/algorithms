package aJan22.linkedlist;


//430
//fucking genius

public class FlattenDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {

        Node curr = head;

        while(curr != null) {

            if(curr.child != null)  {

                Node next = curr.next;
                curr.next = curr.child;
                curr.child = null;
                curr.next.prev = curr;
                Node tail = flatten(curr.next);

                while(tail.next != null) tail = tail.next;

                if(next != null)
                    next.prev = tail;
                tail.next = next;

                curr = next;
            }
            else curr = curr.next;
        }

        return head;
    }
}
