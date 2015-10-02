import java.util.Map;
import java.util.HashMap;

public class LRUCache {    

    private int size;
    private Map<Integer, Node> map;    

    private Node lru;
    private Node mru;    

    private class Node {       

        private int key;
        private int value;        

        private Node next;
        private Node prev;        

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }        

        public int getKey() {
            return key;
        }        

        public int getValue() {
            return value;
        }        

        public void setValue(int value) {
            this.value = value;
        }        

        public Node getNext() {
            return next;
        }        

        public Node getPrev() {
            return prev;
        }        

        public void setNext(Node n) {
            next = n;
        }        

        public void setPrev(Node n) {
            prev = n;
        }

    }    

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }        

        size = capacity;
        map = new HashMap<Integer, Node>();
    }    

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        } else {
            setNewLRU(n);
            return n.getValue();
        }
    }    

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.keySet().size() == size) {
                removeMRU();
            }
            node = new Node(key, value);
            map.put(key, node);
        } else {
            node.setValue(value);
        }

        setNewLRU(node);
    }    

    private void removeMRU() {
        map.remove(mru.getKey());
        mru = mru.getPrev();
        if (mru == null) {
            lru = null;
        } else {
            mru.setNext(null);
        }
    }    

    private void setNewLRU(Node node) {
        if (lru == null) {
            lru = node;
            mru = node;
            return;
        }
        if (lru == node) {
            return; // nothing to do
        }        

        Node next = node.getNext();
        Node prev = node.getPrev();
        if (next == null && prev == null) {
            node.setNext(lru);
            lru.setPrev(node);
            lru = node;
        } else if (next == null) {
            mru = mru.getPrev();
            mru.setNext(null);
            node.setPrev(null);
            node.setNext(lru);
            lru.setPrev(node);
            lru = node;
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            lru.setPrev(node);
            node.setNext(lru);
            lru = node;
        }
    }    

}