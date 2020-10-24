package BST;

@SuppressWarnings("serial")
public class BSTAvl<E  extends Comparable<E>,K extends Comparable<? super K>> extends BST<E,K>  {
	
	

	private Node<E,K> root;
	
	public BSTAvl() {
		
	}
	
	@Override
	public void addNode(Node<E, K> current) {
		super.addNode(current);
	}
	
	
	@Override
	public Node<E, K> getRoot() {
		return super.getRoot();
	}
}
