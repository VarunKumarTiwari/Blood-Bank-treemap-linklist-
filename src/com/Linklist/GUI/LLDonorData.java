package com.Linklist.GUI;

import java.io.Serializable;
import java.util.Iterator;

public class LLDonorData implements Serializable {
	private int AutoId;
	
	private String name;
	private String bGroup;
	private String Gender;
	private int Age;
	
	public int getAutoId() {
		return AutoId;
	}
	public void setAutoId(int autoId) {
		AutoId = autoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getbGroup() {
		return bGroup;
	}
	public void setbGroup(String bGroup) {
		this.bGroup = bGroup;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	
}
