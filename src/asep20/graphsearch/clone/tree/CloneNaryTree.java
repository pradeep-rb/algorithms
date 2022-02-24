package asep20.graphsearch.clone.tree;

public class CloneNaryTree {
    public Node cloneTree(Node root) {

        if( root == null ) return null;

        Node cloned = new Node(root.val);

        for (Node child: root.children) {
             cloned.children.add(cloneTree(child));
        }
        return  cloned;
    }

}
