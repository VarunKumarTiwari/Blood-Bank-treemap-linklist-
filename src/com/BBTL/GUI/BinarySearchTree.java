package com.BBTL.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

class BinarySearchTree {

	public int level = 0;

	private static Nodes root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int key, String bsName, String bsGroup, String bsGender, int bsAge) {
		root = insertRec(root, key, bsName, bsGroup, bsGender, bsAge);
	}

	Nodes insertRec(Nodes root, int key, String bsName, String bsGroup, String bsGender, int bsAge) {

		if (root == null) {
			root = new Nodes(key, bsName, bsGroup, bsGender, bsAge);
			return root;
		}

		if (key < root.key) {
			root.left = insertRec(root.left, key, bsName, bsGroup, bsGender, bsAge);
		} else if (key > root.key)
			root.right = insertRec(root.right, key, bsName, bsGroup, bsGender, bsAge);

		return root;
	}

	public Nodes searchRec(Nodes root, int key) {

		List<List> Data = new ArrayList<List>();
		ArrayList<String> stringData = new ArrayList<String>();
		ArrayList<Integer> integerData = new ArrayList<Integer>();
		if(root == null)
		{
			JOptionPane.showMessageDialog(null, "tree is empty");
		}
		if (root == null || root.key == key) {
			integerData.add(root.key);
			stringData.add("Donor Name"+root.bsName);
			stringData.add("Donor blood group"+root.bsGroup);
			stringData.add("Donor gender"+root.bsGender);
			integerData.add(root.bsAge);
			Data.add(0,integerData);
			Data.add(1, stringData);
			return root;
		}

		if (root.key > key)
			return searchRec(root.left, key);

		return searchRec(root.right, key);

	}
	public Nodes deleteRec(Nodes root, int key) 
    { 
      
        if (root == null) { 
        	JOptionPane.showMessageDialog(null, "tree is empty");
        	return root; 
        }
      
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
        else
        { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
            root.key = atmostleft(root.right); 
  
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    }

	private int atmostleft(Nodes root) {
		    { 
		        int minv = root.key; 
		        while (root.left != null) 
		        { 
		            minv = root.left.key; 
		            root = root.left; 
		        } 
		        return minv; 
		    }
	
    
	}

}
