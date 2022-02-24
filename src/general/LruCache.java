package general;

import datastruct.Node;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;

public class LruCache {

    /*
            o(1) get
            o(1) put  -> evicts the least recently used

     */

    int capacity = -1;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    Map<Integer, Node>  cache = new HashMap<>();

    public  void addFirst(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public  void remove(Node node) {
          Node parent = node.prev;
          parent.next = node.next;
          node.next.prev = parent;
    }

    public LruCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        } else {
            if (capacity == cache.size()) {
                Node node = tail.prev;
                remove(node);
                cache.remove(node.key);
            }
            Node node = new Node(key, value);
            addFirst(node);
            cache.put(key, node);
        }
    }



    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
//        LruCache lruCache = new LruCache(3);
//
//        lruCache.put(1, 11);
//        lruCache.put(2, 22);
//        lruCache.put(3, 33);
//        lruCache.get(1);
//        lruCache.put(4, 44);


       // System.out.println(lruCache.get());
        //System.out.println(lruCache.put(,));
        LruCache lruCache = new LruCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);

        //null, -1, null, -1, null,


    }


    //["LRUCache","get","put","get","put","put","get","get"]
    //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

}
