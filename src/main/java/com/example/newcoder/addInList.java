package com.example.newcoder;

import lombok.AllArgsConstructor;

/**
 * NC40 两个链表生成相加链表
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b
 */
public class addInList {

    @AllArgsConstructor
      public static class ListNode {
        int val;
        ListNode next;
      }

    public ListNode addInList (ListNode head1, ListNode head2) {


        return null;
    }

    public ListNode reverse(ListNode node) {
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

    public static void main(String[] args) {
        ListNode reverse = new addInList().reverse(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));

        System.out.println(reverse);
    }
}
