class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node cur = head;
        HashMap<Node, Node> mp = new HashMap<>(); 

        while(cur != null){
            mp.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head; 
        
        while(cur != null){
            mp.get(cur).next = mp.get(cur.next); 
            mp.get(cur).random = mp.get(cur.random); 
            cur = cur.next;
        }

        return mp.get(head);
    }
}
