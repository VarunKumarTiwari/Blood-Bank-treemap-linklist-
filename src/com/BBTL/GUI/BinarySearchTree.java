package com.BBTL.GUI;
class BinarySearchTree { 
public int level = 0;
	class Node { 
		int key; 
		Node left, right; 
	
		public Node(int item) { 
			
			key = item;
			left = right = null; 
		
		} 
	} 

	  static 
	Node root;

	 
	BinarySearchTree() { 
		root = null; 
	} 

	void insert(int key) { 
	root = insertRec(root, key); 
	} 
	
	Node insertRec(Node root, int key) { 

		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		if (key < root.key) 
		{
			root.left = insertRec(root.left, key); 
		}else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		return root; 
	} 

	void inorder() { 
	inorderRec(root); 
	} 
	
	
		void inorderRec(Node root) { 
		if (root != null) {

			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
			
		} 
	} 
	void printTree(Node node, String prefix)
	 {
	    if(node == null) return;
	    
	    
	    System.out.println(prefix + " + " + node.key);
	    printTree(node.left , prefix + " ");
	    printTree(node.right , prefix + " ");
	    
	    
	 }

	public static void main(String[] args) { 
		BinarySearchTree tree = new BinarySearchTree(); 

		/* Let us create following BST 
		  50 
		/	 \ 
	   30	 70 
	  / \   /  \ 
	20  40 60  80 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 

		//tree.inorder(); 
		tree.printTree(root, "");
		
	} 
} 
