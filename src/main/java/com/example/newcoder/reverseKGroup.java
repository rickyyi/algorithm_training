package com.example.newcoder;

import lombok.AllArgsConstructor;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e
 */
public class reverseKGroup {

    @AllArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseKGroup (ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0 || k == 1) {
            return head;
        }
        // write code here
        Stack<ListNode> stack = new Stack<>();
        ListNode h = head;
        ListNode newHead = new ListNode(0, null);
        ListNode newHeadTemp = newHead;
        int i = 0;
        while (h != null || stack.size() != 0) {
            if (i < k) {
                stack.push(h);
                h = h.next;
                i++;
            }
            if (i == k) {
                while (stack.size() != 0) {
                    ListNode pop = stack.pop();
                    pop.next = null;
                    newHeadTemp.next = pop;
                    newHeadTemp = newHeadTemp.next;
                }
                i=0;
            }
            if (h == null && i < k) {
                break;
            }
        }

        ListNode rest = null;
        while (!stack.empty()) {
            rest = stack.pop();
        }
        newHeadTemp.next = rest;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode reverse = new reverseKGroup().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, null)))))))), 3);

        System.out.println(reverse);
    }
}
