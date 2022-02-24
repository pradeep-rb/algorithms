package asep20.tree;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    Map<Integer, List<Integer>> lvlMap = new HashMap<>();

    private void traverse(TreeNode root, int level) {
        if(root == null) return;
        lvlMap.computeIfAbsent(level, k -> new ArrayList<>()).add(root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);
        return lvlMap.values().stream().collect(Collectors.toList());
    }


    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
                TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(12, null,
                new TreeNode(16, new TreeNode(14, new TreeNode(8), new TreeNode(15)), null )));

        lot.levelOrder(root);

    }

}
