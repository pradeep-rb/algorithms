package aJan22.Tree;

import aJan22.ds.TreeNode;

//333
// A good problem to get you to learn a few things about recursion in trees.
public class LargestBSTSubtree {

    public int[] getMaxBST(TreeNode root) {
        // 0 -> min, 1 -> max, 2 -> count
        if(root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0} ;

        int[] left =   getMaxBST(root.left);
        int[] right =  getMaxBST(root.right);

        if( root.val > left[1]  && root.val < right[0])
            return  new int[] {  Math.min(root.val, left[0])  ,  Math.max(root.val, right[1])  , 1 + left[2] + right[2]};

        return  new int[] {  Integer.MIN_VALUE, Integer.MAX_VALUE,  Math.max(left[2], right[2]) };
    }


    public int largestBSTSubtree(TreeNode root) {
        return  getMaxBST(root)[2];
    }

    //revise
    /*

       * mistakes: jumped in head first without enough examples
       * repeated test case failure made me realize that the original approach of using upper and lower bounds in a top down fashion
        a) dint work for the way it was coded
        b) would be inefficient as we'd have to recompute the validity of a BST tree for every node from top to bottom

       * A bottom up approach was more suited.
       * But how to check validity of a BST in a bottom up fashion  ?
        enter, checking  if the root is greater than the max of the left subtree and lesser than min of the right subtree

     */
}
