package asep20.tree;

import datastruct.TreeNode;

import java.util.*;

//https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {
    List<TreeNode> inOrderList = new ArrayList<>();

    public void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        inOrderList.add(root);
        traverse(root.right);
    }

    public void recoverTree(TreeNode root) {
        traverse(root);

        int errIndex = -1;
        for (int i = 0; i < inOrderList.size() - 1; i++) {
            if( inOrderList.get(i).val >  inOrderList.get(i+1).val ) {
                errIndex = i;
                break;
            }
        }

        int smallIdx = errIndex + 1;
        for (int i = errIndex + 1; i < inOrderList.size() ; i++) {
            if(  inOrderList.get(i).val < inOrderList.get(smallIdx).val ) {
                smallIdx = i;
            }
        }
       TreeNode node1 =  inOrderList.get(errIndex);
       TreeNode node2 =  inOrderList.get(smallIdx);
       int temp = node1.val;
       node1.val = node2.val;
       node2.val = temp;
    }


    public static void main(String[] args) {

        RecoverBST rBst = new RecoverBST();
//        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(12, null,
//                new TreeNode(16, new TreeNode(14, new TreeNode(8), new TreeNode(15)), null )));

        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);

        rBst.recoverTree(root);
    }
}
