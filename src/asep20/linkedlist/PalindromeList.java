package asep20.linkedlist;

import datastruct.ListNode;

public class PalindromeList {

    //https://leetcode.com/problems/palindrome-linked-list/submissions/
    ListNode head;


    public boolean helper(ListNode curr) {
        if(curr != null && head != null) {
            boolean prevResult = helper(curr.next);
            ListNode prevHead = head;
            head = head.next;
            return prevResult && curr.val == prevHead.val;
        }
        return  true;
    }

    public boolean isPalindrome(ListNode head) {
        this.head = head;
        return helper(head);
    }

    public static void main(String[] args) {
        PalindromeList pl = new PalindromeList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1 , null)));


        System.out.println(pl.isPalindrome(head));
    }


}
