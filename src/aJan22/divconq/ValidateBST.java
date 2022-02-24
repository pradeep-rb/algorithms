package aJan22.divconq;

public class ValidateBST {


    /*

        for a root node, all nodes in the left subtree are smaller and all nodes in right subtree are greater
        the left and right subtrees are themselves bst.

     */


    Node insert(Node root, int val) {
        if(root == null) root = new Node(val);
        else if( val < root.val ) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }


    boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(Node root, Long lower, Long upper) {

        if(root == null) return true;

        return  (root.val > lower && root.val < upper ) &&
                isValidBST(root.left, lower, new Long(root.val)) && isValidBST(root.right, new Long(root.val), upper);
    }


    public static void main(String[] args) {

        ValidateBST vb = new ValidateBST();
        int[] nums = new int[] {2,4,3,5,1};
        Node root = null;
        for (int num: nums) {
            root =   vb.insert(root, num);
        }

        System.out.println(vb.isValidBST(root));
    }


    class Node {

        int val;
        Node left;
        Node right;


        public Node(int val) {
            this.val = val;
        }

    }
}
