package asep20.linkedlist;
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/solution/
public class FlattenMultilevelList {
    Node tail = null;

    public void rearrage(Node curr, Node ancestor) {
        Node ancNext = ancestor.next;
        ancestor.child = null;
        ancestor.next = curr;
        curr.prev = ancestor;
        tail.next = ancNext;
        if(ancNext != null) ancNext.prev = tail;

    }

    public void traverse(Node curr, Node ancestor) {
        Node child = curr.child;
        Node next =  curr.next;
        Node prev = curr.prev;

        if(child != null)  traverse(child, curr);
        if(next != null)  traverse(next, null);
        if(child == null && next == null ) tail = curr;
        if(prev == null && ancestor != null && tail != null) rearrage(curr, ancestor);

    }


    public Node flatten(Node head) {
        if (head == null)  return null;
        traverse(head, null);
        return  head;
    }


    public static void main(String[] args) {
        FlattenMultilevelList flatten = new FlattenMultilevelList();


        Node one =  new Node(1,  null, null, null);
        Node two =  new Node(2,  null, null, null);
        Node three =  new Node(3,  null, null, null);
        Node four =  new Node(4,  null, null, null);
        Node five =  new Node(5,  null, null, null);

        one.next = two;two.prev = one;
        two.next = five; two.child = three;
        five.prev = two;
        three.next = four;
        four.prev=three;


        flatten.flatten(one);


    }


}

