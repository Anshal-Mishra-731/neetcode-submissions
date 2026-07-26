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

        ListNode nhead = slow.next; 
        slow.next = null; 

        Stack<ListNode> st = new Stack<>(); 
        while(nhead != null){
            st.add(nhead); 
            nhead = nhead.next;
        }

        while(!st.isEmpty()){
            ListNode nxt = head.next;
            ListNode add = st.pop(); 

            head.next = add; 
            add.next = nxt;
            head = nxt;
        }
    }
}