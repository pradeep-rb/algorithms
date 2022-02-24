package general;

import java.util.HashMap;
import java.util.Map;

public class MaxCostTree {

    Map<String, Node> sumMap = new HashMap<>();
    class Node {
        int cumSum;
        int maxLeaf;

        public Node(int sum, int maxLeaf) {
            this.cumSum = sum;
            this.maxLeaf = maxLeaf;
        }
    }


    public int mctFromLeafValues(int[] arr) {

        return mct(arr, 0, arr.length -1).cumSum;
    }

    public Node mct(int[] arr, int start, int end) {
        String key = start + ":" + end;
        if(sumMap.containsKey(key)){
            if(start != end) System.out.println(key);
            return  sumMap.get(key);
        }

        Node res;
        if(start == end) {
            res = new Node(0, arr[start]);
            sumMap.put(key, res);
        }
        else {
            res = new Node(Integer.MAX_VALUE, 0);
            for (int i = 0; i < end - start; i++) {
               Node leftN =  mct(arr, start, start + i )  ;
               Node rightN =   mct(arr, start + i + 1, end ) ;
               Node temp = new Node ( (leftN.maxLeaf * rightN.maxLeaf) + leftN.cumSum + rightN.cumSum,
                       Math.max(leftN.maxLeaf, rightN.maxLeaf));
               res = temp.cumSum < res.cumSum ? temp : res;
            }

            sumMap.put(key, res);
        }


        return  sumMap.get(key);
    }




    public static void main(String[] args) {
        MaxCostTree mct = new MaxCostTree();

        int ans = mct.mctFromLeafValues(new int[] {6, 2, 4, 3, 6, 4 });
        System.out.println(ans);
    }
}
