class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
            return mergeTwoLists(list2, list1);
        }

        ListNode head = list1;
        ListNode res = head;

        ListNode comp1 = list2;
        ListNode comp2 = list1.next;

        while (comp1 != null && comp2 != null) {
            if (comp1.val > comp2.val) {
                head.next = comp2;
                head = comp2;
                comp2 = comp2.next;
            } else {
                head.next = comp1;
                head = comp1;
                comp1 = comp1.next;
            }
        }
        
        if (comp1 != null) {
            head.next = comp1;
        } else {
            head.next = comp2;
        }

        return res;
    }
}