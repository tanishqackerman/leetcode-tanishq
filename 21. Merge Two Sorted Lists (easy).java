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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }
}