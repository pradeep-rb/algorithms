package general;

import datastruct.TreeNode;

import java.util.*;

public class LCAofBT {
    List<TreeNode> pPath = new ArrayList<>();
    List<TreeNode> qPath = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q, new ArrayList<>());


        for (int i = pPath.size() -1; i > 0 ; i--) {
            for (int j = qPath.size() - 1; j > 0; j--) {
                if(pPath.get(i).equals(qPath.get(j))) {
                    return pPath.get(i);
                }

            }
        }

        return root;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if(root == null) return;
        path.add(root);
        if(root.equals(p)) {
            pPath.addAll(path);
            return;
        }
        if(root.equals(q)) {
            qPath.addAll(path);
            return;
        }


        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size() -1);

    }

}
