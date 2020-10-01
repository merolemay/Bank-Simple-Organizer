package HashTable;

import java.io.Serializable;
import java.util.LinkedList;

public class HashTable<K, V> implements Map<K,V>,Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedList<HashNode<K,V>>[] table = null;
	int arraySize = 0;
	
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		
		this.arraySize = size;
		this.table = new LinkedList[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<HashNode<K,V>>();
		}
	}
	
	
	public int hashFunction(K key) {
		int index;
		index = Math.abs(key.hashCode() % arraySize);
		return index;
	}
	
	
	@Override
	public V put(K key, V value) {
		int index = hashFunction(key);
	
		for (HashNode<K,V> element : table[index]) {
			if (element.getKey().equals(key)) {
				V alt = element.getValue();
				element.setValue(value);
				return alt;
			}
		}
		
		HashNode<K,V> hashNode = new HashNode<K,V>(key, value);
		table[index].add(hashNode);
		return null;
	}

	
	
	@Override
	public V get(K key) {
		int index = hashFunction(key);
	
		for (HashNode<K,V> element : table[index]) {
			if (element.getKey().equals(key)) {
				return element.getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int index = hashFunction(key);

		for (HashNode<K,V> element : table[index]) {
			if (element.getKey().equals(key)) {
				V altvalue = element.getValue();
				table[index].remove(element);
				return altvalue;
			}
		}
		
		return null;
	}
	
	public int getSize() {
		return arraySize;
	}
	
	public LinkedList<HashNode<K,V>>[] getTable(){
		return table;
	}
	

}
