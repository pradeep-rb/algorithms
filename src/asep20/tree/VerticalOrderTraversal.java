package asep20.tree;

import datastruct.Node;
import datastruct.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    class NodePos implements  Comparable {
        int val;
        int level;

        public int getVal() {
            return  val;
        }

        NodePos(int x, int y) {
            val = x;
            level = y;
        }

        @Override
        public int compareTo(Object o) {
            NodePos toCompare = (NodePos) o;
            if(level == toCompare.level) {
                return val > toCompare.val ? 1 : -1;
            }

            return  level > toCompare.level  ?  1 : -1;
        }
    }

    Map<Integer,  TreeSet<NodePos> > verticalMap = new TreeMap<>();

    public void traverse(TreeNode root, int dir, int level) {
        if(root == null) return;
        verticalMap.computeIfAbsent(dir, k-> new TreeSet<>()).add(new NodePos(root.val, level));
        traverse(root.left, dir - 1, level+1);
        traverse(root.right, dir  + 1, level+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null)  return new ArrayList<>();
        traverse(root, 0, 0);
        return verticalMap.values()
                .stream()
                .map( n -> n.stream()
                        .map(e -> e.getVal())
                        .collect(Collectors.toList()) )
                .collect(Collectors.toList());
    }



    public static void main(String[] args) {
        VerticalOrderTraversal vt = new VerticalOrderTraversal();

        TreeNode root = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,  new TreeNode(15, null, null), new TreeNode(7, null, null)));

        vt.verticalTraversal(root);

    }

}
