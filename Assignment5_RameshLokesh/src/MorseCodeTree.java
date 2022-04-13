/**
 * MorseCodeTree
 * @author Lokesh Sankar Ramesh
 * implements LinkedConverterTreeInterface<String>
 */

import java.util.ArrayList;


public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	/**
	 * Calls the buildTree method
	 */
	public MorseCodeTree() {
		root = null;
		buildTree();
	}
	
	
	/**
	 * Returns a reference to the root
	 * 
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	
	
	/**
	 * sets the root of the MorseCodeTree
	 * 
	 * @param newNode - a newNode that will be the root of MorseCodeTree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
	
		root=new TreeNode<String>(newNode);
		
	}

	
	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * 
	 * @param code - the code for the new node to be added, example ".-."
	 * @param letter - the letter to be added
	 */
	@Override
	public void insert(String code, String letter) {
		if(root == null) {
			root = new TreeNode<String>(letter);
		} else {
			addNode(root, code, letter);
		}
	}

	
	/**
	 *  This is a recursive method that adds element to the correct position in the tree based on the code. 
	 * 
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() > 1) {
			if(code.charAt(0) == '-') {
				addNode(root.rightChild,code.substring(1),letter);
			} 
			else {
				addNode(root.leftChild,code.substring(1),letter);
			}
		} 
		else {
			if(code.equals(".")) {
				root.leftChild=new TreeNode<String>(letter);
			} 
			else {
				root.rightChild=new TreeNode<String>(letter);
			}
		}
		
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * 
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) { return fetchNode(root, code); }
	

	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code 
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 * The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
	 * 
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return string corresponding to code 
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String ltr = "";
		
		if (code.length() <= 1) {
			if(code.equals(".")) {
				return root.leftChild.getData();
			}
			else { 
				return root.rightChild.getData();
			}
		}
		else {
			if(code.charAt(0) == '.') {
				ltr += fetchNode(root.leftChild,code.substring(1));
			}
			else {
				ltr += fetchNode(root.rightChild,code.substring(1));
			}
		}
		
		return ltr;
	}

	
	/**
	 * This operation is not supported in the MorseCodeTree
	 * 
	 * @param data - data of node to be deleted
	 * @return reference to the current tree
	 * @throws java.lang.UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	

	/**
	 * This operation is not supported in the MorseCodeTree
	 * 
	 * @return reference to the current tree
	 * @throws java.lang.UnsupportedOperationException
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 */
	@Override
	public void buildTree() {
		
		insert("","");			//Root level

		insert(".","e"); 
		insert("-","t");		//Level 1
		
		insert("..","i"); 
		insert(".-","a");
		insert("-.","n"); 
		insert("--","m");		//Level 2
		
		insert("...","s"); 
		insert("..-","u");
		insert(".-.","r"); 
		insert(".--","w");
		insert("-..","d"); 
		insert("-.-","k");
		insert("--.","g"); 
		insert("---","o");		//Level 3
		
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c"); 
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");		//Level 4
	}

	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> linkedTree = new ArrayList<String>();
		LNRoutputTraversal(root, linkedTree);
		
		return linkedTree;
	}

	
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * 
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root == null) { return; }
		
		LNRoutputTraversal(root.leftChild, list);
		list.add(root.getData());
		LNRoutputTraversal(root.rightChild, list);
	}
}
