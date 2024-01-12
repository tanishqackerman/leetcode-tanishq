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
    public ListNode deleteMiddle(ListNode head) {
        ListNode s = head, f = head;
        int k = 0;
        while (f != null && f.next != null) {
            if (k == 1) s = s.next;
            k = 1;
            f = f.next.next;
        }
        if (s.next == null) return null;
        s.next = s.next.next;
        return head;
    }
}