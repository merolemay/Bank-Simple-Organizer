package priorityQueue;

import java.util.Comparator;

import Stack.Stack;

// Inspired in Jatin Sharma 
public class PriorityQueue <E> {
	
	public static final int MAX_SIZE=12;
	
	private int size;
	
	
	private Object k[];
	
	
	public PriorityQueue() {	 
		k = new Object[MAX_SIZE];
	}
	
	
	public PriorityQueue(int maxSize) {	 
		k = new Object[maxSize];
	}
	@SuppressWarnings("unchecked")
	public E parent(int index) {
		
		return (E) k[(index-1)/2];
	}
	
	 private Object left(int i)
	    {
		 Object n =  k[2 * i + 1];
	        return n;
	    }

	    private E right(int i)
	    {
	        return (E) k[2 * i + 2];
	    }

	
	public void add() {}
	
	public void offer(E data) {
		
	}
	
	public E poll() {
		
		return null;
		
	}
	
	public E peek() {
		
		
		return null;
	}
	
	public boolean remove(E obj) {
		
		return false;
	}
	 public void replace (E e1, E e2) {
		 offer (e2);
		 remove(e1);
	 }
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	

}

