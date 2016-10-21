package com.leetcode.easy;

/**
 * This code cannot be executed unless you creat a ListNode class. 
 *Definition for singly-linked list.

 */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if(head !=null) {
            ListNode pre = null;
            ListNode curr = head;
            while(curr != null){
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }
            return pre;
        }
        return head;
    }

     public static class ListNode {
    int val;
      ListNode next;
      ListNode(int x) { val = x; } }
}
