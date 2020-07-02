package com.tvt.math.m18;

/**
 * 链表中删除节点
 */
public class Math18 {

    public static class ListNode {
        private int val;
        public ListNode next;
    }

    //在 O(1) 时间内删除链表节点
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return null;
        }
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        }
        else {
            if (head == tobeDelete)
            // 只有一个节点
            {
                head = null;
            }
            else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }

    // 删除链表中重复的结点
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        }
        else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

}
