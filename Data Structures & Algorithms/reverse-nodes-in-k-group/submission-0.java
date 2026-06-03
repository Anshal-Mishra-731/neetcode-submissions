class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);

        int len = 0;
        ListNode idx = head;
        while (idx != null) {
            len++;
            idx = idx.next;
        }

        int elen = (len/k)*k; 

        ListNode prevTail = null;

        while (elen > 0) {
            ListNode tail = head;

            ListNode prev = null;
            ListNode curr = head;
            for (int i = 0; i < k; i++) {
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            
            if (prevTail == null) {
                dummy.next = prev;
            } else {
                prevTail.next = prev;
            }
            prevTail = tail;

            head = curr;
            elen -= k;
        }
        prevTail.next = head;

        return dummy.next;
    }
}
