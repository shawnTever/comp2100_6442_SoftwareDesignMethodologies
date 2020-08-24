/*
 * Given a binary search tree, implement a method to find the sum of the values of all the nodes that have an odd number of direct children. You can define additional methods of BST and Node classes to complete the task. The method signature is: public Integer oddNodeSum()
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class BST {
	
	Node root;

	/**
	 * Please implement this method and feel free to add additional helper methods
	 * @return
	 */
	public void preOrder(Node root, ArrayList<Node> arrayList) {
		if (root != null) {
			arrayList.add(root);
			if (root.left != null) {
				preOrder(root.left, arrayList);
			}
			if (root.right != null) {
				preOrder(root.right, arrayList);
			}
		}
	}

	public Integer oddNodeSum() {
		// START YOUR CODE
		int value = 0;
		ArrayList<Node> arrayList = new ArrayList<>();
		preOrder(root, arrayList);
		for (Node node : arrayList) {
			if ((node.right != null && node.left == null)
				|| (node.right == null && node.left != null))
				value += node.value;
		}
		return value; //you are allowed to change this return statement
		// END YOUR CODE
	}
	
	public BST() {
		this.root = null;
	}

	/**
	 * This implementation of insert follows the pseudo code in the lecture slide.
	 * Node that we did not use recursion here.
	 * 
	 * @param value value of inserted node
	 * @return inserted node (not the entire tree)
	 */
	public Node insert(Integer value) {
		Node parent = null;
		Node current = this.root;
		while (current != null) {
			if(current.value.compareTo(value) < 0) {
				parent = current;
				current = current.right;
			}else if (current.value.compareTo(value) > 0){
				parent = current;
				current = current.left;
			}
		}
		
		if (parent == null && current == null) {
			this.root = new Node(value);  // no parent = root is empty
			return root;
		}else {
			Node newNode = new Node(value);
			
			if(parent.value.compareTo(value) < 0) {
				parent.right = newNode;
				newNode.parent = parent;
			}else if(parent.value.compareTo(value) > 0) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			return newNode;
		}
	}
	
	public class Node {

		Integer value;
		Node parent;
		Node left;
		Node right;

		public Node(Integer value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(5);
		tree.insert(3);
		tree.insert(1);
		tree.insert(4);
		tree.insert(10);
		tree.insert(6);
		tree.insert(12);
		ArrayList<Node> arrayList = new ArrayList<>();
		tree.preOrder(tree.root, arrayList);
		for (Node node : arrayList) {
			System.out.println(node.value);
		}
	}
}