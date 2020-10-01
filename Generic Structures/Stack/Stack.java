package Stack;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class Stack<E> implements iStack<E>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<E> stack = null;
	
	//Empty stack
	public Stack() {
		
	stack = new LinkedList<E>();
	}
	
	//Primes the stack with one object at the top
	public Stack(E obj){	
		
	stack = new LinkedList<E>(obj);
	}
		
	//Add an element to the top of the stack
	@Override
	public void push(E obj){
		
	stack.push(obj);	
	}
	
	/* Returns the top element of the stack off and delete it
	 * and if there are no elements then it throws an exception
	 */
	@Override
	public E pop() throws NoSuchElementException{
		if (stack.size() == 0){
			
			throw new NoSuchElementException();
		}
		
		return stack.pop();
	}
	
	/* Returns the top element of the stack off and
	 * and if there are no elements then it throws an exception
	 */
	@Override
	public E peek() throws NoSuchElementException{
		
		if (stack.size() == 0){
			
			throw new NoSuchElementException();
		}
		
		return stack.peek();
	}
	
	//Checks to see if the stack is empty
	@Override
	public boolean isEmpty(){
		
		return stack.isEmpty();
	}
	
	//Returns the size of the stack
	@Override
	public int size(){
		
		return stack.size();
	}
}
