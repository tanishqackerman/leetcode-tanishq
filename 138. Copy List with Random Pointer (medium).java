class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head;
        while (temp != null) {
            Node n = new Node(temp.val);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        Node rep = head.next;
        temp = head;
        Node t = temp.next;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            if (t.next != null) t.next = t.next.next;
            t = t.next;
            temp = temp.next;
        }
        return rep;
    }
}