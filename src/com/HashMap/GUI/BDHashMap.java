package com.HashMap.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDHashMap {

	HashMap<Integer,DonorData> map = new HashMap<Integer, DonorData>();

	
	public void insertRec(int AutoID, String name, String bGroup, String Gender, int age)
	{
		DonorData dData = new DonorData();
		dData.setName(name);
		dData.setbGroup(bGroup);
		dData.setGender(Gender);
		dData.setAge(age);
		
		map.put(AutoID,dData);
	}
	
	public DonorData searchRec(int id) {
		return map.get(id);
	}
	
	public void printRec()
	{
		 map.forEach((key, value) -> System.out.println(key + "Name : " + value.getName()+"bGroup : "+
	value.getbGroup()+" Gender : "+value.getGender()+" Age : "+value.getAge()));
	}
	public static void main(String[] args) {
//		print(map);
//		map.put("vishal", 10);
//		map.put("sachin", 30);
//		map.put("vaibhav", 20);
//
//		System.out.println("Size of map is:- " + map.size());
//
//		print(map);
//		if (map.containsKey("vishal")) {
//			Integer a = map.get("vishal");
//			System.out.println("value for key" + " \"vishal\" is:- " + a);
//		}
//
//		map.clear();
//		print(map);
//	}
//
//	public static void print(Map<String, Integer> map) {
//		if (map.isEmpty()) {
//			System.out.println("map is empty");
//		}
//
//		else {
//			System.out.println(map);
//		}
	}
	
}