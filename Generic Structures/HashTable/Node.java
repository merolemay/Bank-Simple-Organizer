package HashTable;

public class Node<K, V>  {
	
	private K key;
	private V value;
	Node<K,V> next;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		next=null;
	}
	
	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public int hashCode(int hashTableSize, int i) {
		return (int) (((Integer)(value)+1) % hashTableSize);
	}

	public Node<K, V> getNext() {
		return next;
	}
}