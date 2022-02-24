package datastruct;

public class Node {
    int key;
    Node prev;
    Node next;

    public Node(int key, Node prev, Node next) {
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}
