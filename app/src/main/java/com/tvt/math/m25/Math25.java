package com.tvt.math.m25;

/**
 * 合并两个排序的链表
 */
public class Math25 {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    //递归
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.value <= list2.value) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        }
        else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }

    // 迭代
    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}
