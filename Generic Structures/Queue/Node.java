package Queue;

public class Node<E> {
	
	private E data = null;
	private Node<E> previous = null;
	private Node <E>  next = null;
	
	
	public Node() {}
	
	public Node(E obj) {
		this.data=obj;
	}

	public Node(E data, Node<E> next, Node<E> previus) {
		super();
		this.data = data;
		this.previous = previus;
		this.next = next;
	}
	
	public E get() {
		return data;
	}
	
	public void set(E obj) {
		data=obj;
	}

	public Node<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E> previus) {
		this.previous = previus;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	
	
	
	
	

}
