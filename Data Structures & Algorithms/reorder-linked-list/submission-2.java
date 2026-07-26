class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return; 
        }

        ListNode slow= head; 
        ListNode fast = head; 

        while(fast.next != null && fast.next.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }

        ListNode curr = slow.next; 
        ListNode nhead = curr;
        slow.next = null; 

        ListNode prev = null; 
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }

        while(prev != null){
            ListNode nxt = head.next; 
            ListNode nxtprev = prev.next;
            head.next = prev;
            prev.next = nxt;
            head = nxt;
            prev = nxtprev;
        }
    }
}