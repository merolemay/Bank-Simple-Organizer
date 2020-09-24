package linkedList;

public class Node<E> {

	private E data = null;
	private Node<E> next = null;
	
	public Node(E obj, Node<E> next){
		
		this.data = obj;
		this.next = next;
	}
	
	public Node(E obj){
		
		this.data = obj;
		this.next = null;
		
	}

	public void set(E object){
		
		this.data = object;
	}
	
	public void setNext(Node<E> node){
		
		this.next = node;
		
	}

	public E get(){
		
		return this.data;
	}
	
	public Node<E> nextNode(){
		
		return next;
	}

}
