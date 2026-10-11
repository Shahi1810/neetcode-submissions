//to do this we need to store key value pairs and to do operations in O(1)
//we need to make hashmap to store keys and make values as node pointers
//since we need to determine which one is the least recently used we need to
//keep positing the pointers among themselves hence we will use doubly linked
//lists where the left most is the least recently used. once a new key is being
//stored at a point where the cache is already at its capacity we will evict the
//least recently used one. 


public class Node {
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;
    private int cap;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            this.remove(node);
            this.insert(node);
            return node.val;
        }
        return -1;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    private void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            this.remove(this.cache.get(key));
        }
        this.cache.put(key, new Node(key,value));
        this.insert(this.cache.get(key));

        if(this.cache.size() > this.cap){
            //remove the lru from the list and hashmap
            Node lru = this.left.next;
            this.remove(lru);
            this.cache.remove(lru.key);
        }
    }
}
