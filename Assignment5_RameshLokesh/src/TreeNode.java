/**
 * TreeNode class
 * @author Lokesh Sankar Ramesh
 *
 * @param <T> - data type of TreeNode
 */


public class TreeNode<T> {
	private T data;
	protected TreeNode<T> leftChild, rightChild;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * 
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode; leftChild = null; rightChild = null;
	}
	
	
	/**
	 * Creates new node with given data
	 * 
	 * @param left left child
	 * @param right right child
	 * @param info data stores in the node
	 */
	public TreeNode(TreeNode<T> left,TreeNode<T> right,T info) {		
		data = info;
		leftChild = new TreeNode<T>(left);
		rightChild = new TreeNode<T>(right);
	}
	
	
	/**
	 * used for making deep copies
	 * 
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		this(node.leftChild, node.rightChild, node.getData());
	}
	
	

	
	
	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 */
	public T getData() { return data; }

}


