import java.io.* ;
import java.util.*;

class Node {
	int value;
	Node left , right;

	Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}

class Tree {

	public Node insert(Node root, int value) {
		if(root == null) {
			root = new Node(value);
			return root;
		}

		if(value < root.value)
			root.left = insert(root.left, value);
		else if (value > root.value)
			root.right = insert(root.right,value);
	return root;
		
	}

	public void Traverseorder(Node node){
		if(node != null) {
		Traverseorder(node.left);
		System.out.println(node.value);
		Traverseorder(node.right);
		}
	}

	
}

class bst {
	public static void main (String args[]) {
		Tree tree = new Tree();
		Node root = null;
		root = tree.insert(root,9);
		root = tree.insert(root,4);
		root = tree.insert(root,10);
		tree.Traverseorder(root);




	}
}