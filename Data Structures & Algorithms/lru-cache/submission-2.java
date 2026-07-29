class LRUCache {

    class Node {
        Node prev; 
        Node next;
        int key; 
        int val; 

        Node(int key, int val){
            this.key = key; 
            this.val = val;
        }
    }

    public Map<Integer, Node> mp;
    public int capacity;
    public Node head;
    public Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        mp = new HashMap<>();

        head = new Node(0, 0); 
        tail = new Node(0, 0);

        head.next = tail; 
        tail.prev = head;
    }

    public void remove(Node node){
        node.prev.next = node.next; 
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        node.prev = tail.prev; 
        node.next = tail; 
        tail.prev.next = node; 
        tail.prev = node;
    }

    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }

        remove(mp.get(key)); 
        insert(mp.get(key)); 
        return mp.get(key).val;
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)){
            mp.get(key).val = value;
            remove(mp.get(key)); 
            insert(mp.get(key)); 
            return;
        }

        if(mp.size() == capacity){
            Node node = head.next;
            remove(node); 
            mp.remove(node.key);
        }

        Node node = new Node(key, value);
        insert(node); 
        mp.put(key, node);
    }
}