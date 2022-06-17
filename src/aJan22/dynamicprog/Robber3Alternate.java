package aJan22.dynamicprog;
import aJan22.ds.TreeNode;

import java.util.HashMap;

//337
public class Robber3Alternate {

    public int rob(TreeNode root) {
        if(root == null) return 0;
        return  Math.max(   traverse(root, true), traverse(root, false) );
    }

    private  int traverse(TreeNode root, boolean rob_parent) {

        if(root == null)   return 0;

        if(rob_parent) {
            return  traverse(root.left, false) +   traverse(root.right, false);
        }
        else {
            return Math.max( root.val +  traverse(root.left, true) + traverse(root.right,  true) ,
                      traverse(root.left, false) + traverse(root.right,  false) );
        }
    }

    /*
        Memoized solution
     */

    HashMap<TreeNode, Integer> robResult = new HashMap<>();
    HashMap<TreeNode, Integer> notRobResult = new HashMap<>();


    private  int traverse2(TreeNode root, boolean rob_parent) {

        if(root == null)   return 0;

        if(rob_parent) {
            if (!robResult.containsKey(root))  robResult.put( root,   traverse(root.left, false) +   traverse(root.right, false));
             return robResult.get(root);

        }
        else {
            if(!notRobResult.containsKey(root))
                notRobResult.put(root, Math.max( root.val +  traverse(root.left, true) + traverse(root.right,  true) ,
                    traverse(root.left, false) + traverse(root.right,  false) ));
            return notRobResult.get(root);
        }
    }
    

    public static void main(String[] args) {

        Robber3Alternate r3 = new Robber3Alternate();
        //TreeNode tn = TreeNode.createTree(new Integer[]{3,4,5,1,3,null,1});
        TreeNode tn = TreeNode.createTree(new Integer[]{3,2,3,null,3,null,1});
        //TreeNode tn = TreeNode.createTree(new Integer[]{3,2,3});
        System.out.println(r3.rob(tn));

        /*TreeNode tn1 = TreeNode.createTree(new Integer[]{3,2,20,1,5,null,4});
        System.out.println(r3.rob(tn1));*/

    }

}
