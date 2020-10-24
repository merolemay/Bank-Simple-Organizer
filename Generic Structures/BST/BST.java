package BST;
import java.util.LinkedList;
import java.util.Queue;


public class BST<E,K extends Comparable<? super K>>{

	private Node<E,K> root;
	
	
	
	public E search(K key) {
		if(root.getKey().equals(key)) {
			return root.getElement();
		} else {
			return searchRecursive(root,key);
		}
			
	}
	
	private E searchRecursive(Node<E,K> current,K key) {
	
	    if (key == current.getKey()) {
	    	return current.getElement();
	    } 
	    if ((Integer)key < (Integer)current.getKey() && current.nodeLeft!=null) {
	        return searchRecursive(current.nodeLeft,key);
	    }else {
	    	return searchRecursive(current.nodeRight,key);
	    }
		
	}
	/**
	 *  Adds a new Node to the BTS using recursive insertion  bases on his value.
	 *  <pre> The value most not be repeated </pre>
	 * @param value : Is the value of the node.
	 */
	public void add(Node<E,K> current) {
		root=addNodeRecursive(root,current.getElement(), current.getKey());
	}
	
	
	
	/** This method is the recursive part of the method "AddNode".
	 * @param current : The current node in which we are in the tree.
	 * @param value : The value of the node that is going to be added.
	 * @return : The recursive return.
	 */
	private Node<E,K> addNodeRecursive(Node<E,K> current,E element,K key) {	
		
		if(current==null) {
		return new Node<E,K> (element,key);
		} 
		
		if(key.compareTo(current.getKey())>0) {
			current.nodeLeft = addNodeRecursive(current.nodeLeft,element,key);
		}
		
		else if(key.compareTo(current.getKey())<0) {
			current.nodeRight = addNodeRecursive(current.nodeRight,element,key);
		} else {
			//The value exist
			return current;
		}
	
		return current;
	}
	public boolean delete(K key) {
		if(key.equals(root.getKey())) {
			if(root.nodeLeft==null && root.nodeRight==null) {
				root=null;
				return true;
			} else
				return false;
		}
		else {
			return (deleteRecursive(root,key).equals(null))?true:false;
		}
	}
	/** Recursive Method for deleting a Node with no children of the BTS.
	 * @param current : Current position in the tree.
	 * @param value : Value of the Node which is going to be deleted.
	 * @return : Returns the Node as a null when is deleted o a system out print if the node has children.
	 */
	private Node<E,K> deleteRecursive(Node<E,K> current,K key) {
		if (current == null) {
	        return null;
	    }
	 
	    if (key == current.getKey()) {
	    	if(current.nodeLeft==null && current.nodeRight==null) {
	    		current=null;
	    		deleteRecursive(current, key);
	    	} else {
	    		System.out.println("This node can't be deleted because has chilndren");
	    		return null;
	    	}
	    } 
	    if ((Integer)key < (Integer)current.getKey()) {
	        current.nodeLeft = deleteRecursive(current.nodeLeft, key);
	        return current;
	    }
	    current.nodeRight = deleteRecursive(current.nodeRight, key);
	    return current;
		
	}
	
	/** The in-order traversal consists of first visiting the left sub-tree, then the root node, 
	 * and finally the right sub-tree.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in  order.
	 */
	public String traverseInOrder(Node<E,K> node) {
		String report="";
	    if (node != null) {
	        traverseInOrder(node.nodeLeft);
	        report +=" " + node.getElement();
	        traverseInOrder(node.nodeRight);
	    }
	    
	    return report;
	}
	
	/** Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in pre-order.
	 */
	public String traversePreOrder(Node<E,K> node) {
		String report="";
	    if (node != null) {
	    	report +=" " + node.getElement();
	        traverseInOrder(node.nodeLeft);
	        traverseInOrder(node.nodeRight);
	    }  
	    return report;
	}
	
	/** Post-order traversal visits the left subtree, the right subtree, and the root node at the end.
	 * @param node : Root of the tree.
	 * @return : the list of nodes in the tree in Post-order.
	 */
	public String traversePostOrder(Node<E,K> node) {
		String report="";
	    if (node != null) {
	        traverseInOrder(node.nodeLeft);
	        traverseInOrder(node.nodeRight);
	        report +=" " + node.getElement();
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
	 
	    Queue<Node<E,K>> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	 
	    	Node<E,K> node = nodes.remove();
	 
	        report += " " + node.getElement();
	 
	        if (node.nodeLeft != null) {
	            nodes.add(node.nodeLeft);
	        }
	 
	        if (node.nodeRight != null) {
	            nodes.add(node.nodeRight);
	        }
	    }
	    return report;
	}
	
	public Node<E,K> getRoot() {
		return root;
	}
}

