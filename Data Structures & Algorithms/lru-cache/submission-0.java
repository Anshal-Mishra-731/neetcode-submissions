class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> lru;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {

        if (!lru.containsKey(key)) {
            return -1;
        }

        Node node = lru.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (lru.containsKey(key)) {

            Node node = lru.get(key);

            node.val = value;

            remove(node);
            insert(node);

            return;
        }

        if (lru.size() == capacity) {

            Node lruNode = head.next;

            remove(lruNode);
            lru.remove(lruNode.key);
        }

        Node node = new Node(key, value);

        insert(node);
        lru.put(key, node);
    }
}