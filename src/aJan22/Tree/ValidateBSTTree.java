package aJan22.Tree;

import aJan22.ds.TreeNode;
//98
public class ValidateBSTTree {

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // check for upper and lower bounds down the tree
    boolean isValidBST(TreeNode root, Long lower, Long upper) {

        if(root == null) return true;

        return  root.val > lower && root.val < upper  &&
                isValidBST(root.left, lower, new Long(root.val)) && isValidBST(root.right, new Long(root.val), upper);
    }

    //  ALTERNATE SOLUTION  - bottom up
    // check if root is greater than than max value in the left subtree and the min value in the right subtree.

    boolean isValidBSTBottomsUp(TreeNode root) {
        long[] left =  checkValidBST(root.left);
        long[] right = checkValidBST(root.right);
        return root.val > left[1]  && root.val < right[0];
    }

    long[] checkValidBST(TreeNode root) {

        if(root == null) return  new long[] { Long.MAX_VALUE, Long.MIN_VALUE};

        long[] left =  checkValidBST(root.left);
        long[] right = checkValidBST(root.right);

        if(root.val > left[1]  && root.val < right[0])
            return new long[] { Math.min (root.val, left[0]) ,   Math.max( root.val, right[1]) };

        return new long[] {   Long.MIN_VALUE ,   Long.MAX_VALUE};

    }

}
