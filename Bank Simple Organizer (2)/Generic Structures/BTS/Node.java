package BTS;

public class Node<T> {
	
	private T value;
	public Node<T> nodeLeft;
	public Node<T> nodeRight;
	
	
	//Simple Node Constructor
	public Node(T value) {
		this.value=value;
	}

	/**
	 * <pre> value != null </pre>
	 * @return the value 
	 * 
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}


	
	
}
