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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1, temp2 = l2;
        int carry = 0, i = 0, j = 0;
        while (temp != null && temp2 != null) {
            int sum = temp.val + temp2.val + carry;
            temp.val = sum % 10;
            temp2.val = sum % 10;
            carry = sum / 10;
            temp = temp.next;
            temp2 = temp2.next;
            i++;
            j++;
        }
        int carry2 = carry;
        while (temp != null) {
            int sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum / 10;
            temp = temp.next;
            i++;
        }
        while (temp2 != null) {
            int sum = temp2.val + carry2;
            temp2.val = sum % 10;
            carry2 = sum / 10;
            temp2 = temp2.next;
            j++;
        }
        if (carry == 1) {
            temp = l1;
            while (temp.next != null) temp = temp.next;
            ListNode node = new ListNode(1);
            temp.next = node;
        }
        if (carry2 == 1) {
            temp2 = l2;
            while (temp2.next != null) temp2 = temp2.next;
            ListNode node = new ListNode(1);
            temp2.next = node;
        }
        if (i >= j) return l1;
        return l2;
    }
}