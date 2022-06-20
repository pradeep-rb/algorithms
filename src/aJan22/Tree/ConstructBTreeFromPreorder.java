package aJan22.Tree;

import java.util.HashMap;
import java.util.Map;

//105
// revise:  involved using a global variable that the recursion stack had access to
public class ConstructBTreeFromPreorder {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    Map<Integer, Integer> inorderMap = new HashMap();
    int root = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder.length - 1  );
    }


    public TreeNode buildTree(int[] preorder, int left, int right) {

        TreeNode leftNode, rightNode, rootNode;

        if (left > right) return  null;

        int rootVal = preorder[root++];

        System.out.println("root : " + root  + " left : " + left + " right : " + right );


        leftNode = buildTree(preorder, left, inorderMap.get(rootVal) - 1);
        rightNode = buildTree(preorder, inorderMap.get(rootVal) + 1, right );
        rootNode = new  TreeNode( rootVal, leftNode, rightNode);


        return rootNode;

    }
}
