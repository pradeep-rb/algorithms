package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UBT2 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        return  generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> leftTrees = null;
        List<TreeNode> rightTrees = null;

        List<TreeNode> trees = new ArrayList<>();

        if(start == end) {
            return  Arrays.asList( new TreeNode(start));
        }
        else if( start > end ) {
            return  Collections.emptyList();
        }

        for (int i = start; i <= end; i++) {
            leftTrees = generateTrees(start, i -1);
            rightTrees = generateTrees(i+1,  end);

            if(leftTrees.isEmpty()) {
                for(TreeNode rightRoot: rightTrees) {
                    TreeNode root = new  TreeNode(i);
                    root.left = null;
                    root.right = rightRoot;
                    trees.add(root);
                }
            }
            if(rightTrees.isEmpty()) {
                for(TreeNode leftRoot: leftTrees) {
                    TreeNode root = new  TreeNode(i);
                    root.left = leftRoot;
                    root.right = null;
                    trees.add(root);
                }
            }

            for(TreeNode leftRoot: leftTrees) {
                for(TreeNode rightRoot: rightTrees) {
                    TreeNode root = new  TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    public static void main(String[] args) {
        UBT2 ubt2 = new UBT2();

        System.out.println(ubt2.generateTrees(5));

    }
}
