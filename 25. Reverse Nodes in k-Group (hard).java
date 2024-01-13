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

    public ListNode reverse(ListNode head, int i, int k) {
        ListNode temp = head, par = head;
        int f = 0, ti = i;
        while (i-- > 0) {
            temp = temp.next;
            if (f == 1) par = par.next;
            f = 1;
        }
        ListNode prev = null, curr = temp, next = temp;
        while (k-- > 0) {
            curr = next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
        }
        temp.next = next;
        if (ti != 0) par.next = curr;
        else return prev;
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int i = n / k;
        while ((i - 1) * k >= 0) {
            head = reverse(head, (i - 1) * k, k);
            i--;
        }
        return head;
    }
}