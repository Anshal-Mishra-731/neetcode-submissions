class Solution {

    private ListNode merge2lists(ListNode l1, ListNode l2){
        if(l1 == null) return l2; 
        if (l2 == null) return l1;

        if(l1.val > l2.val){
            return merge2lists(l2, l1);
        }

        ListNode head = l1; 
        ListNode res = head; 

        ListNode comp1 = l1.next;
        ListNode comp2 = l2;

        while(comp1 != null && comp2 != null){
            if(comp1.val > comp2.val){
                head.next = comp2;
                head = head.next; 
                comp2 = comp2.next;
            }
            else{
                head.next = comp1; 
                head = head.next;
                comp1 = comp1.next;
            }
        }
        if(comp1 == null){
            head.next = comp2; 
        }
        else{
            head.next = comp1;
        }

        return res;
    }

    private ListNode solve(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l]; 
        }

        int mid = (l + r)/2 ; 

        ListNode left = solve(lists, l, mid); 
        ListNode right = solve(lists, mid + 1, r);

        return merge2lists(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        return solve(lists, 0, lists.length - 1);
    }
}
