package aJan22.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//116
public class PopulatingRigthPointer {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    Map<Integer, LinkedList<Node>> levelMap = new HashMap();

    public Node connect(Node root, int level) {

        if (root == null) return null;

        if(levelMap.containsKey(level)) {
            Node prev  = levelMap.get(level).remove();
            prev.next = root;
        }

        connect(root.left, level + 1);
        connect(root.right, level + 1);

        levelMap.computeIfAbsent( level, k -> new LinkedList<Node>()).add(root);

        return root;
    }

    public Node connect(Node root) {
        return connect(root, 0);
    }
}
