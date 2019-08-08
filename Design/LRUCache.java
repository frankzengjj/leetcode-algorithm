class LRUCache {
    class Node {
        public Node next;
        public Node prev;
        public int val;
        public int key;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            update(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            Node newNode = new Node(key, value);
            add(newNode);
            cache.put(key, newNode);
        } else {
            Node node = cache.get(key);
            node.val = value;
            update(node);
        }
        if (cache.size() > capacity) {
            Node toDel = tail.prev;
            remove(toDel);
            cache.remove(toDel.key);
        }
    }
    
    private void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node) {
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
    
    private void update(Node node) {
        remove(node);
        add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */