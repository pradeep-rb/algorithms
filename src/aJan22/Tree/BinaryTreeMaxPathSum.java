package aJan22.Tree;

import aJan22.ds.TreeNode;

//124
/*

      Things I did well:
      1) identified as a one pass tree traversal problem
      2) Had an intuition about starting a new path
      3) Every new node visited (new root) can potentially form a new path

    Key Learning / revise:
     :  maxPathSum(root) doesn't directly return the answer passing it through the recursion chain.
     The answer is rather computed using a global max variable.

 */

public class BinaryTreeMaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode root) {
        if( root == null ) return  0;

        int leftGain =  Math.max(maxGain( root.left), 0);
        int rightGain =  Math.max( maxGain( root.right), 0) ;

        int newPathGain  =  root.val  +  leftGain + rightGain;
        maxSum = Math.max(maxSum, newPathGain);

        return  root.val + Math.max(leftGain, rightGain);
    }


    public int maxPathSum(TreeNode root) {
        maxGain(root);
       return  maxSum;
    }


    public static void main(String[] args) {
        BinaryTreeMaxPathSum btms = new BinaryTreeMaxPathSum();

        System.out.println(btms.maxPathSum(TreeNode.createTree(new Integer[] {-10,9,20,null,null,15,7})));
    }

}
