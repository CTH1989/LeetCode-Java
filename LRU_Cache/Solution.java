import java.util.Hashtable;
public class LRUCache {

    private class LinkNode {
        public int key;
        public int value;
        public LinkNode pre;
        public LinkNode next;
        public LinkNode(int _key, int _value, LinkNode _pre, LinkNode _next) {
            this.key = _key;
            this.value = _value;
            this.pre = _pre;
            this. next = _next;
        }
    }
    private int cacheCapacity;
    private int cacheCount;
    private Hashtable<Integer, LinkNode> index;
    private LinkNode head, tail;
    
    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.cacheCount = 0;
        this.index = new Hashtable<Integer, LinkNode>();
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if (index.containsKey(key)) {
            int value = index.get(key).value;
            set(key, value);
            return value;
        } else 
            return -1;
    }
    
    public void set(int key, int value) {
        if (index.containsKey(key)) {
            LinkNode np = index.get(key);
            tail.next = new LinkNode(key, value, tail ,null);
            tail = tail.next;
            index.put(key, tail);
            if (np == head) {
                head = head.next;
                head.pre = null;
            } else {
                np.pre.next = np.next;
                np.next.pre = np.pre;
            }
        } else {
            if (tail == null) {
                tail = new LinkNode(key, value, null, null);
                head = tail;
            } else {
                tail.next = new LinkNode(key, value, tail ,null);
                tail = tail.next;
            }
            index.put(key, tail);
            if (cacheCount == cacheCapacity) {
                index.remove(head.key);
                head = head.next;
                head.pre = null;
            } else {
                cacheCount ++;
            }
        }
    }
}
