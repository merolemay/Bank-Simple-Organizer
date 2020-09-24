package BTS;
import java.util.LinkedList;
import java.util.Queue;

public class BTS<T> {
	
	private Node<T> root;
	
	
	/**
	 *  Adds a new Node to the BTS using recursive insertion  bases on his value.
	 *  <pre> The value most not be repeated </pre>
	 * @param value : Is the value of the node.
	 */
	public void addNode(T value) {
		root=addNodeRecursive(root, value);
	}
	
	
	
	/** This method is the recursive part of the method "AddNode".
	 * @param current : The current node in which we are in the tree.
	 * @param value : The value of the node that is going to be added.
	 * @return : The recursive return.
	 */
	public Node<T> addNodeRecursive(Node<T> current,T value) {	
		if(current==null) {
		return new Node<T> (value);
		} 
		
		if((Integer)value < (Integer)current.getValue()) {
			current.nodeLeft = addNodeRecursive(current.nodeLeft,value);
		}
		
		else if((Integer)value > (Integer)current.getValue()) {
			current.nodeRight = addNodeRecursive(current.nodeRight,value);
		} else {
			//The value exist
			return current;
		}
	
		return current;
	}
	
	/** Recursive Method for deleting a Node with no children of the BTS.
	 * @param current : Current position in the tree.
	 * @param value : Value of the Node which is going to be deleted.
	 * @return : Returns the Node as a null when is deleted o a system out print if the node has children.
	 */
	public Node<T> deleteRecursive(Node<T> current,T value) {
		if (current == null) {
	        return null;
	    }
	 
	    if (value == current.getValue()) {
	    	if(current.nodeLeft==null && current.nodeRight==null) {
	    		current=null;
	    		deleteRecursive(current, value);
	    	} else {
	    		System.out.println("This node can't be deleted because has chilndrens");
	    		return null;
	    	}
	    } 
	    if ((Integer)value < (Integer)current.getValue()) {
	        current.nodeLeft = deleteRecursive(current.nodeLeft, value);
	        return current;
	    }
	    current.nodeRight = deleteRecursive(current.nodeRight, value);
	    return current;
		
	}
	
	/** The in-order traversal consists of first visiting the left sub-tree, then the root node, 
	 * and finally the right sub-tree.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in  order.
	 */
	public String traverseInOrder(Node<T> node) {
		String report="";
	    if (node != null) {
	        traverseInOrder(node.nodeLeft);
	        report +=" " + node.getValue();
	        traverseInOrder(node.nodeRight);
	    }
	    
	    return report;
	}
	
	/** Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in pre-order.
	 */
	public String traversePreOrder(Node<T> node) {
		String report="";
	    if (node != null) {
	    	report +=" " + node.getValue();
	        traverseInOrder(node.nodeLeft);
	        traverseInOrder(node.nodeRight);
	    }
	    
	    return report;
	}
	
	/** Post-order traversal visits the left subtree, the right subtree, and the root node at the end.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in Post-order.
	 */
	public String traversePostOrder(Node<T> node) {
		String report="";
	    if (node != null) {
	        traverseInOrder(node.nodeLeft);
	        traverseInOrder(node.nodeRight);
	        report +=" " + node.getValue();
	    }
	    
	    return report;
	}
	
	/** Breadth-First Search : visits all the levels of the tree starting from the root, and from left to right.
	 * @return : A list of the nodes in order for levels.
	 */
	public String traverseLevelOrder() {
		String report="";
	    if (root == null) {
	        return "";
	    }
	 
	    Queue<Node<T>> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	 
	        Node<T> node = nodes.remove();
	 
	        report += " " + node.getValue();
	 
	        if (node.nodeLeft != null) {
	            nodes.add(node.nodeLeft);
	        }
	 
	        if (node.nodeRight != null) {
	            nodes.add(node.nodeRight);
	        }
	    }
	    return report;
	}
}

