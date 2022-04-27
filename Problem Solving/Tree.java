import java.util.*;

class NodeTree {
	int data;
	NodeTree left;
	NodeTree right;
	
	NodeTree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class Tree {
	
	NodeTree root;
    Scanner sc = new Scanner(System.in);
    
    NodeTree BinaryTree(NodeTree root, int data) {
    	if(root == null)
    		root = new NodeTree(data);
    	else if(data > root.data)
    		root.right = BinaryTree(root.right,data);
    	else if(data < root.data)
    		root.left = BinaryTree(root.left,data);
    	else
    		System.out.println("Value is already entered");
    	
    	return root;
    		
    }
    
    void PrintTree(NodeTree root) {
    	if(root == null)
    		return;
    	PrintTree(root.left);
    	System.out.print(root.data + " ");
    	PrintTree(root.right);
    }

	
	void InsertElement() {
		System.out.println("Enter the element to insert");
		int data = sc.nextInt();
		root = BinaryTree(root,data);
		PrintTree(root);
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Tree t = new Tree();
		System.out.println("Enter 1 - Insert \n 2- Exit");
		int ch = sc.nextInt();
		while(ch != 2) {
			t.InsertElement();	
		}
		/*System.out.println("Press 1- vertical view");
		int view = sc.nextInt();
		switch(view) {
		case 1 : 
		} */

	}

}
