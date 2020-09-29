package priorityQueue;

public class Node<E> {
	
	private final E obj;
	private final int priority;
	
	public Node(E obj,int priority) {
		this.obj=obj;
		this.priority=priority;
	}
	
	public E getObj() {
		return obj;
	}
	
	public int getPriority() {
		return priority;
	}
	
    @Override
    public String toString() {
        return "(" + getObj() + ", " + getPriority() + ")";
    }
}
