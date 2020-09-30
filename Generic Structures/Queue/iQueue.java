package Queue;

import java.util.NoSuchElementException;

public class iQueue<E> {
	
	private iNode<E> head = null;
	private iNode<E> tail = null;
	private int queueSize=0;
	
	public iQueue() {}
	
	//Stars the queue with one element
	public iQueue(E obj) {
		head = new iNode<E>(obj);
		queueSize =1;
	}
	
	

	public iQueue(E head, E tail){
		
		this.head = new iNode<E>(head);
		this.tail = new iNode<E>(tail);
		this.head.setPrevious(this.tail);
		this.tail.setNext(this.head);
		
		queueSize = 2;
	}
	
	public void enqueue(E obj){
		
		if (queueSize == 0){
			
			head = new iNode<E>(obj);
			
		}
		else if (queueSize == 1){
			
			tail = new iNode<E>(obj, head, null);
			
		} 
		else {
			
			tail = new iNode<E>(obj, tail, null);
		}
		
		queueSize += 1;
	}
	
	public E dequeue() throws NoSuchElementException{
		
		if (queueSize == 0){
	
			throw new NoSuchElementException();
		}
		else if (queueSize == 1){
			
			E swap = head.get();
			head = null;
			queueSize -= 1;
			return swap;
		} else {
			
			E swap = head.get();
			head = head.getPrevious();
			head.setNext(null);
			queueSize -= 1;
			return swap;
		}
	}
	
	public int size(){
		
		return queueSize;
	}
	
}
