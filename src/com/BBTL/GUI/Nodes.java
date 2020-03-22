package com.BBTL.GUI;


class Nodes {
	int key;
	Nodes left, right;
	String bsName,bsGroup,bsGender;
	int bsAge;
	public Nodes(int item, String name, String bGroup, String gender,int age) {
		key = item;
		bsName=name;
		bsGroup=bGroup;
		bsGender = gender;
		bsAge = age;
		left = right = null;

	}
}
