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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode temp = head;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        temp = head;
        c -= n;
        if (c == 0) return head.next;
        while (c-- > 1) {
            temp = temp.next;
        }
        if (temp.next == null) return null;
        temp.next = temp.next.next;
        return head;
    }
}