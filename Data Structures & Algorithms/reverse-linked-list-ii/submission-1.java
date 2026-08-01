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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        ListNode curr;
        ListNode prev;
        int temp = left - 1;
        prev = dummy;
        while(temp > 0 && prev.next != null){
            prev = prev.next;
            temp--;
        }
        curr = prev.next;
        
        ListNode oldLeft = prev;
        ListNode oldRight = curr;
        int k = right - left + 1;
        while(k > 0){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            k--;
        }
        oldLeft.next = prev;
        oldRight.next = curr;

        return dummy.next;
    }
}