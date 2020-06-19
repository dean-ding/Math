package com.tvt.math.six;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二维数组中的查找
 * 需要从左下角或者右上角查找
 * 时间复杂度 O(M + N)，空间复杂度 O(1)
 */
class MathSix {

    MathSix() {
    }

    public static class ListNode {
        ListNode(int val) {
            this.val = val;
        }

        int val;
        ListNode next;
    }

    // 递归
    ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    // 头插法构建逆序链表
    ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    // Stack先进后出的原理
    public ArrayList<Integer> printListFromTailToHeadUseStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

}
