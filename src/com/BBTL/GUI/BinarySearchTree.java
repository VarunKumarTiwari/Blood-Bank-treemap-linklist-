package com.BBTL.GUI;


class BinarySearchTree {
	public int level = 0;
	class Node {
		int key;
		Node left, right;
		String bsName,bsGroup,bsGender;
		int bsAge;
		public Node(int item, String name, String bGroup, String gender,int age) {
			key = item;
			bsName=name;
			bsGroup=bGroup;
			bsGender = gender;
			bsAge = age;
			left = right = null;

		}
	}

	static Node root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int key,String bsName,String bsGroup,String bsGender, int bsAge) {
		root = insertRec(root, key , bsName, bsGroup, bsGender, bsAge);
	}


	Node insertRec(Node root, int key,String bsName,String bsGroup,String bsGender,int bsAge) {

		if (root == null) {
			root = new Node(key,bsName, bsGroup, bsGender, bsAge);
			return root;
		}

		if (key < root.key) {
			root.left = insertRec(root.left, key, bsName, bsGroup, bsGender, bsAge);
		} else if (key > root.key)
			root.right = insertRec(root.right, key, bsName, bsGroup, bsGender, bsAge);

		return root;
	}

	public static void printBinaryTree(Node root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.key+" "+root.bsName);
	    }
	    else
	        System.out.println(root.key+" "+root.bsName);
	    printBinaryTree(root.left, level+1);
	} 

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		/*
		 * Let us create following BST 
		 * 50 
		 * / \ 
		* 30 70 
	 *   / \ / \ 
	 * 20 40 60 80
		 */
		tree.insert(50,"varun","B+","male",18);
		tree.insert(30,"varun","B+","male",18);
		tree.insert(20,"varun","B+","male",18);
		tree.insert(40,"varun","B+","male",18);
		tree.insert(70,"varun","B+","male",18);
		tree.insert(60,"varun","B+","male",18);
		tree.insert(80,"varun","B+","male",18);
		tree.insert(90,"Ayushi","B+","male",18);
//		
//		tree.insert(66);
//		tree.insert(100);
//		tree.insert(90);
	   // tree.inorder();
		
		tree.printBinaryTree(root,0);

	}
}
