package Stack;

import java.util.NoSuchElementException;

public interface iStack<E> {
	
	void push(E obj);
	
	public E peek();
	
	public int size();
	
	public boolean isEmpty();

	public E pop() throws NoSuchElementException;
	
}
