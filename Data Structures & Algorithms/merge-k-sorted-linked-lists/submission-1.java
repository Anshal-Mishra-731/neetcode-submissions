class Solution {

    public ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1; 

        if(l1.val > l2.val){
            return mergeTwo(l2, l1);
        }

        ListNode head = l1; 
        ListNode res = head;

        ListNode comp1 = l1.next; 
        ListNode comp2 = l2;
        
        while(comp1 != null && comp2 != null){
            if(comp2.val > comp1.val){
                res.next = comp1; 
                comp1 = comp1.next; 
                res = res.next;
            }
            else{
                res.next = comp2;
                comp2 = comp2.next; 
                res = res.next;
            }
        }

        if(comp1 == null){
            res.next = comp2;
        }
        if(comp2 == null){
            res.next = comp1;
        }

        return head;
    }

    public ListNode solve(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }

        int mid = l + (r - l)/2;
        ListNode left = solve(lists, l, mid); 
        ListNode right = solve(lists, mid + 1, r);

        return mergeTwo(left, right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        return solve(lists, 0, lists.length - 1);
    }
}
