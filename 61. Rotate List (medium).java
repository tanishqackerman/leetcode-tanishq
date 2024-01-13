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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode l = head, temp = head;
        int n = 0;
        while (l.next != null) {
            l = l.next;
            n++;
        }
        n++;
        l.next = head;
        k %= n;
        int i = n - k;
        i--;
        while (i-- > 0) temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;
    }
}