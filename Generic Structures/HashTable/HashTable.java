package HashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K,V>  {
	
	LinkedList<Node<K,V>>[] table = null;
	private static int length;
	int arraySize = 0;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		
		this.arraySize = size;
		this.table = new LinkedList[size];
		length = 0;
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<Node<K,V>>();
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
	
		for (Node<K,V> element : table[index]) {
			if (element.getKey().equals(key)) {
				V alt = element.getValue();
				element.setValue(value);
				return alt;
			}
		}
		length = length + 1;
		Node<K,V> hashNode = new Node<K,V>(key, value);
		table[index].add(hashNode);
		return null;
	}

	
	
	@Override
	public V get(K key) {
		int index = hashFunction(key);
	
		for (Node<K,V> element : table[index]) {
			if (element.getKey().equals(key)) {
				return element.getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int index = hashFunction(key);

		for (Node<K,V> element : table[index]) {
			if (element.getKey().equals(key)) {
				V altvalue = element.getValue();
				table[index].remove(element);
				length = length - 1;
				return altvalue;
			}
		}
		
		return null;
	}
	
	public int getSize() {
		return arraySize;
	}
	
	public int numElements() {
		return length;
	}
	public LinkedList<Node<K,V>>[] getTable(){
		return table;
	}
	
	public ArrayList<V> toArrayList(){
		ArrayList<V> array = new ArrayList<V>(arraySize);

		for (int i = 0; i < table.length; i++) {
			
			   @SuppressWarnings({ "unchecked", "rawtypes" })
			List<V> aList = new ArrayList(table[i]);
			   for (int j = 0; j < aList.size(); j++) {
				  
				   array.add(aList.get(j));
			}
			   
		}
		return array;
	}
	
	public boolean isEmpty() {
		return length==0;
		
	}
}

