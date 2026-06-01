class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            len++;
        }

        if (n == len) {
            return head.next;
        }

        int target = len - n;

        cur = head;

        for (int i = 1; i < target; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return head;
    }
}