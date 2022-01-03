class Node {
    public int key;
    public int val;
    public int freq;
    public long timestamp;
    
    
    public Node(int key, int val, int freq, long timestamp) {
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.timestamp = timestamp;
    }
}

class LFUCache {
    private Map<Integer, Node> map;
    private PriorityQueue<Node> minHeap;
    private long timestamp;
    private int capacity;
    private int size;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        timestamp = 0;
        size = 0;
        this.map = new HashMap<Integer, Node>();
        this.minHeap = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.freq == n2.freq ? (int)(n1.timestamp - n2.timestamp) : n1.freq - n2.freq;
            }
        });
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node res = map.get(key);
        minHeap.remove(res);
        Node newNode = new Node(key, res.val, res.freq+1, ++timestamp);
        minHeap.offer(newNode);
        map.put(key, newNode);
        return res.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if (map.containsKey(key)) {
            Node old = map.get(key);
            Node newNode = new Node(key, value, old.freq+1, ++timestamp);
            minHeap.remove(old);
            minHeap.offer(newNode);
            map.put(key, newNode);

        } else if (size == capacity) {
            Node newNode = new Node(key, value, 1, ++timestamp);
            Node old = minHeap.poll();
            map.remove(old.key);
            
            map.put(key, newNode);
            minHeap.offer(newNode);
        } else {
            Node newNode = new Node(key, value, 1, ++timestamp);
            map.put(key, newNode);
            minHeap.offer(newNode);
            this.size++;
        }
        
    }
    
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */