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

	static Node root;

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

		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key)
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
	public static void printBinaryTree(Node root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.key);
	    }
	    else
	        System.out.println(root.key);
	    printBinaryTree(root.left, level+1);
	} 

	public static void main(String[] args) {
		boolean flag = true;
		BinarySearchTree tree = new BinarySearchTree();
		int arr[] = new int[30] ;
		int id = (int) (Math.random() * (1 - 30) + 30);
		for(int i=0;i<arr.length;i++)
		{
			 if(arr[i]==id)
			 {
				 flag = false;
			 }
		}
//		if()
//		{
//			
//		}
		
		//Collections.shuffle(Arrays.asList(arr));
		System.out.println(arr);
		//Collections.shuffle(Arrays.asList(arr));
		/*
		 * Let us create following BST 
		 * 50 
		 * / \ 
		* 30 70 
	 *   / \ / \ 
	 * 20 40 60 80
		 */
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);
//		tree.insert(90);
//		
//		tree.insert(66);
//		tree.insert(100);
//		tree.insert(90);
	   // tree.inorder();
		
		tree.printBinaryTree(root,0);

	}
}
