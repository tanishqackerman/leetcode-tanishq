/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode merge(ListNode lh, ListNode rh) {
        final ListNode d = new ListNode(-1);
        ListNode current = d;
        while (lh != null && rh != null) {
            if (lh.val <= rh.val) {
                current.next = lh;
                lh = lh.next;
            } else {
                current.next = rh;
                rh = rh.next;
            }
            current = current.next;
        }
        if (lh != null) {
            current.next = lh;
        }
        if (rh != null) {
            current.next = rh;
        }
        return d.next;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head, s = head, f = head;
        while (f != null && f.next != null) {
            temp = s;
            s = s.next;
            f = f.next.next;
        }
        temp.next = null;
        final ListNode lh = mergeSort(head);
        final ListNode rh = mergeSort(s);
        return merge(lh, rh);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}