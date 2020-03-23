package com.BBTL.GUI;


class BinarySearchTree {
	public int level = 0;
	
	private static   Nodes root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int key,String bsName,String bsGroup,String bsGender, int bsAge) {
		root = insertRec(root, key , bsName, bsGroup, bsGender, bsAge);
	}


	Nodes insertRec(Nodes root, int key,String bsName,String bsGroup,String bsGender,int bsAge) {

		if (root == null) {
			root = new Nodes(key,bsName, bsGroup, bsGender, bsAge);
			return root;
		}

		if (key < root.key) {
			root.left = insertRec(root.left, key, bsName, bsGroup, bsGender, bsAge);
		} else if (key > root.key)
			root.right = insertRec(root.right, key, bsName, bsGroup, bsGender, bsAge);

		return root;
	}


}
