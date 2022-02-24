package general;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistanceKBTV2 {
    List<Integer> kAway  = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        if(root == null) return Collections.emptyList();
        dfs(root, target, K);
        findKAwayDecendants(target, K);

        return kAway;
    }

    void findKAwayDecendants(TreeNode node, int K) {
        if(node == null) return;
        if(K == 0)  {
            kAway.add(node.val);
            return;
        }
        findKAwayDecendants(node.left, K-1);
        findKAwayDecendants(node.right, K-1);
    }


    public int dfs(TreeNode root, TreeNode target, int K) {

        if(root == null) return  -1;
        if(root.equals(target)) return 1;

        int l = dfs(root.left, target,  K);
        int r  = dfs(root.right, target, K);

        if(l == K || r == K) kAway.add(root.val);
        else if(l > 0) {
            findKAwayDecendants(root.right, K-l-1) ;
            return l+1;
        }
        else if(r > 0) {
            findKAwayDecendants(root.left, K-r-1) ;
            return r+1;
        }

        return  -1;
    }
}


