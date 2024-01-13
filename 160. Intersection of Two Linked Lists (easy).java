/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        int i = 0, j = 0;
        while (temp1 != null) {
            i++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            j++;
            temp2 = temp2.next;
        }
        int min = Math.min(i, j);
        i -= min;
        j -= min;
        while (i-- > 0) headA = headA.next;
        while (j-- > 0) headB = headB.next;
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}