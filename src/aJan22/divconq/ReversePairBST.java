package aJan22.divconq;


public class ReversePairBST {

    int search(Node root, int val) {
        if(root == null) return 0;
        //reverse pair
        else if(root.val > val)return root.cnt +  search(root.left ,  val);
        return search(root.right ,  val);
    }


    Node insert(Node root, int val) {
        if(root == null) root = new Node(val);
        else if(root.val == val) root.cnt++;
        else if(root.val > val) root.left = insert(root.left, val);
        else {
            root.cnt++;
            root.right = insert(root.right, val);
        }
        return root;
    }

    int getReversePair(int[] nums){

        int res=0;
        Node root = null;
        for (int num: nums) {
            res += search(root,  2 * num);
            root =   insert(root, num);
        }

        return res;
    }

    public static void main(String[] args) {

        ReversePairBST rp = new ReversePairBST();
        System.out.println(rp.getReversePair(new int[] {2,4,3,5,1}));
    }



    class Node {

        int val;
        Node left;
        Node right;

        int cnt;

        public Node(int val) {
            this.val = val;
            cnt = 1;
        }

    }
}
