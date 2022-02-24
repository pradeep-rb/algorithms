package general;

import datastruct.TreeNode;

import java.util.*;

public class DistanceKBT {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        if(root == null) return Collections.emptyList();
        List<TreeNode> ancestors = findAncestors(root, target,  new ArrayList());
        List<Integer> kAway  =  findKAwayDecendants(target, K);
        if(ancestors == null || ancestors.isEmpty()) return kAway;

        Collections.reverse(ancestors);
        //for every anscestor, find k-i-1 away descendants.
        // if ancestor happens to be k distance away, record it
        int i = 1;
        TreeNode prev = target;
        for (TreeNode ancestor: ancestors) {
            if(i == K)  kAway.add(ancestor.val);
            else if(i < K ) {
                if(prev.equals(ancestor.left))  kAway.addAll(findKAwayDecendants(ancestor.right, K-i-1));
                else  kAway.addAll(findKAwayDecendants(ancestor.left, K -i -1));
            }
            prev = ancestor;
            i++;
        }
        return kAway;
    }

    List<Integer> findKAwayDecendants(TreeNode node, int K) {
        if(node == null) return new ArrayList<>();
        List<Integer> decendents = new ArrayList<>();
        if(K == 0)  return  new ArrayList(Arrays.asList(node.val));
        if(node.left != null)  decendents.addAll(findKAwayDecendants(node.left, K-1));
        if(node.right != null) decendents.addAll(findKAwayDecendants(node.right, K-1));
        return  decendents;

    }

    List<TreeNode> findAncestors(TreeNode root, TreeNode target, List<TreeNode> anscestors) {
        List<TreeNode> ans = new ArrayList();

        if(root.equals(target)) return  new ArrayList(anscestors);
        List<TreeNode> temp = new ArrayList(anscestors);
        temp.add(root);

        if(root.left != null) ans.addAll(findAncestors(root.left, target, new ArrayList(temp)));
        if(root.right != null) ans.addAll(findAncestors(root.right, target, new ArrayList(temp)));

        return ans;
    }
}


