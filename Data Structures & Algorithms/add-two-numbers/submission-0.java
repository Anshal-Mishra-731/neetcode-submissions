class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        ListNode head1 = l1; 
        ListNode head2 = l2;
        int carry = 0;

        while(head1 != null || head2 != null){

            int a = (head1 == null) ? 0 : head1.val;
            int b = (head2 == null) ? 0 : head2.val;

            int sum = a + b + carry;

            carry = sum / 10;
            sum = sum % 10;

            res.next = new ListNode(sum);
            res = res.next;

            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }

        if(carry > 0){
            res.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
