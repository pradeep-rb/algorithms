package aJan22.dynamicprog;

import aJan22.ds.TreeNode;

//337
/*
    this is a bottom up approach
 */
public class Robber3 {


    public int rob(TreeNode root) {
        int[] toRobOrNot =  traverse(root);
       return  Math.max( toRobOrNot[0], toRobOrNot[1] );
    }

    public int[] traverse(TreeNode root) {
        if(root == null) return  new int[]{0, 0};

        int[] robOrNotL = traverse(root.left);
        int[] robOrNotR =  traverse(root.right);

        //rob root
        int rob = root.val + robOrNotL[1]  + robOrNotR[1];
        //not rob root : rob children or not rob children
        int notRob =  Math.max(robOrNotL[0],  robOrNotL[1]) + Math.max(robOrNotR[0],  robOrNotR[1]);

        return new int[]{rob, notRob};
    }




    public static void main(String[] args) {

        Robber3 r3 = new Robber3();
        TreeNode tn = TreeNode.createTree(new Integer[]{3,4,5,1,3,null,1});
        TreeNode tn1 = TreeNode.createTree(new Integer[]{3,2,20,1,5,null,4});
        System.out.println(r3.rob(tn));
        System.out.println(r3.rob(tn1));

    }
}
