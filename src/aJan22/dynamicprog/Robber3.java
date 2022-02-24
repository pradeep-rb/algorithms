package aJan22.dynamicprog;

import aJan22.ds.TreeNode;

//337
public class Robber3 {


    public int rob(TreeNode root) {
       return robHelper(root)[1];
    }

    public int[] robHelper(TreeNode root) {
        if(root == null) return  new int[]{0, 0};

        int[] dpL = robHelper(root.left);
        int[] dpR =  robHelper(root.right);

        //if me and my grand childen add up to less than my children then rob my children.
        if(  root.val + dpL[0] + dpR[0] <   dpL[1] + dpR[1])  return new int[] {dpL[1] + dpR[1],  dpL[1] + dpR[1] };
        //if me and my grand children add up to more than my children then rob me and my grand children.
        return  new int[] {dpL[1] + dpR[1], root.val  + dpL[0] + dpR[0] };

    }




    public static void main(String[] args) {

        Robber3 r3 = new Robber3();
        TreeNode tn = TreeNode.createTree(new Integer[]{3,4,5,1,3,null,1});
        TreeNode tn1 = TreeNode.createTree(new Integer[]{3,2,20,1,5,null,4});
        System.out.println(r3.rob(tn));
        System.out.println(r3.rob(tn1));

    }
}
