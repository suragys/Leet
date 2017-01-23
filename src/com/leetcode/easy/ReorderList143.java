package com.leetcode.easy;

/**
 * Created by surag on 1/20/17.
 */
public class ReorderList143 {
    private static ListNode p = null;
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        e.next = f;
//        f.next = null;
        ListNode curr = a;
        while(curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
        reorderList(a);
        curr = a;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }

    }

    public static void reorderList(ListNode head) {
//        p = head;
//        recursiveReorder(head);
        ListNode s = head;
        ListNode f = head;
        ListNode ps = null;

        while(f != null && f.next != null) {
            ps = s;
            s = s.next;
            f = f.next.next;
        }

        // reverse the second half of the linked list


        ListNode p = null;
        ListNode n = s.next;
        while(s.next != null){
            s.next = p;
            p = s;
            s = n;
            n = n.next;
        }
        s.next = p;
        ps.next = s;

        // now start reconnecting link to get the desired order

        ListNode t1 = head.next;
        ListNode t2 = s.next;
        while(s.next != null && head != ps){
            head.next = s;
            s.next = t1;
            ps.next = t2;
            head = s.next;
            t1 = t1.next;
            s = t2;
            t2 = t2.next;
        }
        return;
    }

    public static void recursiveReorder(ListNode head){
        if(head == null) return;

        recursiveReorder(head.next);
        if(p.next != null) {
            ListNode temp = p.next;
            p.next = head;
            head.next = temp;
            p = temp;
            if (temp != null) {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
        return;
    }
}
