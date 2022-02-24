package asep20.tree;

import datastruct.TreeNode;
//https://leetcode.com/problems/diameter-of-binary-tree/solution/
public class DiameterBT {

    int max = 0;

    public int getDiameter(TreeNode root) {
        int lCnt=0;
        int rCnt = 0;
        if(root.left != null) {
            lCnt = getDiameter(root.left);
        }
        if(root.right != null) {
            rCnt = getDiameter(root.right);
        }
        if(root.left ==null && root.right == null) {
            return 1;
        }

        if(max < lCnt + rCnt ) {
            max = lCnt + rCnt ;
        }


        return lCnt > rCnt ? lCnt+1 : rCnt+1 ;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if(root != null) {
            getDiameter(root);
        }


        return max;
    }


    public static void main(String[] args) {

    }
}
