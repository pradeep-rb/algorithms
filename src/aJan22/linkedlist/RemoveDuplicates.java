package aJan22.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
      }

    public ListNode deleteDuplicatesUnsorted(ListNode head) {

        Map<Integer, Integer> freqCount = new HashMap<>();

        ListNode curr = head;

        while ( curr != null) {
            freqCount.put(curr.val, freqCount.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        curr = new ListNode();
        curr.next = head;
        ListNode topPtr = curr;

        while (curr.next != null) {
            if(freqCount.getOrDefault(curr.next.val, 0 ) > 1 ) {
                curr.next = curr.next.next;
            }
            else  curr = curr.next;
        }

          return topPtr.next;
    }

}
