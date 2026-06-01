class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<ListNode> st = new Stack<>();

        ListNode cur = slow.next;
        slow.next = null;

        while (cur != null) {
            st.push(cur);
            cur = cur.next;
        }

        cur = head;

        while (!st.isEmpty()) {

            ListNode nxt = cur.next;
            ListNode back = st.pop();

            cur.next = back;
            back.next = nxt;

            cur = nxt;

            if (cur == null) {
                break;
            }
        }
    }
}