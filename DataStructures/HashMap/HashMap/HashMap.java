public class HashMap<K, V> {
	
	private Node<K, V> [] buckets;
	
	public HashMap(int capacity) {
		@SuppressWarnings({"rawtypes","unchecked"})
		Node<K,V>[] newBuckets = (Node<K,V>[]) new Node[capacity];
		buckets = newBuckets;
	}
	
	public void put(K key, V value) {
		int index = hash(key);
		Node<K, V> head = buckets[index];
		if (head == null) {
			head = new Node<K, V>(key, value);
			buckets[index] = head;
		} else {
			addValue(head, key, value);
		}
	}
	
	private int hash(Object key) {
		return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
	}
	
	private void addValue(Node<K, V> head, K key, V value) {
		if (head.key.equals(key)) {
			head.data = value;
		} else {
			Node<K, V> node = head;
			while (node.next != null && !node.next.key.equals(key)) {
				node = node.next;
			}
			if (node.next == null) {
				Node<K, V> newNode = new Node<K, V>(key, value);
				node.next = newNode;
			} else {
				node.next.data = value;
			}
		}
	}
	
	public V get(K key) {
		int index = hash(key) % buckets.length;
		Node<K, V> head = buckets[index];
		return searchValue(head, key);
	}
	
	private V searchValue(Node<K, V> head, K key) {
		Node<K, V> node = head;
		while (node != null) {
			if (node.key.equals(key)) {
				return node.data;
			}
			node = node.next;
		}
		return null;
	}
	
	class Node<K, V> {
		K key;
		V data;
		Node<K, V> next;
		
		Node(K key, V data) {
			this.key = key;
			this.data = data;
		}
	}
	
	public static void main(String [] args) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>(10);
		int n = 100;
		System.out.println("Testing...");
		System.out.println("putting values...");
		for (int i = 0; i < n; ++i) {
			hashMap.put("key" + i, i);
		}
		System.out.println("getting values...");
		for (int i = 0; i < n; ++i) {
			int v = hashMap.get("key" + i);
			if (v != i) {
				throw new RuntimeException();
			}
		}
		
		System.out.println("updating values...");
		for (int i = 0; i < n; ++i) {
			hashMap.put("key" + i, 2*i);
		}
		System.out.println("checking values...");
		for (int i = 0; i < n; ++i) {
			int v = hashMap.get("key" + i);
			if (v != 2*i) {
				throw new RuntimeException();
			}
		}
		System.out.println("Test finished!");
	}
	
}