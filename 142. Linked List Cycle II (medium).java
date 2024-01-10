/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        int x = 0;
        ListNode s = head, f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                x = 1;
                break;
            }
        }
        if (x == 1) {
            ListNode meet = head;
            while (s != meet) {
                s = s.next;
                meet = meet.next;
            }
            return meet;
        } else return null;
    }
}