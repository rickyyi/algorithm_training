package com.example.newcoder;

import lombok.AllArgsConstructor;

public class ReBuildBiTree {
    public static void main(String[] args) {

        /*ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5, null)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6, null)));
        new ReBuildBiTree().Merge(list1, list2);*/

        //ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode list1 = new ListNode(1, new ListNode(2, null));
        new ReBuildBiTree().removeNthFromEnd(list1, 2);
    }

    @AllArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list2 == null) return list1;
        if (list1 == null) return list2;
        ListNode head = new ListNode(0, null);
        ListNode tmp = head;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return head.next;
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list2 == null) return list1;
        if (list1 == null) return list2;
        ListNode head = new ListNode(0, null);
        ListNode tmp = head;
        ListNode l1 = list1;
        ListNode l2 = list2;
        boolean flag = true;
        while (l1 != null && l2 != null) {
            if (flag) {
                tmp.next = l1;
                l1 = l1.next;
                flag = !flag;
            } else {
                tmp.next = l2;
                l2 = l2.next;
                flag = !flag;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return head.next;
    }

    public void m (ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l2 = slow.next;
        slow.next = null;

        l2 = revise(l2);

        ListNode listNode = Merge2(head, l2);
    }

    public ListNode revise(ListNode node) {
        ListNode pre = null;
        ListNode head = node;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode pHead = head;
        int i = 0;
        while (i < n) {
            pHead = pHead.next;
            i ++;
        }
        ListNode pHead2 = head;

        while (pHead != null) {
            pHead = pHead.next;
            pHead2 = pHead2.next;
        }
        ListNode next1 = pHead2.next;
        ListNode next2 = pHead2.next.next;

        pHead2.next = next2;
        next1.next = null;
        return head;
    }


}
