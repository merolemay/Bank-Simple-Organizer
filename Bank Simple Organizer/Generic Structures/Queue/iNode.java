package Queue;

public class iNode<E> {
	
	private E data = null;
	private iNode<E> previous = null;
	private iNode <E>  next = null;
	
	
	public iNode() {}
	
	public iNode(E obj) {
		this.data=obj;
	}

	public iNode(E data, iNode<E> next, iNode<E> previus) {
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

	public iNode<E> getPrevious() {
		return previous;
	}

	public void setPrevious(iNode<E> previus) {
		this.previous = previus;
	}

	public iNode<E> getNext() {
		return next;
	}

	public void setNext(iNode<E> next) {
		this.next = next;
	}
	
	
	
	
	
	

}
