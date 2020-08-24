import java.util.ArrayList;

/*
 * Implement a checking function in Red-Black Tree to check if the following properties hold:
The root and leaf (NIL) nodes are black
If a node is red, then its parent is black
You can define additional methods if you need to implement testProp1 and testProp2 methods. The methods signatures are:
public boolean testProp1()
public boolean testProp2() 
 */
public class RBTree<T extends Comparable<T>> {

	public Node<T> root; // The root node of the tree

	/**
	 * Please implement this method and feel free to add additional helper methods
	 * @return
	 */
	public void postOrder(Node root, ArrayList<Node> arrayList) {
		if (root != null) {
			if (root.left != null) {
				postOrder(root.left, arrayList);
			}
			if (root.right != null) {
				postOrder(root.right, arrayList);
			}
			arrayList.add(root);
		}
	}

	public boolean testProp1() {
		// START YOUR CODE
		ArrayList<Node> arrayList = new ArrayList<>();
		postOrder(root, arrayList);
		for (Node node : arrayList) {
			if (node.value == root.value)
				return node.colour == Colour.BLACK;
			else if (node.left == null && node.right == null)
				return node.colour == Colour.BLACK;
			else {
				if (node.colour == Colour.BLACK)
					if (node.left != null) return node.left.colour == Colour.RED;
					else if (node.right != null) return node.right.colour == Colour.RED;
				else if (node.colour == Colour.RED)
					if (node.left != null) return node.left.colour == Colour.BLACK;
					else if (node.right != null) return node.right.colour == Colour.BLACK;
			}

		}
		return false; //you are allowed to change this return statement
		// END YOUR CODE
	}

	/**
	 * Please implement this method and feel free to add additional helper methods
	 * @return
	 */
	public boolean testProp2() {
		// START YOUR CODE
		
		return true; //you are allowed to change this return statement
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
	 * @param root Node<T> The root node of the tree where x is being inserted.
	 * @param x    Node<T> New node being inserted.
	 */
	private void insertRecurse(Node<T> root, Node<T> x) {
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
	 * @param x Node<T> The new node being inserted into the tree.
	 */
	private void insert(Node<T> x) {
		if (this.root == null) {
			this.root = x;
		} else {
			insertRecurse(this.root, x);
		}
	}

	/**
	 * Demo functions (Safely) insert a value into the tree
	 * 
	 * @param value T The value of the new node being inserted.
	 */
	public void insert(T value) {
		Node<T> node = new Node<T>(value);
		if (node != null) {
			insert(node);
		}
	}

	/**
	 * Return the corresponding node of a value, if it exists in the tree
	 * 
	 * @param x Node<T> The root node of the tree we search for the value {@code v}
	 * @param v Node<T> The node that we are looking for
	 * @return
	 */
	private Node<T> find(Node<T> x, T v) {
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
	 * @param key T The value we are looking for
	 * @return
	 */
	public Node<T> search(T key) {
		return find(this.root, key);
	}
	
	public class Node<E extends Comparable<E>> {
		
		Colour colour; // Node colour
		E value; // Node value
		Node<E> parent; // Parent node
		Node<E> left, right; // Children nodes

		public Node(E value) {
			this.value = value;
			this.colour = Colour.BLACK;
			this.parent = null;

			// Initialise children leaf nodes
			this.left = new Node<E>();
			this.right = new Node<E>();
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


	public static void main(String[] args) {
		RBTree tree = new RBTree<Integer>();

		tree.insert(7);
		tree.insert(3);
		tree.insert(1);
		tree.insert(0);
		tree.insert(2);
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(11);
		tree.insert(9);
		tree.insert(8);
		tree.insert(10);
		tree.insert(15);
		tree.insert(13);
		tree.insert(12);
		tree.insert(14);
		tree.insert(17);
		tree.insert(16);
		tree.insert(18);
		tree.insert(19);
	}
}