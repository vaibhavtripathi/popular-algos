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
class ListPartition {
    public ListNode partition(ListNode head, int x) {
        ListNode listHead1 = null;
        ListNode listTail1 = null;
        ListNode listHead2 = null;
        ListNode listTail2 = null;
        while(head != null) {
            if (head.val >= x) {
                if (listHead2 == null) {
                    listHead2 = head;
                    listTail2 = head;
                } else {
                    listTail2.next = head;
                    listTail2 = listTail2.next;
                }
            } else {
                if (listHead1 == null) {
                    listHead1 = head;
                    listTail1 = head;
                } else {
                    listTail1.next = head;
                    listTail1 = listTail1.next;
                }
            }
            head = head.next;
        }
        if (listTail2 != null) listTail2.next = null;
        if (listHead2 != null) listTail1.next = listHead2;
        return listHead1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(2);
        ListPartition l = new ListPartition();
        ListNode res = l.partition(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}