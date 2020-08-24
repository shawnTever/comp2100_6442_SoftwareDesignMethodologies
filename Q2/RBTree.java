/**
 * Fill in the items below with your UID and name:
 * @author:
 * @UID:
 *
 * @param <T>
 */
public class RBTree {

	public Node root; // The root node of the tree

	/**
	 * Please implement this method
	 * You are allowed to define any additional helper methods
	 * 
	 * @return
	 */
	public int countBrokenNodes() {
		// TODO
		// START YOUR CODE


		// You are allowed to remove or change this default return value below
		return 0;

		// END YOUR CODE
	}

	/**
	 * Initialize empty RBTree
	 */
	public RBTree() {
		this.root = null;
	}

	/**
	 * Add a new node into the tree with {@code root} node.
	 * 
	 * @param root Node The root node of the tree where x is being inserted.
	 * @param x    Node New node being inserted.
	 */
	private void insertRecurse(Node root, Node x) {
		if (root.value.compareTo(x.value) > 0) {
			if (root.left.value == null) {
				root.left = x;
				x.parent = root;
			} else {
				insertRecurse(root.left, x);
			}
		} else if (root.value.compareTo(x.value) < 0) {
			if (root.right.value == null) {
				root.right = x;
				x.parent = root;
			} else {
				insertRecurse(root.right, x);
			}
		}
		// Do nothing if the tree already has a node with the same value.
	}

	/**
	 * Insert node into RBTree. Note that for checking properties, we do not need to
	 * have a complete RB tree. Here the insertion is the same as the binary tree.
	 * 
	 * @param x Node The new node being inserted into the tree.
	 */
	private void insert(Node x) {
		if (this.root == null) {
			this.root = x;
		} else {
			insertRecurse(this.root, x);
		}
	}

	/**
	 * Demo functions (Safely) insert a value into the tree
	 * 
	 * @param value The value of the new node being inserted.
	 */
	public void insert(Integer value) {
		Node node = new Node(value);
		if (node != null) {
			insert(node);
		}
	}

	/**
	 * Return the corresponding node of a value, if it exists in the tree
	 * 
	 * @param x Node The root node of the tree we search for the value {@code v}
	 * @param v Node The node that we are looking for
	 * @return
	 */
	private Node find(Node x, Integer v) {
		if (x.value == null) {
			return null;
		}

		int cmp = v.compareTo(x.value);
		if (cmp < 0)
			return find(x.left, v);
		else if (cmp > 0)
			return find(x.right, v);
		else
			return x;
	}

	/**
	 * Returns a node if the value of the node is {@code key}.
	 * 
	 * @param key The value we are looking for
	 * @return
	 */
	public Node search(Integer key) {
		return find(this.root, key);
	}
	
	public int sum(Node node) {
		if(node.value == null) {
			return 0;
		}
		
		return node.value + sum(node.left) + sum(node.right);
	}
	
	public class Node {

		Colour colour; // Node colour
		Integer value; // Node value
		Node parent; // Parent node
		Node left, right; // Children nodes
		boolean check; //This attribute can be useful for the online test question

		public Node(Integer value) {
			this.value = value;
			this.colour = Colour.BLACK;
			this.parent = null;
			this.check = false;

			// Initialise children leaf nodes
			this.left = new Node();
			this.right = new Node();
			this.left.parent = this;
			this.right.parent = this;
		}

		// Leaf node
		public Node() {
			this.value = null;
			this.colour = Colour.BLACK;
		}

		public void setColour(boolean red) {
			this.colour = red ? Colour.RED : Colour.BLACK;
		}
	}

	public enum Colour {
		RED, BLACK;
	}
}