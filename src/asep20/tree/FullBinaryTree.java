package asep20.tree;

import apple.laf.JRSUIUtils;
import datastruct.TreeNode;

import java.util.*;

public class FullBinaryTree {



    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();

        if(N%2 ==0 ) return Collections.EMPTY_LIST;
        if(N == 1 ) return Arrays.asList(new TreeNode(0));
        if(memo.containsKey(N)) return memo.get(N);

        for (int i = 1; i < N; i+=2) {
            for(TreeNode leftNode: allPossibleFBT(i)) {
                for(TreeNode rightNode: allPossibleFBT(N-i-1)) {
                    result.add(new TreeNode(0, leftNode, rightNode));
                }
            }
        }
        memo.put(N, result);
        return result;
    }


    public static void main(String[] args) {
        FullBinaryTree fbt  = new FullBinaryTree();
        fbt.allPossibleFBT(7);


    }




}
