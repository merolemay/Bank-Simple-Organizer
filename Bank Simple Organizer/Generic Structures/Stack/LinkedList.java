package Stack;

import java.util.NoSuchElementException;

public class LinkedList<E> {
	
	private Node<E> top=null;
	
	public LinkedList() {}
	
	//Stars the list with one object
	public LinkedList(E obj) {
		top = new Node<E>(obj,null);
	}
	
	
	
	//Adds An element to the top of the stack and pushes every other element down there
	public void push(E obj) {
		top = new Node<E>(obj,top);
	}
	
	
	//Return but does not removes the top element
	public E peek() throws NoSuchElementException {
		
		if(top==null) {
			throw new NoSuchElementException();
		}
		
		return top.get();
	}
	
	// Returns and removes the top element
	public E pop() throws NoSuchElementException {
		
		if(top==null) {
			throw new NoSuchElementException();
		}
		
		E obj = top.get();
		top = top.nextNode();
		
		return obj;
	}
	
	//Checks to see if the list is empty 
		public boolean isEmpty(){
			
			if(top == null){
				
				return true;
			} else {
				
				return false;
			}
		}
		
		
		//Adds and element to the end of the list
		public void add(E obj) {
			
			Node<E> thing = this.top;
			
			while(thing.nextNode()!= null) {
				thing = thing.nextNode();
			}
			
			thing.setNext(new Node<E>(obj));
			
		}
		
		//returns the n size of the linked list.
		public int size() {
			 
			int count=0;
			Node<E> obj = this.top;
			
			while(obj != null) {
				count= count + 1;
				obj = obj.nextNode();
			}
			
			return count;
		}
		
		//Clears the list by making the top null.
		public void clear() {
			top = null;
		}

}
